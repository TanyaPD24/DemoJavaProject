package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

   // public static WebDriver driver;
    public static final String BASE_URL = "https://www.saucedemo.com/";
    public static final String EXPECTED_TITLE = "Swag Labs";
    // public static final String EXPECTED_TITLE_PRODUCT_PAGE = "Products";

    @FindBy(xpath = "//input[@name='user-name']")
    private WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement userPassword;

    @FindBy(xpath = "//input[@name='login-button']")
    private WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
        userName.click();
        userName.sendKeys("standard_user");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    public void input_userPassword() {
        userPassword.click();
        userPassword.sendKeys("secret_sauce");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    public void clickButtonLogin() {
        buttonLogin.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

//    public void assertTitleProductPage() {
//        String actualTitleProductPage = "Products";
//        Assert.assertEquals(actualTitleProductPage, "Products");
//    }
}
