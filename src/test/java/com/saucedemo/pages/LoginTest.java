package com.saucedemo.pages;

import com.saucedemo.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUpLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @Test()
    public void login() {
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
        loginPage.login(null, "secret_sauce");
        loginPage.closeErrorMessage();
    }

    @Test
    public void emptyPassword() {
        loginPage.login("standard_user", null);
        loginPage.assertErrorMessageForPassword();
        loginPage.closeErrorMessage();
    }

    @Test
    public void emptyLoginAndPassword() {
        loginPage.login(null, null);
        loginPage.closeErrorMessage();
    }

    @Test()
    public void fillWithInvalidChars() {
        loginPage.login("test", "test");
        loginPage.assertErrorMessageForCredentials();
    }

    @Test()
    public void fillWithSpecialChars() {
        loginPage.login("!@#$%^&*()_+-=[]{}|;:,.<>?", "!@#$%^&*()_+-=[]{}|;:,.<>?");
    }
}
