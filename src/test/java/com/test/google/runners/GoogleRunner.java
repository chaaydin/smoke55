package com.test.google.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/google",
        glue="com/test/google/stepdefinitions",
        dryRun = false,
        tags = "@smoke"
)
public class GoogleRunner {
}
