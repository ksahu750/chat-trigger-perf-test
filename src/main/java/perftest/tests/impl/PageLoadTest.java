package perftest.tests.impl;

import org.openqa.selenium.WebDriver;
import perftest.annotation.IgnoreTest;
import perftest.tests.PerfTest;

@IgnoreTest
public class PageLoadTest extends PerfTest {

  public PageLoadTest(WebDriver driver) {
    super(driver);
  }

  @Override
  public void test() {
    driver.get("https://theengatistore.com/");
  }

}
