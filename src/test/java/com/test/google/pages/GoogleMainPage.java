package com.test.google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class GoogleMainPage {
    public GoogleMainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//textarea[@name='q']")
    WebElement searchBar;

    @FindBy(xpath = "//a//h3")
    List<WebElement> allLinks;

    @FindBy (xpath = "//div[@id='result-stats']")
    WebElement result;

    public void searchItem(String item){
        searchBar.sendKeys(item, Keys.ENTER);
    }

    public boolean linkCount(int expectedNumber) throws InterruptedException {
        Thread.sleep(1500);
        System.out.println(allLinks.size());
        return allLinks.size()>expectedNumber;
    }

    public boolean resultsFromSearch(int expectedResult){
        String[] result= BrowserUtils.getText(this.result).split(" ");//About 154,000,000 results (0.53 seconds)
        return Integer.parseInt(result[1].replace(",",""))<expectedResult;
    }

    public boolean resultsSpeedFromSearch(double expectedResult){
        String[] resultSpeed=BrowserUtils.getText(result).split(" ");
        System.out.println(Double.parseDouble(resultSpeed[3].substring(1)));
        return Double.parseDouble(resultSpeed[3].substring(1))<expectedResult;
    }
}
