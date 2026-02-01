package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CardPage {

    private final WebDriverWait wait;

    //public static final String PRODUCT_URL = "https://www.saucedemo.com/inventory.html";
    //public static final String EXPECTED_TITLE_PP = "Swag Labs";


    @FindBy(id= "shopping_cart_container")
    private WebElement price1;

    @FindBy(id= "shopping_cart_container")
    private WebElement price2;

    @FindBy(id= "shopping_cart_container")
    private WebElement price3;

    @FindBy(id= "remove-sauce-labs-bolt-t-shirt")
    private WebElement buttonRemove1;

    @FindBy(id= "remove-sauce-labs-bike-light")
    private WebElement buttonRemove2;

    @FindBy(id= "remove-sauce-labs-backpack")
    private WebElement buttonRemove3;

    //WebElement menu = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
    //WebElement linkAbout = driver.findElement(By.xpath("//a[@id='about_sidebar_link']"));

    public CardPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

//    public void assertProductInTheCard() {
//
//    }

    public void removeProduct() {
        wait.until(ExpectedConditions.visibilityOfAllElements(buttonRemove1));
        buttonRemove1.click();
        buttonRemove2.click();
        buttonRemove3.click();
    }

//    public void assertEmptyProductInTheCard() {
//
//    }
}