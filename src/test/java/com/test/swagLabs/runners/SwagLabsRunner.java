package com.test.swagLabs.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/resources/features/swagLabs",
        glue= "com/test/swagLabs/stepdefinitions",
        dryRun = false,
        tags= "@regression",
        plugin = {"pretty","html:target/uireport.html","rerun:target'uiFailedTests.txt",
                  "json:target/cucumber-reports/cucumber.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)


public class SwagLabsRunner {

}
