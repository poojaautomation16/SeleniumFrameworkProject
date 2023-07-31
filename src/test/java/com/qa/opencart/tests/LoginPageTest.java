package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("EPIC-100: Design of the login page for opencart app")
@Story("User Story-200: implement login page features for open cart app")
public class LoginPageTest extends BaseTest {
	@Description("login page title test......")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
	}

	@Description("login page url test......")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void LoginPageURLTest() {
		String actualURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
	}
	
	@Description("check forgot Password link Exist on Login Page......")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void isForgotPasswordLinkExist() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}
	
	@Description("check user is able to login with valid credentials......")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 4)
	public void doLogin() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccountPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);
		
	}

}
