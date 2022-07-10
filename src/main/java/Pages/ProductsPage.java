package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage{

    private String url;


    public ProductsPage(WebDriver driver) {
        super(driver);
        this.url = "https://www.saucedemo.com/inventory.html";
    }

    public ProductsPage(){}


    public void setDriver(WebDriver driver) {
        driver = driver;
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


    public WebElement getCheapestItem (){
        List<WebElement> listInventoryItems = driver.findElements(By.className("inventory_item"));

        double lowestPrice = Double.parseDouble(listInventoryItems.get(0).findElement(
                By.xpath(".//div[@class='inventory_item_price']")).getText().substring(1));

        WebElement lowestPriceItem = null;

        for (int i = 1; i < listInventoryItems.size(); i++) {
            Double price = Double.parseDouble(listInventoryItems.get(i).findElement(
                    By.xpath(".//div[@class='inventory_item_price']")).getText().substring(1));
            if (price < lowestPrice){
                lowestPrice = price;
                lowestPriceItem = listInventoryItems.get(i);
            }
        }
        return lowestPriceItem;

    }
    public String addCheapestItem (WebElement item){

        if (item.findElement(By.xpath(".//button")).getText().equals("ADD TO CART")) {
            item.findElement(By.xpath(".//button")).click();
        }else{
            System.out.println("item is already in cart");
        }
        return item.findElement(By.xpath(".//div[@class='inventory_item_name']")).getText();
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
