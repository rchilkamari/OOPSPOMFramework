/**
 * 
 */
package com.MyTests;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mypages.BasePage;
import com.mypages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author rchil
 *
 */
public class BaseTest {
	
	WebDriver driver;
	public Page page;
	public static Logger logger;
	
	@BeforeClass
	@Parameters(value = {"browser"})
	
	public void setup(String browser) throws InterruptedException {
		
		logger =Logger.getLogger("OOpsPOM");
		PropertyConfigurator.configure("Log4j.properties");
		
		
		if(browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
		}
		else if(browser.equals("InternetExplorer")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();			
		}
		else if(browser.equals("ff")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else {System.out.println("no driver defined in xml file");
		}
		
		driver.get("https://app.hubspot.com/login");
		driver.manage().deleteAllCookies();
		Thread.sleep(10000);
		
		page = new BasePage(driver);
		
		
		
	}
	
	@AfterClass
	
	public void teardown() {
		
		driver.quit();
	}
	

}
