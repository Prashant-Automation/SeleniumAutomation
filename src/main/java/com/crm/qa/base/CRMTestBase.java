package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.util.CRMUtil;

public class CRMTestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public CRMTestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream ("S:\\eclipse2020\\FreeCRMPOM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Initalization() {
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Sonpari\\Desktop\\New_pro\\Gecko driver jar\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}else if (browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Sonpari\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();	

		}else if (browsername.equals("IE")) {
			System.setProperty("webdriver.ie.driver","C:\\Users\\Sonpari\\Downloads\\internatexplorerdriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(CRMUtil.Page_load_time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(CRMUtil.Implicit_wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	

}
