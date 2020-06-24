package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.CRMTestBase;
import com.crm.qa.pages.CRMDealsPage;
import com.crm.qa.pages.CRMHomePage;
import com.crm.qa.pages.CRMLoginPage;
import com.crm.qa.pages.CRMTasksPage;

public class CRMTaskPageTest extends CRMTestBase{
	
	CRMHomePage crmhomepage;
	CRMLoginPage crmloginpage;
	CRMTasksPage crmtaskspage;
	
	public CRMTaskPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()  {
		Initalization();
		crmloginpage = new CRMLoginPage();
		crmhomepage = new CRMHomePage();
		crmtaskspage = new CRMTasksPage();
		crmhomepage = crmloginpage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
		crmtaskspage = crmhomepage.clickOnTasks();
//		crmtaskspage.clickOnNewTasKBtn();
	}
	@Test
	public void createNewTask() throws InterruptedException {
		crmtaskspage.selectTaskTitle("Miss");
	}

}
