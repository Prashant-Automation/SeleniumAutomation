package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRMTestBase;

public class ForgotPasswordPage extends CRMTestBase {
	
	// Define Page Object with help of Page Factory
	
	@FindBy(xpath = "//h2[contains(@class,'ui blue header')]")
	WebElement forgotPwdHeader;
	
	@FindBy(name = "email")
	WebElement emailAdd;
	
	@FindBy(xpath = "//button[contains(text(),'Reset password')]")
	WebElement resetbtn;
	
	@FindBy(xpath = "//button[contains(text(),'Reset password')]")
	WebElement goToAccount;
	
	// Create the constructor of page class and Initialize the Page Factory
	
	public ForgotPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Define the Page Action/Method of the Feature
	
	public boolean verifyForgotPwdHeader() {
		return forgotPwdHeader.isDisplayed();	
	}
	public void enterEmailAddress(String ed) {
		emailAdd.sendKeys(ed);
		resetbtn.click();	
	}
	public boolean verifyGoToAccountLink() {
		return goToAccount.isDisplayed();	
	}
	public CRMLoginPage clickOnGoToAccount() {
		goToAccount.click();
		return new CRMLoginPage();
	}
	
}

//Thank you. If this account is registered you will receive an email with a password reset link.