package com.saucedemo;

import com.saucedemo.base_class.BaseClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseClass {

    @BeforeMethod
    public void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        };

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
