package com.crm.qa.testcases;
import java.util.concurrent.TimeUnit;

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


public class CRMContactsPageTest extends CRMTestBase{

	CRMHomePage crmhomepage;
	CRMLoginPage crmloginpage;
	CRMContactsPage crmcontactspage;

	String sheetName = "Contacts";


	public CRMContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		Initalization();
		crmloginpage = new CRMLoginPage();
		crmhomepage = new CRMHomePage();
		crmcontactspage = new CRMContactsPage();
		crmhomepage = crmloginpage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
		crmcontactspage = crmhomepage.clickOnContacts();

	}

	@Test(priority = 1)
	public void verifyContactTitleTest() {
		Assert.assertTrue(crmcontactspage.verifyContactTitle(), "Contact Title Lable is Missing on Page");	
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = CRMUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority = 2, dataProvider = "getCRMTestData")
	public void createNewContactTest(String FirstName,String LastName) throws InterruptedException {
		//crmcontactspage.creatNewContact("Rahi", "Roy", "Malik");
		crmcontactspage.creatNewContact(FirstName, LastName);	
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
