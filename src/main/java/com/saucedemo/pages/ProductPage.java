package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class ProductPage {
    private final WebDriverWait wait;

    //public static final String PRODUCT_URL = "https://www.saucedemo.com/inventory.html";
    //public static final String EXPECTED_TITLE_PP = "Swag Labs";

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement selectProduct1;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement selectProduct2;

    @FindBy(id= "add-to-cart-sauce-labs-backpack")
    private WebElement selectProduct3;

    @FindBy(id= "shopping_cart_container")
    private WebElement card;


    //WebElement menu = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
    //WebElement linkAbout = driver.findElement(By.xpath("//a[@id='about_sidebar_link']"));

    public ProductPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
//    public void selectMenuAbout() {
//        menu.click();
//        linkAbout.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
//        System.out.println(driver.getCurrentUrl());
//        //.assertTrue(PRODUCT_URL.contains());
//    }

    public void selectProduct() {
        wait.until(ExpectedConditions.visibilityOf(selectProduct1));
        selectProduct1.click();
        selectProduct2.click();
        selectProduct3.click();
        card.click();
  }

  public void assertProductsInTheCard() {

}
}
