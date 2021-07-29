package perftest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.reflections.Reflections;
import perftest.annotation.IgnoreTest;
import perftest.tests.PerfTest;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ChatTriggerPerfTest {
  private static final WebDriver DRIVER = getWebDriver();
  private static final String TIME_TAKEN = "Time taken for - %s : %d ms%n";

  public static void main(String[] args) {
    final Set<PerfTest> perfTests = getPerfTests();
    try {
      runTests(perfTests);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      DRIVER.quit();
    }
  }

  private static Set<PerfTest> getPerfTests() {
    final Reflections reflections = new Reflections("perftest.tests");
    final Set<Class<? extends PerfTest>> perfTestImplClasses =
        reflections.getSubTypesOf(PerfTest.class);
    return perfTestImplClasses.stream().map(perfTestImplClass -> {
      PerfTest perfTest = null;
      if (perfTestImplClass.isAnnotationPresent(IgnoreTest.class)) {
        System.out.printf("Ignoring %s%n", perfTestImplClass.getSimpleName());
      } else {
        try {
          perfTest = perfTestImplClass.getConstructor(WebDriver.class).newInstance(DRIVER);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
          e.printStackTrace();
        }
      }
      return perfTest;
    }).filter(Objects::nonNull).collect(Collectors.toSet());
  }

  private static void runTests(Set<PerfTest> perfTests) {
    perfTests.forEach(ChatTriggerPerfTest::runTest);
  }

  private static void runTest(PerfTest perfTest) {
    final Instant start = Instant.now();
    perfTest.test();
    final Instant end = Instant.now();
    final long timeTaken = Duration.between(start, end).toMillis();
    System.out.printf(TIME_TAKEN, perfTest.getClass().getSimpleName(), timeTaken);
  }

  private static WebDriver getWebDriver() {
    System.setProperty("webdriver.chrome.driver", "/Users/kunalsahu/Downloads/chromedriver");
    ChromeOptions options = new ChromeOptions()
        .setBinary("/Applications/Brave Browser.app/Contents/MacOS/Brave Browser");
    return new ChromeDriver(options);
  }

}
