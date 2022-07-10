package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static WebDriver driver;
    protected String url;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C://Users//3OPAH//JavaBiblioteke/chromedriver.exe");
        this.driver = new ChromeDriver();

    }

    @AfterClass
    public void afterClass() {
        this.driver.quit();
    }

    public String getUrl() {
        return url;
    }
}