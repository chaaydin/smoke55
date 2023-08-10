package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.WeborderLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class WeborderLoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WeborderLoginPage weborderLoginPage=new WeborderLoginPage(driver);

    @When("User provides {string} and {string} and click Login button")
    public void user_provides_and_and_click_login_button(String username, String password) {
        weborderLoginPage.loginFunx(username,password);
    }
    @Then("validate the {string}")
    public void validate_the(String title) {
        Assert.assertEquals(title,driver.getTitle().trim());
    }

    @Then("User validates the message {string}")
    public void user_validates_the_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage,weborderLoginPage.errorMessage());
    }





}
