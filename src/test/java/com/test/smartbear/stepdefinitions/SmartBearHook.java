//package com.test.smartbear.stepdefinitions;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import org.openqa.selenium.WebDriver;
//import utils.BrowserUtils;
//import utils.ConfigReader;
//import utils.DriverHelper;
//
//public class SmartBearHook {
//    WebDriver driver= DriverHelper.getDriver();
//
//    @Before
//    public void setup(){
//        driver.get(ConfigReader.readProperty("QA_smartbear_url"));
//    }
//
//    @After
//    public void tearDown(Scenario scenario){
//        BrowserUtils.getScreenShotForCucumber(driver,scenario);
//        driver.quit();
//    }
//}
