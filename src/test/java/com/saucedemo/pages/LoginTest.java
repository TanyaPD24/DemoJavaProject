package com.saucedemo.pages;

import com.saucedemo.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUpLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @Test
    public void login() {
        loginPage.assertTitle();
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assertNameProductPage();
    }

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

    @Test
    public void fillWithInvalidUserName() {
        loginPage.login("test", "secret_sauce");
        loginPage.assertErrorMessageForCredentials();
    }

    @Test
    public void fillWithSpecialChars() {
        loginPage.login("!@#$%^&*()_+-=[]{}|;:,.<>?", "!@#$%^&*()_+-=[]{}|;:,.<>?");
    }
}
