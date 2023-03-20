package com.mgp.mobile.demo1.testng.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@MakeAPayment",
        features = "classpath:features",
        glue = {"com.mgp.mobile.demo1.common", "com.mgp.mobile.demo1.stepdefinitions", "com.mgp.mobile.demo1.testng.runner"},
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json", "html:target/cucumber-reports/cucumberreport.html"},
        monochrome = true
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
