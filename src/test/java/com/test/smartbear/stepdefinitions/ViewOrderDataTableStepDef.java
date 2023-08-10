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

public class ViewOrderDataTableStepDef {
    WebDriver driver= DriverHelper.getDriver();
    SmartbearLoginPage smartbearLoginPage=new SmartbearLoginPage(driver);
    SmartbearMainPage smartbearMainPage=new SmartbearMainPage(driver);
    SmartbearOrderPage smartbearOrderPage=new SmartbearOrderPage(driver);

    SmartbearViewOrderPage smartbearViewOrderPage=new SmartbearViewOrderPage(driver);

    @Given("User provides username,password for successfully login with DataTable")
    public void user_provides_username_password_for_successfully_login_with_data_table() {
        smartbearLoginPage.loginSuccessfully(ConfigReader.readProperty("QA_smartbear_username"),
                ConfigReader.readProperty("QA_smartbear_password"));
    }
    @When("User clicks order link on main page with DataTable")
    public void user_clicks_order_link_on_main_page_with_data_table() {
        smartbearMainPage.navigateOrderPage();
    }
    @When("User provides the product and quantity for product information")
    public void user_provides_the_product_and_quantity_for_product_information(DataTable dataTable) throws InterruptedException {
        Map<String,String> productInformation=dataTable.asMap();
        System.out.println(productInformation);
        smartbearOrderPage.sendProductInformation(productInformation.get("ProductType"),
                productInformation.get("Quantity"));

    }
    @When("User provides Name,street,city,state,zip for address information")
    public void user_provides_name_street_city_state_zip_for_address_information(DataTable dataTable) throws InterruptedException {
        Map<String,String> addressInformation=dataTable.asMap();
        System.out.println(addressInformation);
        smartbearOrderPage.sendAddressInformation(addressInformation.get("Name"),
                addressInformation.get("street"),
                addressInformation.get("city"),
                addressInformation.get("state"),
                addressInformation.get("zip"));
    }
    @When("User provides cardType, cardNumber, expireDate for payment information")
    public void user_provides_card_type_card_number_expire_date_for_payment_information(DataTable dataTable) throws InterruptedException {
        Map<String,String> paymentInformation=dataTable.asMap();
        System.out.println(paymentInformation);
        smartbearOrderPage.sendPaymentInformation(paymentInformation.get("CardType"),
                paymentInformation.get("CardNumber"),
                paymentInformation.get("ExpireDate"));
    }
    @Then("User click process button and validates the message")
    public void user_click_process_button_and_validates_the_message(DataTable dataTable) {
        smartbearOrderPage.clickProcessButton();
        List<String> message =dataTable.asList();
        System.out.println(smartbearOrderPage.getMessage());
        Assert.assertEquals(message.get(0),smartbearOrderPage.getMessage());
    }
}
