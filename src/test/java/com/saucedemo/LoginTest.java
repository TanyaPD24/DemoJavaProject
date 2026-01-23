package com.saucedemo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class LoginTest extends BaseClass {
    public static void main(String[] args) {

        LoginTest loginTest = new LoginTest();
        loginTest.setupDriver();
        loginTest.getBaseUrl();
        loginTest.assertTitle();
        loginTest.input_userName();
        loginTest.input_userPassword();
        loginTest.clickButtonLogin();
        loginTest.assertTitleProductPage();
        loginTest.closeWindow();
    }

}
