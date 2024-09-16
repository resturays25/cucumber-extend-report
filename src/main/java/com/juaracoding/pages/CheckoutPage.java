package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCode;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueBtn;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    public void enterFirstName(String firstName) {

        this.firstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {

        this.lastName.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {

        this.postalCode.sendKeys(postalCode);
    }

    public void clickContinueButton() {

        continueBtn.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
