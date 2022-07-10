package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends  BasePage{

    private String userName = "standard_user";
    private String password = "secret_sauce";
    private String url;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.url = "https://www.saucedemo.com/";
    }

    public LoginPage() {}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void login () {
        this.getInpUserName().sendKeys(userName);
        this.getInpPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getInpUserName() {
        return driver.findElement(By.id("user-name"));
    }


    public WebElement getInpPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getBtnLogin() {
        return driver.findElement(By.id("login-button"));
    }


    public void openPage() {
        driver.get(this.url);
        driver.manage().window().maximize();
    }

    public void setUserName(String userName) {
        this.getInpUserName().sendKeys(userName);
    }

    public void setPassword(String password) {
        this.getInpPassword().sendKeys(password);
    }

    public void clickOnLogin() {
        /*WebElement btnLogin = this.getBtnLogin();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));*/

        this.getBtnLogin().click();
    }

    public void closePage() {
        driver.close();
        driver.quit();
    }

}
