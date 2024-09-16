package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//*[@id='finish']")
    private WebElement finish;

    public void proceedToCheckout() {
        checkoutButton.click();
    }
    public void setFinish() {
        finish.click();
    }
}
