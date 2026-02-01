package com.saucedemo.pages;

import com.saucedemo.base.BaseTest;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CardTest extends BaseTest {
    private CardPage cardPage;
    private ProductPage productPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpProductPage() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        loginPage.open();
        loginPage.login("standard_user",
                "secret_sauce");
        productPage.selectProduct();
  }

    @Test
    public void removeProductInCard() {
        cardPage = new CardPage(driver);
        cardPage.removeProduct();
    }
}
