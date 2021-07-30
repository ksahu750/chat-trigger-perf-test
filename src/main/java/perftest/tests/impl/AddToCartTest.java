package perftest.tests.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import perftest.annotation.Order;
import perftest.tests.PerfTest;

@Order(2)
public class AddToCartTest extends PerfTest {

  public AddToCartTest(WebDriver driver) {
    super(driver);
  }

  @Override
  public void test() {
    final WebElement addToCartButton =
        driver.findElement(By.xpath("//*[@id=\"addToCart-product-template\"]"));
    addToCartButton.click();
  }

}
