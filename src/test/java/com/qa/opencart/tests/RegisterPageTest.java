package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtils;

public class RegisterPageTest extends BaseTest {
	
	@BeforeClass
	public void regSetUp(){
		registerPage = loginPage.navigateToRegisterPage();	
	}
	
	public static String getRandomEmailId() {
		return "openauto" + System.currentTimeMillis() + "@open.com";
	}
	
	@DataProvider
	public Object[][] getUserRegData() {
	 return new Object[] [] {
		 {"pooja", "agrawal", "5678234345", "Automation@123", "yes"},
		 {"Shubham", "gupta", "3458234345", "Shubham@123", "no"},
		 {"Mitaj", "Kumar", "4678234345", "Mitaj@123", "yes"}
	 };	
	}
	@DataProvider
	public Object[] [] getUserRegSheetData(){
		return ExcelUtils.getTestData(AppConstants.REGISTER_SHEET_NAME);
	}
	
	@Test(dataProvider = "getUserRegSheetData")
	public void userRegisterTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		registerPage.registerUser(firstName, lastName, getRandomEmailId(), telephone, password, subscribe );
	}

}
