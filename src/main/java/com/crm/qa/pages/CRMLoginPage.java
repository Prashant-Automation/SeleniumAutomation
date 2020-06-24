package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.CRMTestBase;


public class CRMLoginPage extends CRMTestBase {
	
	// Define Page Object with help of Page Factory
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[(text()='Login')]")
	WebElement loginbtn;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot your password')]")
	WebElement forgotpwd;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signup;
	
	// Create the constructor of page class and Initialize the Page Factory
	
	public CRMLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Define the Page Action/Method of the Feature
	
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	public CRMHomePage validateLogin(String un, String pd) {
		username.sendKeys(un);
		password.sendKeys(pd);
		loginbtn.click();
		return new CRMHomePage();
	}
	public boolean verifyForgotPwdLink() {
		return forgotpwd.isDisplayed();
	}
	public ForgotPasswordPage getforgotPassword() {
		forgotpwd.click();
		return new ForgotPasswordPage();
	}
	public boolean verifySignUpLink() {
		return signup.isDisplayed();
	}
	public CRMSignUpPage registerSignUpPage() {
		signup.click();
		return new CRMSignUpPage();
	}
	

}
