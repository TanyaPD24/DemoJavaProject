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
    private  WebDriver driver;
    private final WebDriverWait wait;

    //public static final String PRODUCT_URL = "https://www.saucedemo.com/inventory.html";

    public static final String EXPECTED_NAME_FIRST_PRODUCT = "Sauce Labs Backpack";
    private static final String CART_PAGE_URL = "https://www.saucedemo.com/cart.html";
    public static final String PRODUCT_URL = "https://www.saucedemo.com/inventory.html";

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement selectProduct1;

//    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
//    private WebElement selectProduct2;
//
//    @FindBy(id= "add-to-cart-sauce-labs-backpack")
//    private WebElement selectProduct3;

    @FindBy(className = "shopping_cart_link")
    private WebElement cart;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeButtonFirstProduct;

    @FindBy(id= "shopping_cart_container")
    private WebElement price1FirstProduct;

    @FindBy(css = ".cart_item .inventory_item_name")
    private WebElement cartProductName;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void selectFirstProduct() {
        wait.until(ExpectedConditions.visibilityOf(selectProduct1));
        selectProduct1.click();
        System.out.println("Первый товар добавлен в корзину");
    }

    public void clickCart() {
        cart.click();
        driver.get(CART_PAGE_URL);
        wait.until(ExpectedConditions.urlToBe(CART_PAGE_URL));
        System.out.println("Перешли в корзину. URL: " + driver.getCurrentUrl());
    }

    public void removeFirstProduct() {
        wait.until(ExpectedConditions.visibilityOf(removeButtonFirstProduct));
        removeButtonFirstProduct.click();
        System.out.println("Первый товар удален из корзины");
    }

    public void assertAddFirstProduct() {
        wait.until(ExpectedConditions.visibilityOfAllElements(cartProductName));
        String actualNameFirstProduct = cartProductName.getText();
        Assert.assertEquals(actualNameFirstProduct, EXPECTED_NAME_FIRST_PRODUCT,
                "Error name first product");
        System.out.println("Прверка названия первого товара: " + actualNameFirstProduct);
    }


}
