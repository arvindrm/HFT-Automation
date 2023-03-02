package com.qa.HFT.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.HFT.base.BaseTest;
import com.qa.HFT.pages.MyCartPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class MyCartPageTest extends BaseTest{
	
	@BeforeClass
	public void accSetup() {
		prodInfoPage = loginPage.doLoginProd(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider public Object[][] getProductAddToCartTestData(){
		return new Object[][] {
			{"64113"}
		};
	}
	
	@Test(dataProvider = "getProductAddToCartTestData")
	@Description("Verifying Product is Add to cart")
	@Severity(SeverityLevel.CRITICAL)
	
	public void productAddToCartTest(String searchKey) throws InterruptedException {
		//myCartPage.hello();
		//myCartPage.addItemToCartFlow();
		myCartPage=prodInfoPage.SKUperformSearch(searchKey);
		Thread.sleep(3000);
		myCartPage.addToCart();
		myCartPage.viewCartCheckOutBtn();
	}
	
	
}
