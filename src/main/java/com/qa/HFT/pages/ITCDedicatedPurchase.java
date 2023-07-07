package com.qa.HFT.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.HFT.utils.ElementUtil;

public class ITCDedicatedPurchase {
	
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By Itc_nav = By.xpath("//nav[contains(@class,'nav__nav--eAB0bn')]/ul/li[2]/ul/li[6]/a");
	private By Joinnow_btn = By.xpath("//div[contains(@class,'join-inside')]/div[2]/button");
	
	//login-panel
	private By signin_lbl = By.xpath("//div[contains(@class,'login')]/h2");
	private By Itc_signin_btn = By.xpath("//div[contains(@class,'login__button')]/button");
	private By Itc_getstarted_btn = By.xpath("//div[contains(@class,'guestCheckout')]/button");
	
	//login-panel-create user
	private By Itc_BackSignIn_lbl = By.xpath("//div[contains(@class,'login-panel__reset')]/strong");
	private By Itc_Firstname_txt = By.xpath("//*[@id=\"register-firstname\"]");
	private By Itc_Lastname_txt = By.xpath("//*[@id=\"register-lastname\"]");
	private By Itc_email_txt = By.xpath("//*[@id=\"register-email\"]");
	private By Itc_password_txt = By.xpath("//*[@id=\"register-password\"]");
	private By Itc_pwdconfirmation_txt = By.xpath("//*[@id=\"register-confirmation\"]");
	private By Itc_telephone_txt = By.xpath("//*[@id=\"register-telephone\"]");
	private By Itc_CreateAccount_btn = By.xpath("//div[contains(@class,'myaccount-register')]/div/form/button");
	
	
	public ITCDedicatedPurchase(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

}
