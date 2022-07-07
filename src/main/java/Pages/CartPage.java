package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{

    private WebDriver driver;
    private String url;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.url = "https://www.saucedemo.com/cart.html";
    }

    public CartPage() {}

    public String getUrl() {
        return url;
    }

    public void openPage () {
        driver.get(this.url);
    }

    public boolean verifyItem (String itemName) {
        boolean returnValue = false;

        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));

        for (int i = 0; i < cartItems.size(); i++){
            String cartItem = cartItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_name']")).getText();
            if (itemName.equals(cartItem)){
                returnValue = true;
                break;
            }
        }

        return returnValue;
    }

    public void closePage() {
        driver.quit();
    }
}