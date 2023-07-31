package com.qa.opencart.pages;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtils;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtils eleutil;

	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By quantity = By.name("quantity");
	private By addToCartBtn = By.id("button-cart");
	private By prodmetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By prodPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");

	private Map<String, String> productMap;

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtils(driver);
	}

	public String getProductHeaderValue() {
		return eleutil.doElementGetText(productHeader);
	}

	public int getProductImagesCount() {
		int productImageCount = eleutil.waitForElementsVisible(productImages, AppConstants.SHORT_TIME_OUT).size();
		System.out.println("total product images for: " + getProductHeaderValue() + "===> " + productImageCount);
		return productImageCount;
	}

	private void getProductMetaData() {
		List<WebElement> metaList = eleutil.waitForElementsVisible(prodmetaData, AppConstants.SHORT_TIME_OUT);
		// Map<String, String> metaMap = new HashMap<String, String>();
		for (WebElement e : metaList) {
			String metaText = e.getText();
			String key = metaText.split(":")[0].trim();
			String value = metaText.split(":")[1].trim();
			productMap.put(key, value);
		}

	}

	private void getProductPriceData() {
		List<WebElement> priceList = eleutil.waitForElementsVisible(prodPriceData, AppConstants.SHORT_TIME_OUT);
		// Map<String, String> priceMap = new HashMap<String, String>();

		String actPrice = priceList.get(0).getText().trim();
		String exTax = priceList.get(1).getText().split(":")[0].trim();
		String exTaxValue = priceList.get(1).getText().split(":")[1].trim();

		productMap.put("price", actPrice);
		productMap.put(exTax, exTaxValue);
	}

	public Map<String, String> getProductData() {
		// productMap = new HashMap<String, String>();
		// productMap = new LinkedHashMap<String, String>();
		productMap = new TreeMap<String, String>();
		productMap.put("productheader", getProductHeaderValue());
		productMap.put("productimages", String.valueOf(getProductImagesCount()));
		getProductMetaData();
		getProductPriceData();
		return productMap;
	}

}
