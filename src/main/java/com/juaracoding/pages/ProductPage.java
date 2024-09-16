package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.juaracoding.drivers.DriverSingleton.delay;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement addToCartTShirt;

    @FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
    private WebElement addToCartSweater;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement shoppingCart;

    @FindBy(xpath = "//*[@id='react-burger-menu-btn']")
    private WebElement menu;

    @FindBy(xpath = "//*[@id='logout_sidebar_link']")
    private WebElement btnLogout;


    public void addTshirtToCart() {
        addToCartTShirt.click();
    }

    public void addSweaterToCart() {
        addToCartSweater.click();
    }

    public void goToShoppingCart() {
        shoppingCart.click();
    }

    public void setLogout(){
        menu.click();
        delay(1);
        btnLogout.click();
    }
}
