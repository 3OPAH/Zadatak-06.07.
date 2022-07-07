package Tests;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testovi extends BaseTest{

    @Test
    public static void verifyAddCheapestProduct () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login();

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.isDisplayed(), true, "Login failed");
        String cheapest = productsPage.addCheapestItem();

        CartPage cartPage = new CartPage(driver);
        cartPage.openPage();

        Assert.assertEquals(cartPage.verifyItem(cheapest), true);

    }

    @Test
    public static void verifyAddMostExpensiveProduct () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login();

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.isDisplayed(), true, "Login failed");
        String expensive = productsPage.addMostExpensiveItem();

        CartPage cartPage = new CartPage(driver);
        cartPage.openPage();

        Assert.assertEquals(cartPage.verifyItem(expensive), true);

    }
}
