package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.WeborderFoodOrderPage;
import com.test.weborder.pages.WeborderLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class WeborderFoodOrderStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WeborderLoginPage weborderLoginPage= new WeborderLoginPage(driver);
    WeborderFoodOrderPage weborderFoodOrderPage= new WeborderFoodOrderPage(driver);

    @Given("User provides username and password for successful login")
    public void user_provides_username_and_password_for_successful_login() {
        weborderLoginPage.loginFunx(ConfigReader.readProperty("QA_weborder_username"),
                ConfigReader.readProperty("QA_weborder_password"));
    }
    @When("User clicks group order box, and next button")
    public void user_clicks_group_order_box_and_next_button() {
        weborderFoodOrderPage.clickGroupOrderBox();
        weborderFoodOrderPage.clickNextButton();
    }
    @When("User provides note {string} to invitees box")
    public void user_provides_note_to_invitees_box(String invitees) throws InterruptedException {
        weborderFoodOrderPage.sendInviteesMessage(invitees);

    }
    @When("User provides emails {string} , {string} to inviteList")
    public void user_provides_emails_to_invite_list(String email1, String email2) throws InterruptedException {
        weborderFoodOrderPage.sendInviteList(email1,email2);
    }
    @When("User chooses delivery option to {string} and validates the address {string}")
    public void user_chooses_delivery_option_to_and_validates_the_address(String location, String expectedMessage) throws InterruptedException {
        weborderFoodOrderPage.deliveryOptions(location,expectedMessage);
    }



    @When("User clicks create group order button")
    public void user_clicks_create_group_order_button() throws InterruptedException {
        weborderFoodOrderPage.clickCreateGroupOrderButton();
        Thread.sleep(1500);
    }
    @Then("User validates {string} and {string} from description")
    public void user_validates_and_from_description(String expectedHeader, String expectedDescription) {
        weborderFoodOrderPage.validateHeaderAndDescription(expectedHeader,expectedDescription);

    }



}
