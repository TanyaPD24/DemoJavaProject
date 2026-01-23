package com.saucedemo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;
    public static final String BASE_URL = "https://www.saucedemo.com/";
    public static final String EXPECTED_TITLE = "Swag Labs";
    public static final String EXPECTED_TITLE_PRODUCT_PAGE = "Products";

    public void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void getBaseUrl() {
        driver.get(BASE_URL);
        String baseTitle = driver.getTitle();
        System.out.println("Expected title - " + baseTitle);
    }

    public void assertTitle() {
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(EXPECTED_TITLE)) {
            System.out.println("Actual title - OK - " + EXPECTED_TITLE);
        } else {
            System.out.println("not ok - " + actualTitle);
        }

    }

    public void input_userName() {
        WebElement userName = driver.findElement(By.xpath("//input[@name='user-name']"));
        userName.click();
        userName.sendKeys("standard_user");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    public void input_userPassword() {
        WebElement userPassword = driver.findElement(By.xpath("//input[@name='password']"));
        userPassword.click();
        userPassword.sendKeys("secret_sauce");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    public void clickButtonLogin() {
        WebElement buttonLogin = driver.findElement(By.xpath("//input[@name='login-button']"));
        buttonLogin.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    public void assertTitleProductPage() {
        String actualTitleProductPage = "Products";

        if (actualTitleProductPage.equals(EXPECTED_TITLE_PRODUCT_PAGE)) {
            System.out.println("Actual title ProductPage - OK - " + EXPECTED_TITLE_PRODUCT_PAGE);
        } else {
            System.out.println("not ok - " + actualTitleProductPage);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

    }

    public void closeWindow() {
        driver.quit();
    }
}
