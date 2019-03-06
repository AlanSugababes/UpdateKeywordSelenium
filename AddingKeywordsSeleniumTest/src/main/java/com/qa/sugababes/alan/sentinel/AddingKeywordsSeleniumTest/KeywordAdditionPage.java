package com.qa.sugababes.alan.sentinel.AddingKeywordsSeleniumTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KeywordAdditionPage {

	WebElement driver;
	
	@FindBy(xpath = "//*[@id=\"submitButton\"]")
	WebElement SubmitButton;
	
	@FindBy(xpath = "//*[@id=\"NewKeyword\"]")
	WebElement KeywordInput;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/nav/div/div/p[4]")
	WebElement StateMessageSubmitted;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/nav/div/div/p[3]")
	WebElement StateMessageDuplicate;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/nav/div/div/p[2]")
	WebElement StateMessageNoKeyword;
	
	public void clickSubmit() {
		SubmitButton.click();
	}
	
	public void clickKeywordTextBox() {
		KeywordInput.click();
	}
	
	public void keywordInput(String text) {
		KeywordInput.sendKeys(text);
	}
	
	public void keywordRemove () {
		KeywordInput.sendKeys("I");
		KeywordInput.sendKeys(Keys.BACK_SPACE);
	}
	
	public String getResultSubmitted() {
		return StateMessageSubmitted.getText();
	}

	public String getResultDuplicate() {
		return StateMessageDuplicate.getText();
	}

	public String getResultNoKeyword() {
		return StateMessageNoKeyword.getText();
	}
	
	

}
