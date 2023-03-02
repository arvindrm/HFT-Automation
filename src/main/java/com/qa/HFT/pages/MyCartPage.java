package com.qa.HFT.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.HFT.utils.ElementUtil;
import com.qa.HFT.utils.TimeUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class MyCartPage {
	// Login
	// search an item (63531)
	// add an item to the cart
	// overlay pop up
	// go to check out page
	// enter details on check out page
	// Shipping address
	// Delivery method
	// cc info
	// place an order
	// Order Confirmation page
	// Assert

	// Guest user
	// search an item (63531)
	// add an item to the cart
	// go to check out page
	// guest user
	// enter details on check out page
	// Shipping address
	// Delivery method
	// cc info
	// place an order
	// Order Confirmation page
	// Assert

	private WebDriver driver;
	private ElementUtil eleUtil;

	public String searchItem = "63531";

	private By popup = By.xpath("//div[contains(@class,'dy-lb-close')]");
	private By search = By.id("search-input");
	private By accHeader = By.xpath("//h2[contains(@class,'customer')]");
	private By searchIcon = By.name("Submit search");
	private By addCartBtn = By.xpath("//div[@data-testid='quantityWrap']//following-sibling::button");
	private By itemTextSearchPage = By.xpath("//h1");
	private By itemTextOverLay = By.xpath("//div[@class='overlay__info--TbBupi']/p");
	private By addToCartOverLay = By.xpath("//a[text()='View Cart & Checkout']");
	private By viewCartCheckout =By.xpath("//span[text()='Start Secure Checkout']");
	
	private By myCartHeader = By.xpath("//div[contains(@class,'cart__main')]/h1");
	private By myCartSubmit = By.xpath ("//div[contains(@class,'checkout-totals')]/a");
	private By myCartProductTitle = By.xpath("//div[contains(@class,'cart-items')]/h3");
	private By myCartProductDelete =By.xpath("//div[contains(@class,'cart-items')]/ul/li[2]/button");
	
	// 2. page constructor:
	public MyCartPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public boolean isSearchExist() {
		return eleUtil.waitForElementVisible(searchIcon, TimeUtil.DEFAULT_TIME_OUT).isDisplayed();
	}

	// search an item (63531)
	public ProductInfoPage performSearch(String productName) {
		System.out.println("product search for : " + productName);
		if (isSearchExist()) {
			eleUtil.doSendKeys(search, productName);
			eleUtil.doClick(searchIcon);
			return new ProductInfoPage(driver);
		}
		return null;
	}
	
	public String getMyCartPageHeader() {
		return eleUtil.waitForElementPresence(myCartHeader,TimeUtil.MEDIUM_TIME_OUT).getText();
	}
	
	
	
	public String getMyCartProductTitle() {
		return eleUtil.waitForElementPresence(myCartProductTitle,TimeUtil.MEDIUM_TIME_OUT).getText();
	}
	
	public void getMyCartProductDelete() {
		return;
	}
	

	// add an item to the cart
	public void addToCart() {
		try {
			//String getElementTextSearchPage = eleUtil.doGetElementText(itemTextSearchPage);
			eleUtil.doClick(addCartBtn);
			Thread.sleep(15000);
			//String getElementTextOverlaypage = eleUtil.doGetElementText(itemTextOverLay);
			//eleUtil.stringAsserts(getElementTextSearchPage, getElementTextOverlaypage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewCartCheckOutBtn() {
		eleUtil.doClick(addToCartOverLay);
	}

	// in the test class call login functionality
	// and call below method will see how it goes
	
	public void hello()
	{
		System.out.println("this is hello method");
	}

	public void addItemToCartFlow() {
		System.out.println("till here");
		performSearch("63531");
		addToCart();
	}
	
	public CheckOutPage SKUperformSearch(String productName) throws InterruptedException {
		System.out.println("I m in MyCartPage " + productName);
		if (isSearchExist()) {
			
			Thread.sleep(3000);
			eleUtil.clickElementWhenReady(viewCartCheckout, TimeUtil.DEFAULT_TIME_OUT);
			return new CheckOutPage(driver);
			
		}
		return null;
		//String className = this.getClass().getName();
	}

}