package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

public class WeborderFoodOrderPage {
    public WeborderFoodOrderPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//label[@for='GroupOrder']")
    WebElement groupOrderBox;

    @FindBy (xpath = "//button[.='Next']")
    WebElement nextButton;

    @FindBy (css = "#InviteNote")
    WebElement invitees;

    @FindBy (css = "#InviteList")
    WebElement inviteList;

    @FindBy(css = "#ConfirmAddressID")
    WebElement locationDD;


    @FindBy (css = "#addressPreview")
    WebElement addressPreview;

    @FindBy (css = "#createGroupOrder")
    WebElement createGroupOrderButton;

    @FindBy (tagName = "h1")
    WebElement header;

    @FindBy (xpath = "//p[contains(text(),'now pending')]")
    WebElement description;

    public void clickGroupOrderBox(){
        if (groupOrderBox.isDisplayed()){
            groupOrderBox.click();
        }
    }

    public void clickNextButton(){
        nextButton.click();
    }

    public void sendInviteesMessage(String invitees) throws InterruptedException {
        Thread.sleep(1500);
        this.invitees.sendKeys(invitees);
    }


    public void sendInviteList(String email1,String email2) throws InterruptedException {
        Thread.sleep(1500);
        inviteList.sendKeys(email1+" ,"+email2);
    }

    public void deliveryOptions(String location,String expectedMessage) throws InterruptedException {
        BrowserUtils.selectBy(locationDD, location, "text");
        Thread.sleep(1500);
        System.out.println(BrowserUtils.getText(addressPreview));
        Assert.assertTrue(BrowserUtils.getText(addressPreview).contains(expectedMessage));
    }

    public void clickCreateGroupOrderButton() throws InterruptedException {
        createGroupOrderButton.click();
        Thread.sleep(1000);
    }

    public void validateHeaderAndDescription(String expectedHeader,String expectedDescription){
        System.out.println(BrowserUtils.getText(header));
        System.out.println(BrowserUtils.getText(description));
        Assert.assertEquals(expectedHeader,BrowserUtils.getText(header));
        Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDescription));
    }


}
