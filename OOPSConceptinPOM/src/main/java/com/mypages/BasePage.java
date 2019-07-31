package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();

	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("Some error occurred while creating eleemnt " + locator.toString());
			e.printStackTrace();

		}
		return element;

	}

	@Override
	public void waitForElementPresent(By locator) {

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		} catch (Exception e) {
			System.out.println("Some Exception occured while waiting for the element" + locator.toString());
			e.fillInStackTrace();

		}

	}

	@Override
	public void waitForPageTitle(String title) {
		// TODO Auto-generated method stub

		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			System.out.println("Some Exception occured while waiting to load the page title" + title );
			e.fillInStackTrace();

		}
	}

}
