package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import java.util.List;
public class SmartbearOrderPage {
    public SmartbearOrderPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//select[contains(@id,'Product')]")
    WebElement productDD;
    @FindBy (xpath = "//input[contains(@id,'Quantity')]")
    WebElement quantity;
    @FindBy (xpath = "//input[contains(@id,'Name')]")
    WebElement customerName;
    @FindBy (xpath = "//input[contains(@id,'Box2')]")
    WebElement street;
    @FindBy (xpath = "//input[contains(@id,'Box3')]")
    WebElement city;
    @FindBy (xpath = "//input[contains(@id,'Box4')]")
    WebElement state;
    @FindBy (xpath = "//input[contains(@id,'Box5')]")
    WebElement zipCode;
    @FindBy(xpath = "//input[contains(@name,'cardList')]")
    List<WebElement> cards;

    @FindBy (xpath = "//input[@value='Visa']")
    WebElement visa;

    @FindBy (xpath = "//input[@value='MasterCard']")
    WebElement masterCard;

    @FindBy (xpath = "//input[@value='American Express']")
    WebElement americanExpress;

    @FindBy (xpath = "//input[contains(@id,'Box6')]")
    WebElement cardNumber;

    @FindBy (xpath = "//input[contains(@id,'Box1')]")
    WebElement expirationDate;

    @FindBy (xpath = "//a[.='Process']")
    WebElement processButton;

    @FindBy (tagName = "strong")
    WebElement confirmMsg;
    public void sendProductInformation(String product,String quantity) throws InterruptedException {
        Thread.sleep(500);
        BrowserUtils.selectBy(productDD,product,"value");
        this.quantity.clear();
        Thread.sleep(500);
        this.quantity.sendKeys(quantity);
    }
    public void sendAddressInformation(String name,String street,String city,String state,String zip) throws InterruptedException {
        Thread.sleep(500);
        customerName.sendKeys(name);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        zipCode.sendKeys(zip);
    }
    public void selectCard(String cardType){
        cardType=cardType.toLowerCase();
        switch (cardType){
            case "visa":
                visa.click();
                break;
            case "mastercard":
                masterCard.click();
                break;
            case "american express":
                americanExpress.click();
                break;
            default:
                Assert.fail("wrong card type");}}
    public void sendPaymentInformationForSwitch(String cardType,String cardNumber,String expireDate){
        selectCard(cardType);
        this.cardNumber.sendKeys(cardNumber);
        expirationDate.sendKeys(expireDate);}
    public void clickProcessButton(){// yukaridaki click ve asserttionu ayirdi
        processButton.click();}
    public String getMessage(){ // yukaridaki process click ile assertionu ayirdi daha mantikli dedi o yuzden validationu da return ettirerek yapicak
        return BrowserUtils.getText(confirmMsg);}
    public void sendPaymentInformation(String card,String number,String expireDate) throws InterruptedException {
        Thread.sleep(500);
        for (WebElement cardType:cards){
            System.out.println(cardType.getAttribute("value"));
            if (cardType.getAttribute("value").equalsIgnoreCase(card)){
                cardType.click();
            }}
        cardNumber.sendKeys(number);
        expirationDate.sendKeys(expireDate);
    }
    public void validateOrderFunc(String expectedMsg) throws InterruptedException {
        Thread.sleep(500);
        processButton.click();
        Assert.assertEquals(expectedMsg,BrowserUtils.getText(confirmMsg));
    }



}

