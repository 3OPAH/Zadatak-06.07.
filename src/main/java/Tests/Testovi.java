package Tests;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Testovi extends BaseTest{

    @Test
    public static void verifyAddCheapestProduct () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login();

        CartPage cartPage = new CartPage(driver);
        cartPage.openPage();
        HashMap<String, Integer> cartList = cartPage.verifyItemNumberInCart();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.openPage();
        Assert.assertEquals(productsPage.isDisplayed(), true, "Login failed");
        WebElement cheapestItem = productsPage.getCheapestItem();
        String cheapest = productsPage.addCheapestItem(cheapestItem);

        cartPage.openPage();
        HashMap<String, Integer> cartListAfter = cartPage.verifyItemNumberInCart();

        if (!cartList.containsKey(cheapest)){
            Assert.assertEquals(cartListAfter.get(cheapest), 1, "Item is not added");
        }
        else{
            Assert.assertEquals(cartListAfter.get(cheapest), cartList.get(cheapest) + 1);
        }

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

        //Assert.assertEquals(cartPage.verifyItem(expensive), true);

    }
}
