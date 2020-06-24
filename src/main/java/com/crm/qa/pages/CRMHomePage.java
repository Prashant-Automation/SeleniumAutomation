package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRMTestBase;

public class CRMHomePage extends CRMTestBase {
	
	@FindBy(xpath = "//span[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//span[contains(text(),'Companies')]")
	WebElement companiesLink;
	
	@FindBy(xpath = "//span[contains(text(),'Calendar')]")
	WebElement calendarLink;
	
	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//span[contains(text(),'Cases')]")
	WebElement casesLink;
	
	@FindBy(xpath = "//span[contains(text(),'Call')]")
	WebElement callLink;
	
	public CRMHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitleName() {
		return driver.getTitle();
	}
	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}
	public CRMContactsPage clickOnContacts() {
		contactLink.click();
		return new CRMContactsPage();	
	}
	public CRMDealsPage clickOnDeals() {
		dealsLink.click();
		return new CRMDealsPage();	
	}
	public CRMCompanyPage clickOnCompanies() {
		companiesLink.click();
		return new CRMCompanyPage();	
	}
	public CRMCalendarPage clickOnCalendar() {
		calendarLink.click();
		return new CRMCalendarPage();	
	}
	public CRMTasksPage clickOnTasks() {
		tasksLink.click();
		return new CRMTasksPage();	
	}
	public CRMCasesPage clickOnCases() {
		casesLink.click();
		return new CRMCasesPage();	
	}
	public CRMCallPage clickOnCall() {
		callLink.click();
		return new CRMCallPage();	
	}
	
	
	
	

}
