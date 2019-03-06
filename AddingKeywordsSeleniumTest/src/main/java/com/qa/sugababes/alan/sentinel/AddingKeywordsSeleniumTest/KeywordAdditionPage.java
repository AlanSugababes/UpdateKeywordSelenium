package com.qa.sugababes.alan.sentinel.AddingKeywordsSeleniumTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KeywordAdditionPage {

	WebElement driver;
	
	@FindBy(xpath = "")
	WebElement SubmitButton;
	
	@FindBy(xpath = "")
	WebElement KeywordInput;
	
	@FindBy(xpath = "")
	WebElement StateMessage;
	
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
	
	public String getResult() {
		return StateMessage.getText();
	}

}
