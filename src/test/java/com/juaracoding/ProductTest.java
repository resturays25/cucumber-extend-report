package com.juaracoding;

import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductPage;
import com.juaracoding.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.By;


public class ProductTest {

    private WebDriver driver;
    private ExtentTest extentTest;

    private LoginPage loginPage = new LoginPage();
    private ProductPage productPage = new ProductPage(Hooks.driver);
    private CartPage cartPage = new CartPage(Hooks.driver);

    public ProductTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("User is on login page for product")
    public void user_Is_On_Login_Page_for_product() {
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS,"User is on login page for Product");
    }

    @When("User enters valid username and password for product")
    public void user_Enters_Valid_Username_And_Password_For_Product() {
        loginPage.enterUsername("standard_user");
        delay(2);
        loginPage.enterPassword("secret_sauce");
        extentTest.log(LogStatus.PASS,"User enters valid username and password for product");
    }

    @And("User clicks login button for product")
    public void user_Clicks_Login_Button_On_Product_Page() {
        delay(1);
        loginPage.clickLoginButton();
        extentTest.log(LogStatus.PASS,"User clicks login button for product");
    }

    @And("User should be redirected to the product page for product steps")
    public void user_Should_Be_Redirected_To_The_Product_Page_For_Product_Steps() {
        delay(1);
        String currentUrl = Hooks.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"));
        extentTest.log(LogStatus.PASS,"User should be redirected to the product page");
    }

    @And("User adds two products to the cart")
    public void user_Adds_Two_Products_To_The_Cart() {
        delay(1);
        productPage.addTshirtToCart();
        delay(1);
        productPage.addSweaterToCart();
        extentTest.log(LogStatus.PASS,"User adds two products to the cart");
    }

    @And("User goes to the cart")
    public void user_Goes_To_The_Cart() {
        delay(1);
        productPage.goToShoppingCart();
        extentTest.log(LogStatus.PASS,"User goes to the cart");
    }

    @Then("User should see two products in the cart")
    public void user_Should_See_Two_Products_In_The_Cart() {
        delay(1);
        String cartItemCount = Hooks.driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals("2", cartItemCount);
        extentTest.log(LogStatus.PASS,"User should see two products in the cart");
    }

    public static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
