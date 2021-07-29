package perftest.tests.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import perftest.annotation.IgnoreTest;
import perftest.tests.PerfTest;

@IgnoreTest
public class AddToCartTest extends PerfTest {

  public AddToCartTest(WebDriver driver) {
    super(driver);
  }

  @Override
  public void test() {
    driver.get("https://theengatistore.com/collections/home-kitchen-appliances/products/samsung-28"
        + "-liters-mc28h5025vs-tl-convection-microwave-oven");
    final WebElement addToCartButton =
        driver.findElement(By.xpath("//*[@id=\"addToCart-product-template\"]"));
    addToCartButton.click();
  }

}
