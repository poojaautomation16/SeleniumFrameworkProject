package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {
	
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected SearchResultsPage searchResPage;
	protected ProductInfoPage productInfoPage;
	DriverFactory df;
	protected Properties prop;
	protected RegisterPage registerPage;
	
	protected SoftAssert softAssert;
	
	@BeforeTest
	public void setUP() {
		df = new DriverFactory();
		prop = df.initProp();
		driver =df.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
		registerPage = new RegisterPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
