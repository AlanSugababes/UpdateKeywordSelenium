package com.qa.sugababes.alan.sentinel.AddingKeywordsSeleniumTest;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SentinelSteps {
	
	public String duplicateWord = "bomb";
	public String successfulAddition = "Keyword has been submitted";
	public String emptyAddition = "Error 301: No keyword entered, please enter a keyword!";
	public String duplicateAddition = "Error 302: Duplicate keyword entered please enter a new keyword!";

	
	public WebDriver driver;
	public ExtentTest test;
	public ExtentReports extent;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",Constants.ChromeDriver);
		test = extent.startTest("Adding Keyword Test");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		driver.quit();
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address() {
		test.log(LogStatus.INFO,"Loading webpage and maximizing");
		driver.manage().window().maximize();
		driver.get(Constants.URL);
	}

	@When("^I click submit with a valid keyword$")
	public void i_click_submit_with_a_valid_keyword() {
		KeywordAdditionPage addition = PageFactory.initElements(driver, KeywordAdditionPage.class);
			
			test.log(LogStatus.INFO,"Entering valid keyword");
			addition.clickKeywordTextBox();
			addition.keywordInput(successfulAddition);
			test.log(LogStatus.INFO, "Clicking submit button");
			addition.clickSubmit();
	}

	@Then("^a message stating the keyword has been added is displayed$")
	public void a_message_stating_the_keyword_has_been_added_is_displayed() {
		KeywordAdditionPage addition = PageFactory.initElements(driver,KeywordAdditionPage.class);
		
			if(successfulAddition == addition.getResult()) {
				test.log(LogStatus.PASS,"Test Passed");
				assertEquals(successfulAddition, addition.getResult());
			}else {
				test.log(LogStatus.FAIL,"Test Failed");
		}
	}

	@When("^I click submit and the word already exists$")
	public void i_click_submit_and_the_word_already_exists() {
		KeywordAdditionPage addition = PageFactory.initElements(driver, KeywordAdditionPage.class);
		
			test.log(LogStatus.INFO, "Clicking submit button");
			addition.keywordInput(duplicateWord);
			addition.clickSubmit();
	}

	@Then("^an error message is displayed$")
	public void an_error_message_is_displayed() {
		KeywordAdditionPage addition = PageFactory.initElements(driver, KeywordAdditionPage.class);
		
			if(duplicateAddition == addition.getResult()) {
				test.log(LogStatus.PASS, "Test Passed");
				assertEquals(duplicateAddition, addition.getResult());
			}else {
				test.log(LogStatus.FAIL, "Test Failed");
			}
	}

	@When("^I click submit with no keyword entered$")
	public void i_click_submit_with_no_keyword_entered() {
		KeywordAdditionPage addition = PageFactory.initElements(driver, KeywordAdditionPage.class);
		
			test.log(LogStatus.INFO, "Clicking submit button");
			addition.clickKeywordTextBox();
			addition.keywordRemove();
			addition.clickSubmit();
	}

	@Then("^an error messaged is displayed$")
	public void an_error_messaged_is_displayed() {
		KeywordAdditionPage addition = PageFactory.initElements(driver, KeywordAdditionPage.class);
		
			if(emptyAddition == addition.getResult()) {
				test.log(LogStatus.PASS, "Test Passed");
				assertEquals(emptyAddition, addition.getResult());
			}else {
				test.log(LogStatus.FAIL, "Test Failed");
			}
	}
	
	
}
