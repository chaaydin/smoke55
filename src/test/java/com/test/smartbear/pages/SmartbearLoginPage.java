package com.test.smartbear.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class SmartbearLoginPage {
    public SmartbearLoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//input[contains(@id,'username')]")
    WebElement username;

    @FindBy (xpath = "//input[contains(@id,'password')]")
    WebElement password;

    @FindBy(xpath = "//input[contains(@id,'login')]")
    WebElement loginButton;

    public void loginSuccessfully(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
}
