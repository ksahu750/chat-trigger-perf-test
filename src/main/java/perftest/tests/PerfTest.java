package perftest.tests;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public abstract class PerfTest {

  protected final WebDriver driver;
  protected final Wait<WebDriver> wait;

  public PerfTest(WebDriver driver) {
    this.driver = driver;
    this.wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15))
        .pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
  }

  public abstract void test();

  protected static void sleep(long ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
