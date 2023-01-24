package com.qa.HFT.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.HFT.base.BaseTest;

public class ProductInfoPageTest extends BaseTest{
	
	
	@BeforeClass
	public void prodInfoSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] getProductTestData() {
		return new Object[][] {
			{"63531", "20V Cordless 1/2 in. Drill/Driver Kit", "BAUER"},
			{"58632", "5 in. Fiber Disc Backing Pad","HERCULES"},
			{"59168", "7 in. Diagonal Cutter"},
			
		};
	}
	
	
	@Test(dataProvider = "getProductTestData")
	public void productHeaderTest(String searchkey, String mainProductName) {
		resultsPage = accPage.performSearch(searchkey);
		prodInfoPage = resultsPage.selectProduct(mainProductName);
		String actHeader = prodInfoPage.getProductHeader();
		Assert.assertEquals(actHeader, mainProductName);
	}
	
	
	@DataProvider
	public Object[][] getProductImagesTestData() {
		return new Object[][] {
			{"63531", "20V Cordless 1/2 in. Drill/Driver Kit", "BAUER"},
			{"58632", "5 in. Fiber Disc Backing Pad","HERCULES"},
			{"59168", "7 in. Diagonal Cutter"},
			
		};
	}
	
	@Test(dataProvider = "getProductImagesTestData")
	public void productImagesTest(String searchkey, String mainProductName, int imageCount) {
		resultsPage = accPage.performSearch(searchkey);
		prodInfoPage = resultsPage.selectProduct(mainProductName);
		//int actImagesCount = prodInfoPage.getProductImagesCount();
		//Assert.assertEquals(actImagesCount, imageCount);
		
	}
	
	
	
	@Test
	public void productMetaDataTest() {
		resultsPage = accPage.performSearch("63531");
		prodInfoPage = resultsPage.selectProduct("20V Cordless 1/2 in. Drill/Driver Kit");
		Map<String, String> actProdInfoMap = prodInfoPage.getProductInformation();
		
		softAssert.assertEquals(actProdInfoMap.get("Brand"), "Apple");
		softAssert.assertEquals(actProdInfoMap.get("Availability"), "In Stock");
		softAssert.assertEquals(actProdInfoMap.get("actualprice"), "$2,000.00");
		softAssert.assertEquals(actProdInfoMap.get("Reward Points"), "800");
		softAssert.assertAll();

	}
	
	

}
