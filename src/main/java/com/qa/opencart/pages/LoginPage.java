package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtils;

import io.qameta.allure.Step;

public class LoginPage {
	private WebDriver driver;
	private ElementUtils eleutil;

	// 1. Private By Locator-- page locator
	private By email = By.name("email");
	private By password = By.name("password");
	private By loginBtn = By.xpath("//input[@type='submit']");
	private By seachField = By.name("search");
	private By forgotPassword = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By ForgotPasswordLink = By.linkText("Forgotten Password");

	// 2. public page constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtils(driver);
	}

	// 3.public page constructor
	public String getLoginPageTitle() {
		String title = eleutil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, 5);
		System.out.println("Login page title is: " + title);
		return title;
	}

	@Step("getting login page url......")
	public String getLoginPageURL() {
		String url = eleutil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION, 5);
		System.out.println("Login page url is: " + url);
		return url;
	}

	@Step("is forgotpassword link exist or not......")
	public boolean isForgotPasswordLinkExist() {
		return eleutil.waitForElementVisible(forgotPassword, 10).isDisplayed();
	}

	@Step("Login to app with username: {0} and password: {1}......")
	public AccountsPage doLogin(String userName, String pwd) {
		System.out.println("App Credentials are: " + userName + " and " + pwd);
		eleutil.waitForElementVisible(email, AppConstants.MEDIUM_TIME_OUT).sendKeys(userName);
		eleutil.doSendKeys(password, pwd);
		eleutil.doClick(loginBtn);
		// return eleutil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE, 5);
		return new AccountsPage(driver);
	}

	@Step("Navigating to register page......")
	public RegisterPage navigateToRegisterPage() {
		eleutil.waitForElementVisible(registerLink, AppConstants.MEDIUM_TIME_OUT).click();
		return new RegisterPage(driver);
	}

}
