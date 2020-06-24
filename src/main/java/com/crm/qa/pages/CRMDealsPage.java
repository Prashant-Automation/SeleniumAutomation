package com.crm.qa.pages;
import java.awt.Desktop.Action;
import java.util.List;
import org.apache.xmlbeans.impl.store.SaxonXBeansDelegate.SelectPathInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.CRMTestBase;

public class CRMDealsPage extends CRMTestBase {

	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement newdealbtn;

	@FindBy(xpath = "//input[@name='title']")
	WebElement title;

	@FindBy(xpath = "//div[@class='ui fluid selection dropdown']")
	WebElement assignto;

	@FindBy(xpath ="//span[@class='sizer']//parent::div[@name='products']//input[@class='search']")
	WebElement product;

	@FindBy(xpath ="//div[@name='company']//input[@class='search']")
	WebElement company;

	@FindBy(name= "description")
	WebElement description;

	@FindBy(xpath ="//div[@class='default text']//parent::div[@name='stage']")
	WebElement stage;

	@FindBy(xpath ="//div[@class='default text']//parent::div[@name='status']")
	WebElement status;

	@FindBy(xpath ="//div[@class='ui toggle checkbox']//input[@name='closed']")
	WebElement Closed;

	public CRMDealsPage() {
		PageFactory.initElements(driver, this);
	}
	public  void selectTitleandDescription(String text,String msg) throws InterruptedException {
		Thread.sleep(3000);
		newdealbtn.click();
		Thread.sleep(3000);
		title.sendKeys(text);
		description.sendKeys(msg);
	}
	public void selectmethod() {
		//Selecting bootstrap dropdown
		assignto.click();
		List<WebElement> options = driver.findElements(By.xpath("//span[@class='text']//parent::div[@class='selected item'and @role='option']"));
		System.out.println(options.size());
		options.get(1).click();
	}	
	//span[@class='text']//parent::div[@class='selected item addition']
	public void selectProduct(String prod) throws InterruptedException {
		Thread.sleep(3000);
		product.sendKeys(prod);
		List<WebElement> option = driver.findElements(By.xpath("//span[@class='text']//parent::div[@class='selected item addition']"));
		System.out.println(option.size());
		for (int i=0; i<option.size(); i++){
			System.out.println(option.get(i).getText());
			if(option.get(i).getText().contains(prod)){
				option.get(i).click();
				break;
			}
		}
	}
	public void selectCompany(String comp) throws InterruptedException {
		Thread.sleep(3000);
		company.sendKeys(comp);

		List<WebElement> option1 = driver.findElements(By.xpath("//span[@class='text']//parent::div[@class='selected item addition']"));
		System.out.println(option1.size());
		for(int i=0; i<option1.size(); i++) {
			System.out.println(option1.get(i).getText());
			if(option1.get(i).getText().contains(comp)) {
				option1.get(i).click();
				break;
			}	
		}
	}

	public void selectStage() throws InterruptedException {
		Thread.sleep(3000);
		stage.click();
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='visible menu transition']//div[@role='option']//span[@class='text']"));
		System.out.println(options.size());
		options.get(2).click();
	}
	public void selectStatus() throws InterruptedException {
		Thread.sleep(3000);
		status.click();
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='visible menu transition']//div[@role='option']//span[@class='text']"));
		System.out.println(options.size());
		options.get(1).click();
	}
	public boolean clickOnClosed() throws InterruptedException {
		Thread.sleep(3000);
		WebElement toggle = driver.findElement(By.xpath("//input[@name='closed']"));
		if(toggle.isSelected()) 
			toggle.click();
		return true;
	}
	//	public void selectDate() throws InterruptedException {
	//	Thread.sleep(3000);
	//	newdealbtn.click();
	//	Thread.sleep(3000);
	//	String date = "15-September-2020";
	//	String dateArr[] = date.split("-");
	//	String day = dateArr[0];a
	//	String month = dateArr[1];
	//	String year = dateArr[2];
	//	driver.findElement(By.xpath("//input[@type='text']//parent::div[@class='react-datepicker__input-container']")).click();
	//	
	//	String beforeXpath = "//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[4]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[";
	//	String afterXpath = "]/div[";	
	//	
	//	final int totalweekdays = 7;
	//	for(int rowNum=2; rowNum<=7; rowNum++) {
	//		for(int colNum=1; colNum<=totalweekdays; colNum++) {	
	//			String daysvalue = driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+"]")).getText();
	//			System.out.println(daysvalue);
	//		}
	//		
	//	}

	//}
}

