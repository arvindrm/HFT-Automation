package com.qa.HFT.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.HFT.utils.ElementUtil;

public class DigitalGiftCards {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	// 1. private By locators:
		private By HFTlabel = By.xpath("//div[contains(@class,'digital-gift-card')]/h4");
		private By DGClabel = By.xpath("//div[contains(@class,'digital-gift-card')]/h2");
	
	// 2. page constructor:
			public DigitalGiftCards(WebDriver driver) {
				this.driver = driver;
				eleUtil = new ElementUtil(driver);
			}

}
