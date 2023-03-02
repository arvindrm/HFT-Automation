package com.qa.HFT.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.checkerframework.checker.units.qual.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.HFT.utils.ElementUtil;
import com.qa.HFT.utils.TimeUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// private By productHeader =
	// By.xpath("//h1[contains(@class,'product__title')]");
	private By productHeader = By.xpath("//div[contains(@class,'product__info')]/h1");
	private By productBrand = By.xpath("//div[contains(@class,'product__info')]/h4");
	private By prodBrandlink = By.xpath("//div[contains(@class,'product__info')]/p/span");
	private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li");
	private By productpriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=2]/li");
	private By productAddToCart = By.xpath("//div[contains(@class,'product__purchase')]/button");
	private By overlayAddToCart = By.xpath("//div[contains(@class,'overlay__actions')]/a");
	private By searchIcon = By.name("Submit search");
	private By search = By.id("search-input");
	
	private Map<String, String> productMap;

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public boolean isSearchExist() {
		return eleUtil.waitForElementVisible(searchIcon, TimeUtil.DEFAULT_TIME_OUT).isDisplayed();
	}

	public String getProductHeader() {
		return eleUtil.waitForElementPresence(productHeader, TimeUtil.LARGE_TIME_OUT).getText();
	}

	public String getProductBrand() {
		return eleUtil.waitForElementPresence(productBrand, TimeUtil.LARGE_TIME_OUT).getText();
	}

	public boolean prodBrandlinkExist() {
		return eleUtil.waitForElementVisible(prodBrandlink, TimeUtil.DEFAULT_TIME_OUT).isDisplayed();

	}

	public boolean isAddToCartExist() {
		return eleUtil.waitForElementVisible(productAddToCart, TimeUtil.MEDIUM_TIME_OUT).isDisplayed();
	}

	public Map<String, String> getProductInformation() {
		productMap = new HashMap<String, String>();
//		productMap = new TreeMap<String, String>();
//		productMap = new LinkedHashMap<String, String>();

		getProductMetaData();
		getProductPriceData();
		System.out.println(productMap);
		return productMap;
	}

//
	private void getProductMetaData() {
		List<WebElement> metaDataList = eleUtil.getElements(productMetaData);
		System.out.println("product meta data count--->" + metaDataList.size());

		for (WebElement e : metaDataList) {
			String meta = e.getText();
			String metaData[] = meta.split(":");
			String metaKey = metaData[0].trim();
			String metaValue = metaData[1].trim();
			productMap.put(metaKey, metaValue);
		}
	}

	// $2,000.00 //0
	// Ex Tax: $2,000.00 //1
	private void getProductPriceData() {
		List<WebElement> metaPriceList = eleUtil.getElements(productpriceData);
		System.out.println("product price count--->" + metaPriceList.size());
		String price = metaPriceList.get(0).getText().trim();
		String ExTaxPrice = metaPriceList.get(1).getText().trim();

		productMap.put("actualprice", price);
		productMap.put("actualtaxprice", ExTaxPrice);

	}
	
	public MyCartPage SKUperformSearch(String productName) throws InterruptedException {
		System.out.println("product search for : " + productName);
		if (isSearchExist()) {
			eleUtil.doSendKeys(search, productName);
			// eleUtil.doClick(searchIcon);
			Thread.sleep(3000);
			eleUtil.clickElementWhenReady(searchIcon, TimeUtil.DEFAULT_TIME_OUT);
			return new MyCartPage(driver);
		}
		return null;
	}

	public MyCartPage performSKUSearch(String productName) {
		System.out.println("I am here");
		if (isAddToCartExist()) {
			eleUtil.doClick(productAddToCart);
			System.out.println("Clicked on Addtocart");
			eleUtil.clickElementWhenReady(overlayAddToCart, TimeUtil.MEDIUM_TIME_OUT);
			System.out.println("Clicked on overlayAddToCart");
			return new MyCartPage(driver);
		}
		return null;
	}

}
