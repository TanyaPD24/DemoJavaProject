package com.saucedemo.pages;

import com.saucedemo.base.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test()
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getBaseUrl();
        loginPage.assertTitle();
        loginPage.input_userName();
        loginPage.input_userPassword();
        loginPage.clickButtonLogin();
        //loginPage.assertTitle();

//        ProductPage productPage = new ProductPage(driver);
//
//        productPage.selectProduct();
//        driver.navigate().back();
//        productPage.selectMenuAbout();
    }
    }



