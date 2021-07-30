package perftest.tests.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import perftest.annotation.Order;
import perftest.tests.PerfTest;

@Order(1)
public class PageLoadTest extends PerfTest {

  public PageLoadTest(WebDriver driver) {
    super(driver);
  }

  @Override
  public void test() {
    driver.get("https://theengatistore.com/collections/home-kitchen-appliances/products/samsung-28"
        + "-liters-mc28h5025vs-tl-convection-microwave-oven");
    wait.until(ExpectedConditions
        .visibilityOfElementLocated(By.xpath("//*[@id=\"engt-launcher" + "-button\"]")));
  }

}
