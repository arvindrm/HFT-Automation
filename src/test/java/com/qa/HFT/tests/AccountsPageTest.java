package com.qa.HFT.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.HFT.base.BaseTest;
import com.qa.HFT.pages.ProductInfoPage;
import com.qa.HFT.utils.AppConstants;
import com.qa.HFT.utils.AppErrors;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accPageTitleTest() {
		String actTitle = accPage.getAccPageTitle();
		System.out.println("AccountPageTest --- Acc page title : " + actTitle);
		Assert.assertEquals(actTitle, AppConstants.ACCOUNTS_PAGE_TITLE);
	}

	@Test
	public void accPageURLTest() {
		String actURL = accPage.getAccPageURL();
		System.out.println("AccountPageTest --- Acc page url : " + actURL);
		Assert.assertTrue(actURL.contains(AppConstants.ACC_PAGE_FRACTION_URL), AppErrors.NO_URL_MATCHED);
	}

	@Test
	public void searchExistTest() {
		Assert.assertTrue(accPage.isSearchExist());
	}

	@Test
	public void logoutExistTest() {
		Assert.assertTrue(accPage.isLogoutExist());
	}
	
	@Test
	public void accPageHeaderTest() {
		String actHeader = accPage.getAccPageHeader();
		System.out.println("AccountPage Header : " + actHeader);
		Assert.assertTrue(actHeader.contains(AppConstants.ACC_PAGE_HEADER),AppErrors.NO_URL_MATCHED);
	}

	@Test
	public void accPageHeadersTest() {
		List<String> actHeadersList = accPage.getAccountsPageSectionsHeaders();
		Assert.assertEquals(actHeadersList, AppConstants.EXPECTED_ACC_HEADERS_LIST);
	}

	//@DataProvider
	/*
	 * public Object[][] getProductName() { return new Object[][] { {"63531"},
	 * //{"58632"}, //{"59168"}
	 * 
	 * }; }
	 */
	
	//TDD
	//@Test(dataProvider = "getProductName")
	//public void productSearchTest(String productName) 
	@Test
	public void productSearchTest()
	{
		String productName="Driver kit";
		resultsPage = accPage.performSearch(productName);
		//String actTitle = resultsPage.getSearchPageTitle(productName);
		//System.out.println("search page title : " + actTitle);
		//softAssert.assertEquals(actTitle, AppConstants.SEARCH_PAGE_TITLE+" "+productName);
		Assert.assertTrue(resultsPage.getSearchProductsCount()>0);
	}
	
	public void productPDPSearchTest()
	{
		String productName="63531";
		prodInfoPage = accPage.performSKUSearch(productName);
		//String actTitle = ProductInfoPage.getSearchPageTitle(productName);
		//System.out.println("search page title : " + actTitle);
		//softAssert.assertEquals(actTitle, AppConstants.SEARCH_PAGE_TITLE+" "+productName);
		
	}
	
	
	}
	
	//TDD

	
	
	
	
	
	

