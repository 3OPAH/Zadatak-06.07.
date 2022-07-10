package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class CartPage extends BasePage{

    private String url;

    public CartPage(WebDriver driver) {
        super(driver);
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

    public HashMap<String, Integer> verifyItemNumberInCart () {

        HashMap<String, Integer> returnValue = new HashMap<>();
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));

        for (int i = 0; i < cartItems.size(); i++){
            String cartItem = cartItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_name']")).getText();
            if (returnValue.containsKey(cartItem)){
                int tempCount = returnValue.get(cartItem);
                returnValue.put(cartItem, tempCount + 1);
            }
            else{
                returnValue.put(cartItem, 1);
            }

        }

        return returnValue;
    }

    public void closePage() {
        driver.quit();
    }
}
