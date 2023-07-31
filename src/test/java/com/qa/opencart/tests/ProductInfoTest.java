package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;

@Epic("EPIC-102: Design of the product info page for opencart app")
@Story("User Story-202: implement product info page features for open cart app")
public class ProductInfoTest extends BaseTest {
	@BeforeClass
	public void productInfoSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object [][] productTestData() {
		return new Object [][] {
			{"macbook","MacBook Pro",},
			{"macbook","MacBook Air"},
			{"imac","iMac"},
			{"samsung", "Samsung SyncMaster 941W"},
			{"samsung", "Samsung Galaxy Tab 10.1"}
		};
	}

	@Test(dataProvider ="productTestData")
	public void productHeaderTest(String searchKey, String ProductName) {
		searchResPage = accPage.doSearch(searchKey);
		productInfoPage = searchResPage.selectProduct(ProductName);
		String actProdHeader = productInfoPage.getProductHeaderValue();
		Assert.assertEquals(actProdHeader, ProductName);
	}
	
	@DataProvider
	public Object [][] imgCountTestData() {
		return new Object [][] {
			{"macbook","MacBook Pro",4},
			{"macbook","MacBook Air",4},
			{"imac","iMac",3},
			{"samsung", "Samsung SyncMaster 941W",1},
			{"samsung", "Samsung Galaxy Tab 10.1",7}
		};
	}
	@Test
	public void productImagesCountTest(String searchKey, String ProductName, int imgCount) {
		searchResPage = accPage.doSearch(searchKey);
		productInfoPage = searchResPage.selectProduct(ProductName);
		int actProdImgCount = productInfoPage.getProductImagesCount();;
		Assert.assertEquals(actProdImgCount, imgCount);
	}
	
	@Test
	public void productInfoTest() {
		searchResPage = accPage.doSearch("macbook");
		productInfoPage = searchResPage.selectProduct("MacBook Pro");	
		Map<String, String> productActualData= productInfoPage.getProductData();
		System.out.println(productActualData);
		softAssert.assertEquals(productActualData.get("Brand"), "Apple");
		softAssert.assertEquals(productActualData.get("Ex Tax"), "$2,000.00");
		softAssert.assertEquals(productActualData.get("productheader"), "MacBook Pro");
		softAssert.assertEquals(productActualData.get("Reward Points"), "800");
		softAssert.assertEquals(productActualData.get("Product Code"), "Product 18");
		softAssert.assertAll();
		
	}
}
