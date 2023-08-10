package com.test.swagLabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsYourInformationPage {
    public SwagLabsYourInformationPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "#first-name")
    WebElement firstName;

    @FindBy (css = "#last-name")
    WebElement lastName;

    @FindBy (css = "#postal-code")
    WebElement zipCode;

    @FindBy (xpath = "//input[@id='continue']")
    WebElement continueButton;

    public void fillOutPersonalInformation(String firstName, String lastName,String zipCode) throws InterruptedException {
        Thread.sleep(500);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.zipCode.sendKeys(zipCode);
        continueButton.click();
    }


}
