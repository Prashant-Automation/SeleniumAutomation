package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.CRMTestBase;
import com.crm.qa.pages.CRMHomePage;
import com.crm.qa.pages.CRMLoginPage;
import com.crm.qa.pages.CRMSignUpPage;
import com.crm.qa.pages.ForgotPasswordPage;

public class CRMLoginPageTest extends CRMTestBase {

	CRMLoginPage crmloginpage;
	CRMHomePage crmhomepage;
	ForgotPasswordPage forgotpasswordpage;
	CRMSignUpPage crmsignuppage;
	
	public CRMLoginPageTest() {
		super();
	}

	@BeforeMethod()
	public void setUp() {
		Initalization();
		crmloginpage = new CRMLoginPage();
	}
	
	@Test (priority = 1, groups = "Login")
	public void VerifyLoginPageTitleTest() {
		String title = crmloginpage.verifyLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM", "Login Page Title is not Correct" );
	}
	
	@Test (priority = 2, groups = "Login")
	public void loginPageTest() {
		crmhomepage = crmloginpage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));	
	}
	
	@Test (priority = 3, groups = "Forgot Pwd")
	public void verifyForgotPwdLinkTest() {
		Assert.assertTrue(crmloginpage.verifyForgotPwdLink(), " Forgot Password Link is not Visiable");
	}
	
	@Test(priority = 4, groups = "Forgot Pwd")
	public void getforgotPwdTest() {
		forgotpasswordpage = crmloginpage.getforgotPassword();
	}
	
	@Test (priority = 6, groups = " SignUp")
	public void registerSignUpTest() {
		crmsignuppage = crmloginpage.registerSignUpPage();
	}
	
	@Test(priority = 5, groups = "SignUp")
	public void verifySignUpLinkTest() {
		Assert.assertTrue(crmloginpage.verifySignUpLink(), "SignUp link is not visiable");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
