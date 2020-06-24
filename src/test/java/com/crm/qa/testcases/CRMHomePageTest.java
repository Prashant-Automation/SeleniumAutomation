package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.CRMTestBase;
import com.crm.qa.pages.CRMCalendarPage;
import com.crm.qa.pages.CRMCallPage;
import com.crm.qa.pages.CRMCasesPage;
import com.crm.qa.pages.CRMCompanyPage;
import com.crm.qa.pages.CRMContactsPage;
import com.crm.qa.pages.CRMDealsPage;
import com.crm.qa.pages.CRMHomePage;
import com.crm.qa.pages.CRMLoginPage;
import com.crm.qa.pages.CRMTasksPage;

public class CRMHomePageTest extends CRMTestBase {

	CRMHomePage crmhomepage;
	CRMLoginPage crmloginpage;
	CRMContactsPage crmcontactspage;
	CRMDealsPage crmdealspage;
	CRMCompanyPage crmcompanypage;
	CRMTasksPage crmtaskspage;
	CRMCalendarPage crmcalendarpage;
	CRMCasesPage crmcasespage;
	CRMCallPage crmcallpage;

	public CRMHomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		Initalization();
		crmloginpage = new CRMLoginPage();
		crmhomepage = new CRMHomePage();
		crmcontactspage = new CRMContactsPage();
		crmdealspage = new CRMDealsPage();
		crmcalendarpage = new CRMCalendarPage();
		crmcompanypage = new CRMCompanyPage();
		crmtaskspage = new CRMTasksPage();
		crmcasespage = new CRMCasesPage();
		crmcallpage = new CRMCallPage();
		crmhomepage = crmloginpage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test(priority = 1)
	public void verifyTitleNameTest() {
		String title = crmhomepage.verifyTitleName();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	@Test(priority = 2)
	public void verifyUserNameTest() {
		Assert.assertTrue(crmhomepage.verifyUserName());	
	}
	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		crmcontactspage = crmhomepage.clickOnContacts();
	}
	@Test(priority = 5)
	public void verifyDealsLinkTest() {
		crmdealspage = crmhomepage.clickOnDeals();
	}
	@Test(priority = 4)
	public void verifyCompanyLinkTest() {
		crmcompanypage = crmhomepage.clickOnCompanies();
	}
	@Test(priority = 6)
	public void verifyCalendarLinkTest() {
		crmcalendarpage = crmhomepage.clickOnCalendar();
	}
	@Test(priority = 7)
	public void verifyTasksLinkTest() {
		crmtaskspage = crmhomepage.clickOnTasks();
	}
	@Test(priority = 8)
	public void verifyCasesLinkTest() {
		crmcasespage = crmhomepage.clickOnCases();
	}
	@Test(priority = 9)
	public void verifyCallLinkTest() {
		crmcallpage = crmhomepage.clickOnCall();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
