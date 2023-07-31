package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtils;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtils eleutil;

	private By logoutLink = By.linkText("Logout");
	private By accHeaders = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtils(driver);
	}

	public String getAccountPageTitle() {
		return eleutil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
	}

	public boolean isLogoutLinkExist() {
		return eleutil.waitForElementPresence(logoutLink, AppConstants.MEDIUM_TIME_OUT).isDisplayed();
	}

	public List<String> getAccountPageHeader() {
	List<WebElement> HeaderList	= eleutil.waitForElementsVisible(accHeaders, AppConstants.MEDIUM_TIME_OUT);
		List<String> HeaderValueList = new ArrayList<String>();
		for(WebElement e: HeaderList) {
			String text = e.getText();
			HeaderValueList.add(text);
		}
		System.out.println("Actual Account Page Header List==> " + HeaderValueList);
		return HeaderValueList;
	}

	public int getAccountPageHeadersCount() {
     return eleutil.waitForElementsVisible(accHeaders, AppConstants.MEDIUM_TIME_OUT).size();
	}
	
	public SearchResultsPage doSearch(String searchKey) {
		WebElement searchField = eleutil.waitForElementPresence(search, AppConstants.MEDIUM_TIME_OUT);
		searchField.clear();
		searchField.sendKeys(searchKey);
		eleutil.doClick(searchIcon);
		return new SearchResultsPage(driver);
	}
	

}
