package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.CRMTestBase;

public class CRMContactsPage extends CRMTestBase {
	
	// Define Page Object with help of Page Factory

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement contactTitle;

	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement newContactBtn;

	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "last_name")
	WebElement lastName;

	@FindBy(name = "company")
	WebElement company;

	@FindBy(name = "address")
	WebElement address;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "country")
	WebElement country;

	// Create the constructor of page class and Initialize the Page Factory

	public CRMContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Define the Page Action/Method of the Feature
	
	public boolean verifyContactTitle() {
		return contactTitle.isDisplayed();
	}
	
	public void creatNewContact(String fn,String ln) throws InterruptedException  {
		Thread.sleep(5000);
		newContactBtn.click();
		Thread.sleep(3000);
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
	
	}

	
}
