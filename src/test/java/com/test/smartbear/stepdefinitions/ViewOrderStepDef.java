package com.test.smartbear.stepdefinitions;

import com.test.smartbear.pages.SmartbearLoginPage;
import com.test.smartbear.pages.SmartbearMainPage;
import com.test.smartbear.pages.SmartbearOrderPage;
import com.test.smartbear.pages.SmartbearViewOrderPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class ViewOrderStepDef {
    WebDriver driver= DriverHelper.getDriver();
    SmartbearLoginPage smartbearLoginPage=new SmartbearLoginPage(driver);
    SmartbearMainPage smartbearMainPage=new SmartbearMainPage(driver);
    SmartbearOrderPage smartbearOrderPage=new SmartbearOrderPage(driver);

    SmartbearViewOrderPage smartbearViewOrderPage=new SmartbearViewOrderPage(driver);


    @Given("User provides username and password for successfully login")
    public void user_provides_username_and_password_for_successfully_login() {
        smartbearLoginPage.loginSuccessfully(ConfigReader.readProperty("QA_smartbear_username"),
                ConfigReader.readProperty("QA_smartbear_password"));
    }
    @When("User clicks order link on main page")
    public void user_clicks_order_link_on_main_page() {
        smartbearMainPage.navigateOrderPage();
    }
    @When("User provides {string} and {string} for product information")
    public void user_provides_and_for_product_information(String product, String quantity) throws InterruptedException {
        smartbearOrderPage.sendProductInformation(product,quantity);
    }
    @When("User provides {string}, {string},{string}, {string},{string} for address information")
    public void user_provides_for_address_information(String name, String street, String city, String state, String zip) throws InterruptedException {
     smartbearOrderPage.sendAddressInformation(name,street,city,state,zip);
    }
    @When("User provides {string}, {string}, {string} for payment information")
    public void user_provides_for_payment_information(String card, String number, String expireDate) throws InterruptedException {
        smartbearOrderPage.sendPaymentInformation(card,number,expireDate);
    }
    @Then("User click process button and validates the {string}")
    public void user_click_process_button_and_validates_the(String expectedMsg) throws InterruptedException {
        smartbearOrderPage.validateOrderFunc(expectedMsg);
    }
    @When("User clicks view all orders link")
    public void user_clicks_view_all_orders_link() throws InterruptedException {
        Thread.sleep(500);
     smartbearMainPage.navigateViewAllOrderPage();
    }
    @Then("User validates all information {string}, {string},{string},{string},{string},{string},{string},{string},{string},{string} from table")
    public void user_validates_all_information_from_table(String name, String product, String quantity, String street,
                                                          String city, String state, String zip, String card, String number,
                                                          String expireDate) throws InterruptedException {
        smartbearViewOrderPage.addedPaymentMethodFunc(name,product,quantity,street,city,state,zip,card,number,expireDate);
    }


}
