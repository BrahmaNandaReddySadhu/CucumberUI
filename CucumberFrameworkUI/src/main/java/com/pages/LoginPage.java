package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	
	/*
	 *   3 thing we need maintains
	 *   
	 *   1) By locator
	 *   2) Constructor
	 *   3) Actions
	 *   
	 *   
	 *   here we are using Encapsulation
	 *   
	 *   locators --> private
	 *   actions are public 
	 */
	
	
	
	private WebDriver driver;
	
	// 1 locators
	
	private By email = By.id("email");
	private  By password = By.id("passwd");
	private By submitLink =By.id("SubmitLogin");
	private By forgotpasswordLinkBy = By.id("forgotPasswordLink");
	
	
	
	
	
	// 2 Constructor
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	// 3 page Actions
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordLinkExist() {
		return driver.findElement(By.linkText("Forgot your password?")).isDisplayed();
	}
	
	public void enterUsername(String userName) {
		driver.findElement(email).sendKeys(userName);
	}
	
	public void enterPassword(String passwordText) {
		driver.findElement(password).sendKeys(passwordText);
	}	
	
	public void clickOnLoginButton() {
		driver.findElement(submitLink).click();
	}
}
