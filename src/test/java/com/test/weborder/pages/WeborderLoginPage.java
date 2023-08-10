package com.test.weborder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class WeborderLoginPage {
    public WeborderLoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "#Email")
    WebElement username;

    @FindBy (css = "#Password")
    WebElement password;

    @FindBy (xpath = "//button[.='Sign In']")
    WebElement signInButton;

    @FindBy (css = ".alert-danger")
    WebElement errorMessage;

    public void loginFunx(String username,String password){
        this.username.clear();
        this.username.sendKeys(username);
        this.password.clear();
        this.password.sendKeys(password);
        signInButton.click();
    }

    public String errorMessage(){
        return BrowserUtils.getText(errorMessage);
    }

}
