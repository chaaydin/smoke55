package com.test.smartbear.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/uiFailedTests.txt",
        glue= "com/test/smartbear/stepdefinitions",
        tags="@regression",
        plugin= {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)
public class SmartbearReRunner {
}
