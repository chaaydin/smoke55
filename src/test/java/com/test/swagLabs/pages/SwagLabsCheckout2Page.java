package com.test.swagLabs.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.text.DecimalFormat;

public class SwagLabsCheckout2Page {
    public SwagLabsCheckout2Page(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".inventory_item_name")
    WebElement itemName;

    @FindBy (css = ".summary_subtotal_label")
    WebElement productPrice;

    @FindBy (css = ".summary_tax_label")
    WebElement tax;

    @FindBy (css = ".summary_total_label")
    WebElement totalPrice;

    @FindBy (css = "#finish")
    WebElement finishButton;

    @FindBy (tagName = "h2")
    WebElement confirmMessage;

    public double parseDoubleFromWebElement(WebElement pricingComponents){
        String text= BrowserUtils.getText(pricingComponents);
        return Double.parseDouble(text.substring(text.indexOf('$')+1));
    }
    public double doubleFormatHundredths(double duble){
        DecimalFormat df=new DecimalFormat("#.##");
        return Double.parseDouble(df.format(duble));
    }
    public double doubleFormatFromString(String doubleAmounts){
        return Double.parseDouble(doubleAmounts);
    }
    public void calculateTotalPriceAndTax(double taxRateFor){
        Assert.assertTrue(doubleFormatHundredths((parseDoubleFromWebElement(productPrice)*taxRateFor))
                ==parseDoubleFromWebElement(tax));
        Assert.assertTrue(parseDoubleFromWebElement(totalPrice)
                ==doubleFormatHundredths(parseDoubleFromWebElement(productPrice)*(1+taxRateFor)));
    }
    public void validateProductNameOnInvoice(String itemName) throws InterruptedException {
        Thread.sleep(500);
        System.out.println(BrowserUtils.getText(this.itemName));
        Assert.assertEquals(itemName, BrowserUtils.getText(this.itemName));
    }
    public void validateProductPrice(double productPriceBeforeTax) throws InterruptedException {
         Thread.sleep(500);
         System.out.println((productPriceBeforeTax));
         System.out.println((parseDoubleFromWebElement(productPrice)));
         Assert.assertTrue((productPriceBeforeTax)==parseDoubleFromWebElement(productPrice));
    }
    public void validateTax(double tax) throws InterruptedException {
         Thread.sleep(500);
         System.out.println((tax));
         System.out.println(parseDoubleFromWebElement(this.tax));
         Assert.assertTrue((tax)==(parseDoubleFromWebElement(this.tax)));
    }
    public void validateTotalPrice(double totalPrice) throws InterruptedException {
         Thread.sleep(500);
         System.out.println(totalPrice);
         System.out.println(parseDoubleFromWebElement(this.totalPrice));
         Assert.assertTrue((totalPrice)==parseDoubleFromWebElement(this.totalPrice));
    }


    public void finishButton(){
        finishButton.click();
    }
    public String confirmOrderMessage(){
        return BrowserUtils.getText(confirmMessage);
    }

    /*
     System.out.println(parseDoubleFromWebElement(tax));
        System.out.println(parseDoubleFromWebElement(productPrice)*taxRateFor);
        System.out.println(parseDoubleFromWebElement(totalPrice));
        System.out.println(parseDoubleFromWebElement(productPrice)*(1+taxRateFor));
     */

}
