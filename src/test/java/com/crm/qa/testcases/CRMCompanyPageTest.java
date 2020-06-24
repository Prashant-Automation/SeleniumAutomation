package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.CRMTestBase;
import com.crm.qa.pages.CRMCompanyPage;
import com.crm.qa.pages.CRMContactsPage;
import com.crm.qa.pages.CRMHomePage;
import com.crm.qa.pages.CRMLoginPage;

public class CRMCompanyPageTest extends CRMTestBase {
	
	CRMHomePage crmhomepage;
	CRMLoginPage crmloginpage;
	CRMCompanyPage crmcompanyspage;

	public CRMCompanyPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Initalization();
		crmloginpage = new CRMLoginPage();
		crmhomepage = new CRMHomePage();
		crmcompanyspage = new CRMCompanyPage();
		crmhomepage = crmloginpage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
		crmcompanyspage = crmhomepage.clickOnCompanies();
	}
	@Test(priority = 1)
	public void verifyCompanyTitleTest() {
		Assert.assertTrue(crmcompanyspage.verifyCompaniesTitle());
	}
	@Test(priority = 2)
	public void createNewCompanyTest() throws InterruptedException {
		crmcompanyspage.createNewCompanies("Jaguar");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
