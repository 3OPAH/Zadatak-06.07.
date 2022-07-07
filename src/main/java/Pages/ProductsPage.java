package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage{

    private WebDriver driver;
    private String url;


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.url = "https://www.saucedemo.com/inventory.html";
    }

    public ProductsPage(){}

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void openPage() {
        driver.get(this.url);
        driver.manage().window().maximize();
    }

    public Boolean isDisplayed() {

        WebElement classTitle = driver.findElement(By.className("title"));

        return classTitle.isDisplayed();
    }

    private WebElement getSortContainer() {
        return driver.findElement(By.xpath(".//select[@class='product_sort_container']"));
    }

    private WebElement getItemFromList(String value) {
        return driver.findElement(By.xpath(".//option[text()='" + value + "']"));
    }

    public void  sortItemsBy(String value) {
        this.getSortContainer().click();
        this.getItemFromList(value).click();
    }

    public String addCheapestItem (){

        this.sortItemsBy("Price (low to high)");

        List<WebElement> listInventoryItems = driver.findElements(By.className("inventory_item"));
        listInventoryItems.get(0).findElement(By.xpath(".//button")).click();

        return listInventoryItems.get(0).findElement(By.xpath(".//div[@class='inventory_item_name']")).getText();
    }

    public String addMostExpensiveItem (){

        this.sortItemsBy("Price (high to low)");

        List<WebElement> listInventoryItems = driver.findElements(By.className("inventory_item"));
        listInventoryItems.get(0).findElement(By.xpath(".//button")).click();

        return listInventoryItems.get(0).findElement(By.xpath(".//div[@class='inventory_item_name']")).getText();
    }

    public void closePage() {
        driver.quit();
    }

}
