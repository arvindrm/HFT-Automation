package com.qa.HFT.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.HFT.base.BaseTest;
import com.qa.HFT.utils.AppConstants;
import com.qa.HFT.utils.AppErrors;

import io.qameta.allure.Description;

public class ProductInfoPageTest extends BaseTest{
	
	
	@BeforeClass
	public void prodInfoSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@DataProvider
	public Object[][] getProductTestData() {
		return new Object[][] {
			{"63531", "20V Cordless 1/2 in. Drill/Driver Kit", "BAUER"},
	
			
		};
	}
	
	
	//@Test(dataProvider = "getProductTestData")
	@Description("Verifying Product Title for SKU 63531")
	@Test
	public void productHeaderTest( ) throws InterruptedException {
		String searchkey ="63531";
		prodInfoPage = accPage.SKUperformSearch(searchkey);
		//prodInfoPage = resultsPage.selectProduct(searchkey);
		//Thread.sleep(10000);
		
		String prodTitle = prodInfoPage.getProductHeader();
		
		System.out.println(prodTitle);
		Assert.assertEquals(prodTitle, "20V Cordless 1/2 in. Drill/Driver Kit");
	
	}
	
	@Description("Verifying Product Brand Name for SKU 63531")
	@Test
	public void productBrandNameTest() {
		String searchkey ="63531";
		prodInfoPage = accPage.SKUperformSearch(searchkey);
		String prodBrandName = prodInfoPage.getProductBrand();
		System.out.println("Product Brand Name is  : " + prodBrandName);
		Assert.assertEquals(prodBrandName, "BAUER");
	}
	
	
	/*
	 * @DataProvider public Object[][] getProductImagesTestData() { return new
	 * Object[][] { {"63531", "20V Cordless 1/2 in. Drill/Driver Kit", "BAUER"},
	 * {"58632", "5 in. Fiber Disc Backing Pad","HERCULES"}, {"59168",
	 * "7 in. Diagonal Cutter"},
	 * 
	 * }; }
	 * 
	 * @Test(dataProvider = "getProductImagesTestData") public void
	 * productImagesTest(String searchkey, String mainProductName, int imageCount) {
	 * resultsPage = accPage.performSearch(searchkey); prodInfoPage =
	 * resultsPage.selectProduct(mainProductName); //int actImagesCount =
	 * prodInfoPage.getProductImagesCount(); //Assert.assertEquals(actImagesCount,
	 * imageCount);
	 * 
	 * }
	 */
	
	
	
	/*
	 * @Test public void productMetaDataTest() { resultsPage =
	 * accPage.performSearch("63531"); prodInfoPage =
	 * resultsPage.selectProduct("20V Cordless 1/2 in. Drill/Driver Kit");
	 * Map<String, String> actProdInfoMap = prodInfoPage.getProductInformation();
	 * 
	 * softAssert.assertEquals(actProdInfoMap.get("Brand"), "Apple");
	 * softAssert.assertEquals(actProdInfoMap.get("Availability"), "In Stock");
	 * softAssert.assertEquals(actProdInfoMap.get("actualprice"), "$2,000.00");
	 * softAssert.assertEquals(actProdInfoMap.get("Reward Points"), "800");
	 * softAssert.assertAll();
	 * 
	 * }
	 */
	
	

}
