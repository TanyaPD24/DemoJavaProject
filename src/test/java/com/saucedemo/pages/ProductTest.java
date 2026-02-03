package com.saucedemo.pages;

import com.saucedemo.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    private ProductPage productPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpProductPage() {
        loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage = new ProductPage(driver);
        loginPage.assertNameProductPage();
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page title: " + driver.getTitle());
    }

    @Test
    public void selectFirstProductInProductPage() {
        productPage.selectFirstProduct();
        productPage.clickCart();
        productPage.assertAddFirstProduct();
        productPage.removeFirstProduct();
    }
}