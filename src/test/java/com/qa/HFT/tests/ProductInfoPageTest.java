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
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(" Design PDP page for HARBORFREIGHT TOOLS application")
@Story(" Test PDP page functionality for HARBORFREIGHT TOOLS PDP page")
public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void prodInfoSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] getProductTitleTestData() {
		return new Object[][] { 
			{ "63531", "20V Cordless 1/2 in. Drill/Driver Kit" },
			{ "58919", "7 in. Surface Grinding Dust Shroud" }

		};
	}

	@Test(dataProvider = "getProductTitleTestData")
	@Description("Verifying Product Title for SKU 63531")
	@Severity(SeverityLevel.CRITICAL)
	public void productHeaderTest(String searchkey, String prodTitle) throws InterruptedException {
		// String searchkey ="63531";
		prodInfoPage = accPage.SKUperformSearch(searchkey);
		// prodInfoPage = resultsPage.selectProduct(searchkey);
		// Thread.sleep(10000);
		System.out.println("productheadertest");
		String actProdTitle = prodInfoPage.getProductHeader();
		System.out.println("SKU id : " + searchkey + " Title is  : " + actProdTitle);
		Assert.assertEquals(actProdTitle, prodTitle);

	}

	@DataProvider
	public Object[][] getProductBrandTestData() {
		return new Object[][] { { "59135", "PREDATOR" }

		};
	}

	@Test(dataProvider = "getProductBrandTestData")
	@Description("Verifying Product Brand Name for SKUs")
	@Severity(SeverityLevel.CRITICAL)

	public void productBrandNameTest(String searchkey, String prodBrand) throws InterruptedException {
		System.out.println("Product Brand Name is  : ");
		prodInfoPage = accPage.SKUperformSearch(searchkey);
		String actProdBrandName = prodInfoPage.getProductBrand();
		System.out.println("Product Brand Name is  : " + actProdBrandName);
		Assert.assertEquals(actProdBrandName, prodBrand);
	}

	
	@DataProvider
	public Object[][] getProductAddToCartTestData() {
		return new Object[][] { { "56381", "ICON" }

		};
	}

	@Test(dataProvider = "getProductAddToCartTestData")
	@Description("Verifying Product is Add to cart")
	@Severity(SeverityLevel.CRITICAL)

	public void productAddToCartTest(String searchkey, String prodBrand) throws InterruptedException {
		System.out.println("ProductinfoPageTest Brand Name is - productAddToCartTest : ");
		prodInfoPage = accPage.SKUperformSearch(searchkey);
		myCartPage = prodInfoPage.performSKUSearch(prodBrand);
		String myCartHeader = myCartPage.getMyCartPageHeader();
		System.out.println("My Cart Text  : " + myCartHeader);
		Assert.assertTrue(myCartHeader.contains("My Cart"));
	}

}
