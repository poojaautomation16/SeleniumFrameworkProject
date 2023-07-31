package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;

@Epic("EPIC-101: Design of the Accounts page for opencart app")
@Story("User Story-201: implement Accounts page features for open cart app")
public class AccountPageTest extends BaseTest {
	
	@BeforeClass
	public void accPageSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test
	public void accountPageTitleTest() {
		String accPageTitle = accPage.getAccountPageTitle();
		Assert.assertEquals(accPageTitle, AppConstants.ACCOUNTS_PAGE_TITLE);
	}
	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	@Test
	public void getAccountPageHeadersCountTest() {
     int actualPageHeaderCount = accPage.getAccountPageHeadersCount();
     System.out.println("Actual acc Page Header Count ==>" + actualPageHeaderCount);
     Assert.assertEquals(actualPageHeaderCount, AppConstants.ACCOUNTS_PAGE_HEADER_COUNT);
     
	}
	@Test
	public void getAccountPageHeaderTest() {
     List<String> actAccPageHeaderList = accPage.getAccountPageHeader();
     Assert.assertEquals(actAccPageHeaderList, AppConstants.EXPTD_ACCTS_PAGE_HEADERS_LIST);
	}
	
	@DataProvider
	public Object [][] getSearchKey() {
		return new Object [][] {
			{"macbook",3},
			{"imac",1},
			{"samsung",2},
			{"canon", 1}	
		};
	}
	@Test(dataProvider = "getSearchKey" )
	public void searchTest(String SearchKey, int ProductCount) {
		searchResPage =accPage.doSearch(SearchKey);
		int actResultsCount = searchResPage.getSearchResultsCount();
		Assert.assertEquals(actResultsCount, ProductCount);
	}

}
