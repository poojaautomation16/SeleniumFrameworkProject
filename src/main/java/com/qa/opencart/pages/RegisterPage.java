package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtils;

public class RegisterPage {
	
	private WebDriver driver;
	private ElementUtils eleutil;
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-password");
	
	private By subscribeYes = By.xpath("//label[@class='radio-inline']//input[@value='1']");
	private By subscribeNo = By.xpath("//label[@class='radio-inline']//input[@value='0']");
	
	private By agreeCheckBox = By.xpath("//input[@type='checkbox']");
	private By continueButton = By.xpath("//input[@value='Continue']");
	
	private By successMsg = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtils(driver);
	}
	
	public boolean registerUser(String firstName,String lastName, 
			String email, String telephone, String password, String subscribe ) {
	 eleutil.waitForElementVisible(this.firstName, AppConstants.MEDIUM_TIME_OUT).sendKeys(firstName);
	 eleutil.doSendKeys(this.lastName, lastName);
	 eleutil.doSendKeys(this.email, email);
	 eleutil.doSendKeys(this.telephone, telephone);
	 eleutil.doSendKeys(this.password, password);
	 eleutil.doSendKeys(this.confirmPassword, password);
	 
	 if (subscribe.equalsIgnoreCase("yes")) {
		 eleutil.doClick(subscribeYes); 
	 }
	 else {
		 eleutil.doClick(subscribeNo);
	 }
	 eleutil.doClick(agreeCheckBox);
	 eleutil.doClick(continueButton);
	 
	String successMsg = eleutil.waitForElementVisible(this.successMsg , AppConstants.MEDIUM_TIME_OUT).getText();
	System.out.println(successMsg);
	if (successMsg.contains(AppConstants.USER_REGISTER_SUCCESS_MSG)) { 
		eleutil.doClick(logoutLink);
		eleutil.doClick(registerLink);
	return true;	
	}
	return false;
}
}
