package com.test.smartbear.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartbearMainPage {
    public SmartbearMainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy (linkText = "Order")
    WebElement orderLink;

    @FindBy (linkText = "View all orders")
    WebElement viewAllOrdersLink;
    public void navigateOrderPage(){
        orderLink.click();
    }
    public void navigateViewAllOrderPage(){
        viewAllOrdersLink.click();
    }
}


