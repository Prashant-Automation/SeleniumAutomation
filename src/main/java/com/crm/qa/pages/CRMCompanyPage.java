package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRMTestBase;

public class CRMCompanyPage extends CRMTestBase {
	
	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement companiesTitle;
	
	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement newCompaniesBtn;
	
	@FindBy(name = "name")
	WebElement companiesName;
	
	@FindBy(name = "address")
	WebElement companiesAdd;
	
	@FindBy(name = "city")
	WebElement companiesCity;
	
	public CRMCompanyPage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyCompaniesTitle() {
		return companiesTitle.isDisplayed();
	}
	public void createNewCompanies(String comName) throws InterruptedException {
		Thread.sleep(5000);
		newCompaniesBtn.click();
		Thread.sleep(5000);
		companiesName.sendKeys(comName);
//		Thread.sleep(3000);
//		companiesAdd.sendKeys(comAdd);
//		companiesCity.sendKeys(comCity);
		
	}
	

}
