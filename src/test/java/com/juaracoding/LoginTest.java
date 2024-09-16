package com.juaracoding;

import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginTest {

    private WebDriver driver;
    private ExtentTest extentTest;

    private LoginPage loginPage = new LoginPage();

    public LoginTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("User is on login page for login")
    public void user_is_on_login_page_for_login() {
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS,"User is on login page for login");
    }

    @When("User enters valid username and password for login")
    public void user_enters_valid_username_and_password_for_login() {
        loginPage.enterUsername("standard_user");
        delay(3);
        loginPage.enterPassword("secret_sauce");
        delay(3);
        extentTest.log(LogStatus.PASS,"User enters valid username and password for login");
    }

    @And("User clicks login button on login page")
    public void user_clicks_login_button_on_login_page() {
        loginPage.clickLoginButton();
        delay(2);
        extentTest.log(LogStatus.PASS,"User clicks login button on login page");
    }

    @Then("User should be redirected to the product page")
    public void user_should_be_redirected_to_the_product_page() {
        String currentUrl = Hooks.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"));
        extentTest.log(LogStatus.PASS,"User should be redirected to the product page");
    }

    @And("User enters invalid username and valid password")
    public void user_enters_invalid_username_and_valid_password() {
        loginPage.enterUsername("invalid_user");
        delay(3);
        loginPage.enterPassword("secret_sauce");
        delay(3);
        extentTest.log(LogStatus.PASS,"User enters invalid username and valid password");
    }

    @When("User enters valid username and invalid password for login")
    public void user_enters_valid_username_and_invalid_password_for_login() {
        loginPage.enterUsername("standard_user");
        delay(3);
        loginPage.enterPassword("wrong_password");
        delay(3);
        extentTest.log(LogStatus.PASS,"User enters valid username and invalid password for login");
    }

    @When("User enters empty username and valid password for login")
    public void user_enters_empty_username_and_valid_password_for_login() {
        loginPage.enterUsername("");
        delay(3);
        loginPage.enterPassword("secret_sauce");
        delay(3);
        extentTest.log(LogStatus.PASS,"User enters empty username and valid password for login");
    }

    @When("User enters valid username and empty password for login")
    public void user_enters_valid_username_and_empty_password_for_login() {
        loginPage.enterUsername("standard_user");
        delay(3);
        loginPage.enterPassword("");
        delay(3);
        extentTest.log(LogStatus.PASS,"User enters valid username and empty password for login");
    }

    @When("User enters empty username and empty password for login")
    public void user_enters_empty_username_and_empty_password_for_login() {
        loginPage.enterUsername("");
        delay(3);
        loginPage.enterPassword("");
        delay(3);
        extentTest.log(LogStatus.PASS,"User enters empty username and empty password for login");
    }

    @And("User clicks login button")
    public void user_clicks_login_button() {
        loginPage.clickLoginButton();
        delay(2);
        extentTest.log(LogStatus.PASS,"User clicks login button");
    }

    @Then("User should see an error message for login")
    public void user_should_see_an_error_message_for_login() {
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        extentTest.log(LogStatus.PASS,"User should see an error message for login");
    }

    @Then("User should see an error message for login and a prompt to fill in the password fields")
    public void user_should_see_an_error_message_for_login_and_a_prompt_to_fill_in_the_password_fields() {
        String expectedErrorMessage = "Epic sadface: Password is required";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        extentTest.log(LogStatus.PASS,"User should see an error message for login and a prompt to fill in the password fields");
    }

    @Then("User should see an error message for login and a prompt to fill in the username fields")
    public void user_should_see_an_error_message_for_login_and_a_prompt_to_fill_in_the_username_fields() {
        String expectedErrorMessage = "Epic sadface: Username is required";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        extentTest.log(LogStatus.PASS,"User should see an error message for login and a prompt to fill in the username fields");
    }

    public static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
