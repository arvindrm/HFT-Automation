package com.qa.HFT.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.HFT.utils.AppConstants;
import com.qa.HFT.utils.ElementUtil;
import com.qa.HFT.utils.TimeUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By search = By.id("search-input");
	private By accHeader = By.xpath("//h2[contains(@class,'customer')]");
	private By searchIcon = By.name("Submit search");
	private By logoutLink = By.xpath("//span[contains(@class,'nav-list')]");
	private By accSecHeaders = By.cssSelector("div#content h2");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getAccPageTitle() {
		return eleUtil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE, TimeUtil.DEFAULT_TIME_OUT);
	}
	
	public String getAccPageURL() {
		return eleUtil.waitForUrlContains(AppConstants.ACC_PAGE_FRACTION_URL, TimeUtil.DEFAULT_TIME_OUT);
	}
	public String getAccPageHeader() {
		return eleUtil.waitForElementPresence(accHeader,TimeUtil.DEFAULT_TIME_OUT).getText();
	}
	
	public boolean isSearchExist() {
		return eleUtil.waitForElementVisible(search, TimeUtil.DEFAULT_TIME_OUT).isDisplayed();
	}
	
	
	public boolean isLogoutExist() {
		return eleUtil.waitForElementVisible(logoutLink, TimeUtil.DEFAULT_TIME_OUT).isDisplayed();
	}
	
	public List<String> getAccountsPageSectionsHeaders() {
		List<WebElement> secHeadersList = eleUtil.waitForElementsVisible(accSecHeaders, TimeUtil.DEFAULT_TIME_OUT);
		List<String> secHeadersValList = new ArrayList<String>();
		for(WebElement e : secHeadersList) {
			String text = e.getText();
			secHeadersValList.add(text);
		}
		return secHeadersValList;
	}

	
	  public ResultsPage performSearch(String productName) {
	  System.out.println("product search for : " + productName);
	  if(isSearchExist()) { 
		  eleUtil.doSendKeys(search, productName);
	  eleUtil.doClick(searchIcon); 
	  return new ResultsPage(driver); 
	  } 
	  return null; 
	  }
	 
	
	

}
