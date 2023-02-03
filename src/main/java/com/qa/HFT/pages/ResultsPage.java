package com.qa.HFT.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.HFT.pages.ProductInfoPage;
import com.qa.HFT.utils.ElementUtil;
import com.qa.HFT.utils.TimeUtil;

public class ResultsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By searchProducts = By.xpath("//div[contains(@class,'grid__wrapper')]/ul/li");
	private By productHeader = By.xpath("//h1[contains(@class,'product__title')]");
	
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	

	public String getSearchPageTitle(String productName) {
		System.out.println("ResultsPage.java-getSearchPageTitle: " + productName);
		return eleUtil.waitForTitleContains(productName, TimeUtil.DEFAULT_TIME_OUT);
	}
	
	public int getSearchProductsCount() {
		int productCount = eleUtil.waitForElementsVisible(searchProducts, TimeUtil.SMALL_TIME_OUT).size();
		System.out.println("product search count : " + productCount);
		return productCount;
	}
	
	
	public ProductInfoPage selectProduct(String mainProductName) {
		System.out.println("main product name : " + mainProductName);
		eleUtil.doClick(By.linkText(mainProductName));
		return new ProductInfoPage(driver);
	}
	
	
	
	
	
}
