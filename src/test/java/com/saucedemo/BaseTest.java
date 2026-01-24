package com.saucedemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseClass {

    @BeforeMethod
    public void setupTest() {
        setupDriver();
        getBaseUrl();
        };

    @AfterMethod
    public void windowClose() {
        closeWindow();
    }
}
