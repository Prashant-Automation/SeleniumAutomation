package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.CRMTestBase;
import com.crm.qa.pages.CRMContactsPage;
import com.crm.qa.pages.CRMDealsPage;
import com.crm.qa.pages.CRMHomePage;
import com.crm.qa.pages.CRMLoginPage;
import com.crm.qa.util.CRMUtil;

public class CRMDealsPageTest extends CRMTestBase{
	
	CRMHomePage crmhomepage;
	CRMLoginPage crmloginpage;
	CRMDealsPage crmdealspage;
	
//	String sheetName = "Deals";
	
	public CRMDealsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Initalization();
		crmloginpage = new CRMLoginPage();
		crmhomepage = new CRMHomePage();
		crmdealspage = new CRMDealsPage();
		crmhomepage = crmloginpage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
		crmdealspage = crmhomepage.clickOnDeals();
	}
//	@DataProvider
//	public Object[][] getCRMTestData() {
//		Object data[][] = CRMUtil.getTestData(sheetName);
//		return data;
//	}
	
	@Test
	public void createNewDealTest() throws InterruptedException {
		crmdealspage.selectTitleandDescription("Miss","This deal for Markrting Team");
//		crmdealspage.selectmethod();
//		crmdealspage.selectProduct("Plastic");
//		crmdealspage.selectCompany("Redmi");
//		crmdealspage.selectStage();
		crmdealspage.selectStatus();
		Assert.assertTrue(crmdealspage.clickOnClosed());
	}
	@AfterMethod
	public void tearDown() {
//	driver.quit();
	}

}
