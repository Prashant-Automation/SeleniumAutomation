package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRMTestBase;

public class CRMTasksPage extends CRMTestBase{

	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement newTaskBtn;

	@FindBy(xpath = "//input[@name='title' and @type='text']")
	WebElement title;

	@FindBy(xpath = "//div[@class='ui fluid selection dropdown']")
	WebElement assignto;

	public CRMTasksPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNewTasKBtn () {
     newTaskBtn.click();
	}

	public void selectTaskTitle(String tt) throws InterruptedException {
		Thread.sleep(5000);
		newTaskBtn.click();
		Thread.sleep(5000);
		title.sendKeys(tt);
	}


}
