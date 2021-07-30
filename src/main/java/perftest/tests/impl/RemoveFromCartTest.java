package perftest.tests.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import perftest.annotation.Order;
import perftest.tests.PerfTest;

@Order(3)
public class RemoveFromCartTest extends PerfTest {

  public RemoveFromCartTest(WebDriver driver) {
    super(driver);
  }

  @Override
  public void test() {
    final WebElement addToCartButton =
        driver.findElement(By.xpath("//*[@id=\"addToCart-product-template\"]"));
    addToCartButton.click();
    final WebElement reduceQuantityButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//*[@id=\"ajaxifyCart\"]/form/div[1]/div/div[2]/div/div[3]/a")));
    reduceQuantityButton.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/h2")));
  }

}
