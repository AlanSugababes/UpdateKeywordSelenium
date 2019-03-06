package com.qa.sugababes.alan.sentinel.AddingKeywordsSeleniumTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:")
public class SentinelTestRunner {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeClass
	public static void beforeTestSetup() {
		extent = new ExtentReports(Constants.ReportLocation);
	}
	@AfterClass
	public static void afterTestTeardown() {
		extent.endTest(test);
		extent.flush();
	}

}
