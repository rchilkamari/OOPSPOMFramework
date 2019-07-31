/**
 * 
 */
package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author rchil
 *
 */
public class LoginPage extends BasePage {
	
	//Page locators
	
	private By emailId = By.id("username");
	private By Password =By.id("password");
	private By Login = By.id("loginBtn");
	private By header = By.xpath("//i18n-string[@data-key='login.signupLink.text']");
	

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//public getters:


	/**
	 * @return the emailId
	 */
	public WebElement getEmailId() {
		return getElement(emailId);
	}


	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(Password);
	}


	/**
	 * @return the login
	 */
	public WebElement getLogin() {
		return getElement(Login);
	}


	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}
	
	
	public String getLoginPageTitle() {
		
		return getPageTitle();		
		
	}
	
	public String getLoginPageHeader() {
		
		return getPageHeader(header);
		
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws InterruptedException 
	 */
	
	public HomePage doLogin(String username,String password) throws InterruptedException {
		getEmailId().sendKeys(username);
		getPassword().sendKeys(password);
		getLogin().click();
		Thread.sleep(5000);
		return getInstance(HomePage.class);
		
	}
	
	//Method overloading
	
	/**
	 * Negative Testing
	 * @return 
	 * 
	 * @return
	 */
	
	public void doLogin() {
		getEmailId().sendKeys();
		getPassword().sendKeys();
		getLogin().click();
		//return getInstance(HomePage.class);
		
	}
	
	/**
	 * 
	 * 
	 * @param username
	 
	 * @return
	 */

	
	//username: raj@test.com
	
	public void doLogin(String usercred) {	
		
		if(usercred.contains("username")) {
			
			getEmailId().sendKeys(usercred.split(":")[1].trim());
			
		}else if(usercred.contains("password")) {
			
			getPassword().sendKeys(usercred.split(":")[1].trim());
			
		}		
		
		getLogin().click();
		//return getInstance(HomePage.class);
		
	}
	
	
	
	

}
