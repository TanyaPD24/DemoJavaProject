package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public static final String LOGIN_URL = "https://www.saucedemo.com/";
    public static final String EXPECTED_TITLE = "Swag Labs";
    public static final String EXPECTED_TITLE_PRODUCT_PAGE = "Products";
    public static final String ERROR_INVALID_CREDENTIALS = "1Epic sadface: Username and password do " +
            "not match any user in this service";

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement userPassword;

    @FindBy(id = "login-button")
    private WebElement buttonLogin;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[@class='title']")
    public WebElement actualNameProductPage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void assertTitle() {
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(EXPECTED_TITLE)) {
            System.out.println("Actual title - OK - " + EXPECTED_TITLE);
        } else {
            System.out.println("not ok - " + actualTitle);
        }

    }

    public void open () {
        driver.get(LOGIN_URL);
        String baseTitle = driver.getTitle();
        System.out.println("Expected title - " + baseTitle);
    }

    public void login(String username, String password) {
        wait.until((ExpectedConditions.visibilityOf(userName)));
        if (username != null) {
            userName.sendKeys(username);
        }
        if (password != null) {
            userPassword.sendKeys(password);
        }
        buttonLogin.click();
    }

    public void assertNameProductPage() {
        wait.until(ExpectedConditions.visibilityOf(actualNameProductPage));
        String actualProductNameText = actualNameProductPage.getText();
        Assert.assertEquals(actualProductNameText, EXPECTED_TITLE_PRODUCT_PAGE);
    }

    public void assertErrorMessageForPassword() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        Assert.assertTrue(errorMessage.isDisplayed(), "Epic sadface: Password is required");
    }

    public void closeErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();
        WebElement closeButton = driver.findElement(By.cssSelector(".error-button"));
        closeButton.click();
    }

    public void assertErrorMessageForCredentials() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        String actualError = errorMessage.getText();
        Assert.assertEquals(actualError, ERROR_INVALID_CREDENTIALS,
                "Error massage does not match expected");
        System.out.println("Прверка с неверными данными: " + actualError);
    }
}