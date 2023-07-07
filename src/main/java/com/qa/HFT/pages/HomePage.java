package com.qa.HFT.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.HFT.utils.AppConstants;
import com.qa.HFT.utils.ElementUtil;
import com.qa.HFT.utils.TimeUtil;

import io.qameta.allure.Step;

public class HomePage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By HomeITC_nav = By.xpath("//nav[contains(@class,'nav__nav--eAB0bn')]/ul/li[2]/ul/li[6]/a");
	private By couponslink = By.xpath("//ul[contains(@class,'nav__ul--3pxVaD')]/li[2]/ul/li[1]");
	private By newtoolslink = By.xpath("//ul[contains(@class,'nav__ul--3pxVaD')]/li[2]/ul/li[2]");
	private By Dealslink = By.xpath("//ul[contains(@class,'nav__ul--3pxVaD')]/li[2]/ul/li[3]");
	private By shopalllink = By.xpath("//ul[contains(@class,'nav__ul--3pxVaD')]/li[2]/ul/li[4]");
	private By membersonlylink = By.xpath("//ul[contains(@class,'nav__ul--3pxVaD')]/li[2]/ul/li[5]");
	private By JoinITClink = By.xpath("//ul[contains(@class,'nav__ul--3pxVaD')]/li[2]/ul/li[6]");
	private By creditcardlink = By.xpath("//ul[contains(@class,'nav__ul--3pxVaD')]/li[2]/ul/li[7]");
	private By joinourteamlink = By.xpath("//ul[contains(@class,'nav__ul--3pxVaD')]/li[2]/ul/li[8]");
	
	//Shop By Department
	
	private By shopbyAutomotivelink = By.xpath("//div[contains(@class,'grid-cat-item')]/a/div");
	private By shopbygeneratorslink = By.xpath("//div[contains(@class,'grid-cat-item')][2]/a/div");
	private By shopbyToolstoragelink = By.xpath("//div[contains(@class,'grid-cat-item')][3]/a/div");
	
	//footer -- helpful links
	private By giftcardslink = By.xpath("//footer/div[2]/div/div/ul/li[3]/a");
	
	// 2. page constructor:
		public HomePage(WebDriver driver) {
			this.driver = driver;
			eleUtil = new ElementUtil(driver);
		}

		public WebElement doHomePageITCClick() {
			return eleUtil.waitForElementPresence(HomeITC_nav, TimeUtil.LARGE_TIME_OUT);
		}
		
		public String getcouponslinktxt() {
			return eleUtil.waitForElementPresence(couponslink, TimeUtil.DEFAULT_TIME_OUT).getText();
		}
		
		public String newtoolslinktxt() {
			return eleUtil.waitForElementPresence(newtoolslink, TimeUtil.DEFAULT_TIME_OUT).getText();
		}
		public String dealslinktxt() {
			return eleUtil.waitForElementPresence(Dealslink, TimeUtil.DEFAULT_TIME_OUT).getText();
		}
		public String shopbylinktxt() {
			return eleUtil.waitForElementPresence(shopalllink, TimeUtil.DEFAULT_TIME_OUT).getText();
		}
		public String membersonlylinktxt() {
			return eleUtil.waitForElementPresence(membersonlylink, TimeUtil.DEFAULT_TIME_OUT).getText();
		}
		
		public String JoinITClinktxt() {
			return eleUtil.waitForElementPresence(JoinITClink, TimeUtil.DEFAULT_TIME_OUT).getText();
		}
		public String creditcardlinktxt() {
			return eleUtil.waitForElementPresence(creditcardlink, TimeUtil.DEFAULT_TIME_OUT).getText();
		}
		public String joinourteamlinktxt() {
			return eleUtil.waitForElementPresence(joinourteamlink, TimeUtil.DEFAULT_TIME_OUT).getText();
		}
		public String giftcardslinktxt() {
			return eleUtil.waitForElementPresence(giftcardslink, TimeUtil.DEFAULT_TIME_OUT).getText();
		}
		
		
		
		@Step("navigating to Homepage")
		public DigitalGiftCards navigateToDGC() {
			// eleUtil.waitForElementVisible(popup,TimeUtil.DEFAULT_TIME_OUT).click();
			eleUtil.doClick(giftcardslink);
			return new DigitalGiftCards(driver);
		}
		
}	
