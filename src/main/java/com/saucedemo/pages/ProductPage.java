package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class ProductPage {
    private WebDriver driver;

    public static final String CURRENT_URL = "https://saucelabs.com/";

    WebElement select_product_1= driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
    WebElement select_product_2 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
    WebElement select_product_3 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
    WebElement card = driver.findElement(By.xpath("//div[@id='shopping_cart_container']"));
    WebElement menu = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
    WebElement link_about = driver.findElement(By.xpath("//a[@id='about_sidebar_link']"));

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void selectMenuAbout() {
        menu.click();
        link_about.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        System.out.println(driver.getCurrentUrl());
        //Assert.assertTrue(CURRENT_URL.contains());
    }

    public void selectProduct() {
        select_product_1.click();
        select_product_2.click();
        select_product_3.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        card.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }
}
