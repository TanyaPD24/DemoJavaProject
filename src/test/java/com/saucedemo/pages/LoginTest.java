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
        loginPage.assertNameProductPage();
    }
//        ProductPage productPage = new ProductPage(driver);
//        productPage.selectProduct();
//        driver.navigate().back();
//        productPage.selectMenuAbout();

    @Test
    public void emptyLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.fillPassword("secret_sauce");
        loginPage.closeErrorMessage();
    }

    @Test
    public void emptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.fillLogin("secret_sauce");
        loginPage.closeErrorMessage();
    }

    @Test
    public void emptyLoginAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.emptyFields();
        loginPage.closeErrorMessage();
    }

    @Test()
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginWithInvalidCredentials("test", "test");
    }

    @Test()
    public void testWithInvalidChars() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginWithSpecialCharacters();
    }

    @Test()
    public void testWithSpecialChars() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginWithSpecialCharacters();
    }
}
