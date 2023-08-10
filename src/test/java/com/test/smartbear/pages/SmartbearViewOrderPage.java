package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class SmartbearViewOrderPage {
    public SmartbearViewOrderPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//tr[2]//td")
    List<WebElement> paymentMethod;

    public void addedPaymentMethodFunc(String name,String product,String quantity,String street,String city,String state,
                                       String zip,String card,String number,String expireDate) throws InterruptedException {
        Thread.sleep(500);

        //making dynamic the date
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now= LocalDateTime.now();
        String currentDate=dtf.format(now);
        List<String> expectedList= Arrays.asList("",name,product,quantity,currentDate,street,city,state,
                zip,card,number,expireDate,"");
        System.out.println(expectedList);
        for (int i=1; i< paymentMethod.size()-1;i++){
            System.out.println(expectedList.get(i).trim());
            System.out.println(BrowserUtils.getText(paymentMethod.get(i)));
            Assert.assertEquals(expectedList.get(i).trim(),BrowserUtils.getText(paymentMethod.get(i)));

        }
    }
}
