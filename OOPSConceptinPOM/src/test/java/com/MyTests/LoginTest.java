/**
 * 
 */
package com.MyTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypages.HomePage;
import com.mypages.LoginPage;

/**
 * @author rchil
 *
 */
public class LoginTest extends BaseTest {
	
	@Test(priority=1)
	
	
	public void verifyLoginpageTitleTest() {
		
		logger.info("********Starting Project***************");
		
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		logger.info("Getting Page title");
		
		System.out.println(title);
		Assert.assertEquals(title, "HubSpot Login");
		logger.info("Validated Page title");
		
	}
	
	@Test(priority=2)
	
	
	public void verifyLoginPageHeaderTest() {
		
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		logger.info("Getting LoginPage Header");		
		System.out.println(header);
		Assert.assertEquals(header, "Don't have an account?");
		logger.info("PageHeader validated");
		
	}
	
	@Test(priority=3)
	
	public void doLoginTest() throws InterruptedException {
		
		HomePage homepage =page.getInstance(LoginPage.class).doLogin("rchilkamari@gmail.com", "Bittu@3003");
		logger.info("Login Credentials entered");
		
		String headerhome =homepage.getHomePageHeader();
		logger.info("Getting Page Header");
		System.out.println(headerhome);
		Assert.assertEquals(headerhome, "Getting started with HubSpot");
		logger.info("Validated homwheader");
		
		
	}
	

}
