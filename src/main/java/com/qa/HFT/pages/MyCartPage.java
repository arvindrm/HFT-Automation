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
	//Login 
	//search an item (63531)
	//add an item to the cart
	//go to check out page
	//enter details on check out page
		//Shipping address
		//Delivery method
		//cc info
		//place an order
	//Order Confirmation page
		//Assert 
	
	//Guest user
		//search an item (63531)
		//add an item to the cart
		//go to check out page
		//guest user
		//enter details on check out page
			//Shipping address
			//Delivery method
			//cc info
			//place an order
		//Order Confirmation page
			//Assert 
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	private By popup = By.xpath("//div[contains(@class,'dy-lb-close')]");
	private By search = By.id("search-input");
	private By accHeader = By.xpath("//h2[contains(@class,'customer')]");
	private By searchIcon = By.name("Submit search");
	private By addCartBtn=By.xpath("//*[@id=\"product-wrap\"]/div[1]/div[3]/div[7]/button");
	private By viewCartChkOBtn=By.xpath("//*[@id='product-wrap']/div[1]/div[3]/div[7]/div[2]/div[2]/div/div[2]/div[2]/a");
	
	
	// 2. page constructor:
		public MyCartPage(WebDriver driver) {
			this.driver = driver;
			eleUtil = new ElementUtil(driver);
		}
	
	
		public boolean isSearchExist() {
			return eleUtil.waitForElementVisible(searchIcon, TimeUtil.DEFAULT_TIME_OUT).isDisplayed();
		}

		//search an item (63531)
		public ResultsPage performSearch(String productName) 
		{
			  System.out.println("product search for : " + productName);
			  if(isSearchExist()) { 
				  eleUtil.doSendKeys(search, productName);
			  eleUtil.doClick(searchIcon); 
			  return new ResultsPage(driver); 
			  } 
			  return null; 
			  }
		
		
		//add an item to the cart
		public void addToCart()
		{			
			eleUtil.doClick(addCartBtn);			
		}
		
		public void veawCartCheckOutBtn()
		{
			eleUtil.doClick(viewCartChkOBtn);
		}
		
		
		
		
}
