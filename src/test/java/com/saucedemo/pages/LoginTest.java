package com.saucedemo.pages;

import com.saucedemo.base.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test()
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.assertTitle();
        loginPage.login("standard_user", "secret_sauce");
        //loginPage.assertTitle();

//        ProductPage productPage = new ProductPage(driver);
//        productPage.selectProduct();
//        driver.navigate().back();
//        productPage.selectMenuAbout();
    }

    @Test
    public void emptyLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.emptyLoginField("secret_sauce");
        loginPage.closeErrorMessage();
    }
}



