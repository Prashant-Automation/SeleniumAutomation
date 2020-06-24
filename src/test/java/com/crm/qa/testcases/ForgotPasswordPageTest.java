package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.CRMTestBase;
import com.crm.qa.pages.CRMLoginPage;
import com.crm.qa.pages.ForgotPasswordPage;

public class ForgotPasswordPageTest extends CRMTestBase {
	
	ForgotPasswordPage forgotpasswordpage;
	CRMLoginPage crmloginpage;
	
	@BeforeMethod
	public void setUp() {
		Initalization();
		crmloginpage = new CRMLoginPage();
		forgotpasswordpage = new ForgotPasswordPage();
		forgotpasswordpage = crmloginpage.getforgotPassword();	
	}
	
	@Test(priority = 2,groups = "Reset Pwd")
	public void resetPassword() {
		forgotpasswordpage.enterEmailAddress(prop.getProperty("username"));	
	}

	@Test (priority = 1,groups = "Reset Pwd")
	public void verifyForgotPwdHeaderTest() {
		Assert.assertTrue(forgotpasswordpage.verifyForgotPwdHeader(), "Forgot Password Header is not correct");
	}
	
	@Test (priority = 3,groups = "Reset Pwd")
	public void verifyGoToAccountLinkTest() {
		Assert.assertTrue(forgotpasswordpage.verifyGoToAccountLink(), "Go To Account ? Log in here link is not correct");
	}
	
	@Test(priority = 4,groups = "Reset Pwd")
	public void clickOnGoToAccountTest() {
		crmloginpage = forgotpasswordpage.clickOnGoToAccount();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
