package com.test.swagLabs.stepdefinitions;

import com.test.swagLabs.pages.SwagLabsCheckout2Page;
//import com.test.swagLabs.pages.SwagLabsCheckoutPage;
import com.test.swagLabs.pages.SwagLabsYourInformationPage;
import com.test.swagLabs.pages.SwagLabsMainPage;
import com.test.swagLabs.pages.SwagLabsLoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwagLabsCheckoutStepDef {
    WebDriver driver = DriverHelper.getDriver();
    SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
    SwagLabsMainPage swagLabsMainPage = new SwagLabsMainPage(driver);
    SwagLabsYourInformationPage swagLabsYourInformationPage = new SwagLabsYourInformationPage(driver);
    SwagLabsCheckout2Page swagLabsCheckout2Page = new SwagLabsCheckout2Page(driver);



    @Given("The user is logged in successfully by providing username and password")
    public void the_user_is_logged_in_successfully_by_providing_username_and_password() throws InterruptedException {
        swagLabsLoginPage.login(ConfigReader.readProperty("QA_swaglabs_username"),
                ConfigReader.readProperty("QA_swaglabs_password"));
    }

    @When("The user clicks Add to cart button for chosen {string} item and validate it is added")
    public void the_user_clicks_add_to_cart_button_for_chosen_item_and_validate_it_is_added(String item) throws InterruptedException {
        swagLabsMainPage.selectItem(item);
    }

    @When("The user clicks cart icon on the top right of page")
    public void the_user_clicks_cart_icon_on_the_top_right_of_page() throws InterruptedException {
        swagLabsMainPage.cart(driver);
        

    }

    @When("The user clicks checkout button")
    public void the_user_clicks_checkout_button() throws InterruptedException {
        swagLabsMainPage.checkout();
    }

    @When("The user fills out {string} , {string} , {string} fields and clicks continue button")
    public void the_user_fills_out_fields_and_clicks_continue_button(String firstName, String lastName, String zipCode) throws InterruptedException {
        swagLabsYourInformationPage.fillOutPersonalInformation(firstName, lastName, zipCode);
    }


    @Then("The user validates item name {string}, product price {double}, tax {double} and total price {double}")
    public void the_user_validates_item_name_product_price_tax_and_total_price(String itemName,
                                                                               double productPriceBeforeTax, double tax, double totalPrice) throws InterruptedException {
        swagLabsCheckout2Page.validateProductNameOnInvoice(itemName);
        swagLabsCheckout2Page.validateProductPrice(productPriceBeforeTax);
        swagLabsCheckout2Page.validateTax(tax);
        swagLabsCheckout2Page.validateTotalPrice(totalPrice);
    }

    @Then("The user provides tax rate {double} for all items, then calculated total price should match the product price with tax")
    public void the_user_provides_tax_rate_for_all_items_then_calculated_total_price_should_match_the_product_price_with_tax(double taxRateFor) {
        swagLabsCheckout2Page.calculateTotalPriceAndTax(taxRateFor);

    }


    @When("The user clicks finish button")
    public void the_user_clicks_finish_button() {
        swagLabsCheckout2Page.finishButton();
    }

    @Then("The user validates the message {string}")
    public void the_user_validates_the_message(String expectedConfirmOrderMessage) throws InterruptedException {
        Thread.sleep(500);
        System.out.println(swagLabsCheckout2Page.confirmOrderMessage());
        Assert.assertEquals(expectedConfirmOrderMessage, swagLabsCheckout2Page.confirmOrderMessage());
    }
    //MAP BELOW
//    @Then("The user validates product name, productPrice, tax and totalPrice by providing productPriceBeforeTax as expectedProductPrice")
//    public void the_user_validates_product_name_product_price_tax_and_total_price_by_providing_product_price_before_tax_as_expected_product_price(DataTable dataTable) throws InterruptedException {
////        Map<String,String> itemName=dataTable.asMap();
////        swagLabsCheckout2Page.validateProductNameOnInvoice(itemName.get("product name"));
//        Map<String,Double> itemPrice=dataTable.asMap();
//        swagLabsCheckout2Page.validateProductPrice(itemPrice.get("product price before tax"));
//        swagLabsCheckout2Page.validateTax(itemPrice.get("product price before tax"));
//        swagLabsCheckout2Page.validateTotalPrice(itemPrice.get("product price before tax"));
//    }
//    @Then("The user validates the confirm message")
//    public void the_user_validates_the_confirm_message(DataTable dataTable) {
//
//    }

    @When("The user clicks Add to cart button for chosen item type")
    public void the_user_clicks_add_to_cart_button_for_chosen_item_type(DataTable dataTable) throws InterruptedException {
        Map<String, String> itemName = dataTable.asMap();
        swagLabsMainPage.selectItem(itemName.get("item type"));
    }

    @When("The user fills out name, last name, zip code fields and clicks continue button")
    public void the_user_fills_out_name_last_name_zip_code_fields_and_clicks_continue_button(DataTable dataTable) throws InterruptedException {
        Map<String, String> personalInformation = dataTable.asMap();
        swagLabsYourInformationPage.fillOutPersonalInformation(personalInformation.get("name"),
                personalInformation.get("last name"), personalInformation.get("zip code"));
    }

    @Then("The user validates item name, product price, tax and total price")
    public void the_user_validates_item_name_product_price_tax_and_total_price(DataTable dataTable) throws InterruptedException {
        Map<String, String> doubleAmounts = dataTable.asMap();
        swagLabsCheckout2Page.validateProductNameOnInvoice(doubleAmounts.get("product name"));
        swagLabsCheckout2Page.validateProductPrice(swagLabsCheckout2Page.doubleFormatFromString(doubleAmounts.get("product price")));
        swagLabsCheckout2Page.validateTax(swagLabsCheckout2Page.doubleFormatFromString(doubleAmounts.get("tax")));
        swagLabsCheckout2Page.validateTotalPrice(swagLabsCheckout2Page.doubleFormatFromString(doubleAmounts.get("total price")));
    }

    @Then("The user validates the confirm message {string}")
    public void the_user_validates_the_confirm_message(String expectedConfirmMessage) {
        Assert.assertEquals(expectedConfirmMessage,swagLabsCheckout2Page.confirmOrderMessage());
    }
}

