package com.qa.HFT.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.HFT.base.BaseTest;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class CheckoutPageTest extends BaseTest{
	
	@BeforeClass
	public void accSetup() {
		myCartPage = loginPage.doLoginCart(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider public Object[][] getProductAddToCartTestData(){
		return new Object[][] {
			{"64113","Aravind","Mamilapally","599 calle de las ovejas", "3132128989"}
		};
	}
	
	@Test(dataProvider = "getProductAddToCartTestData")
	@Description("Verifying Product is Add to cart")
	@Severity(SeverityLevel.CRITICAL)
	
	public void productAddToCartTest(String searchKey,String firstName, String lastName, String Address, String telephone) throws InterruptedException {
		//myCartPage.hello();
		//myCartPage.addItemToCartFlow();
		myCartPage.performSearch(searchKey);
		Thread.sleep(10000);
		myCartPage.addToCart();
		myCartPage.viewCartCheckOutBtn();
		checkOutPage =myCartPage.secureClick();
		Thread.sleep(3000);
		checkOutPage.doCreateAddressClick().click();
		//checkOutPage=myCartPage.SKUperformSearch(searchKey);
		//myCartPage.addToCart();
		//myCartPage.viewCartCheckOutBtn();
		//checkOutPage.
		checkOutPage.enterShippingAddress(firstName, lastName, Address, telephone);
		checkOutPage.doDeliveryMethodClick().click();
		Thread.sleep(10000);
		checkOutPage.doPaymentClick().click();
		Thread.sleep(3000);
		checkOutPage.switchtoframe();
		Thread.sleep(3000);
		
		System.out.println("afterswitchtoframe");
		checkOutPage.paymentconfirmBtn();
		System.out.println("afterpaymentconfirmBtn");
		Thread.sleep(5000);
		String reviewtxt = checkOutPage.doRewviewClick().getText();
		System.out.println(reviewtxt);
		checkOutPage.doRewviewClick().click();
		Thread.sleep(6000);
		
	}
	
	
	
	
}
