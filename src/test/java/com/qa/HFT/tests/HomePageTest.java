package com.qa.HFT.tests;


import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.HFT.base.BaseTest;
import com.qa.HFT.pages.HomePage;
import com.qa.HFT.utils.AppConstants;
import com.qa.HFT.utils.ExcelUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class HomePageTest extends  BaseTest{
	
	@BeforeClass
	public void HomePageSetup() {
		homePage = loginPage.navigateToHomePage();
		System.out.println("HomePAge");
	}
	
	@Description("couponlink test")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void couponlinkExistTest() {
		String cpntxt = homePage.getcouponslinktxt();
		System.out.println("Coupon link text is : " + cpntxt);
		Assert.assertEquals(cpntxt,"Coupons");
	}
	
	@Description("NewToolslink test")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void newtoolslinkExistTest() {
		String newtoolstxt = homePage.newtoolslinktxt();
		System.out.println("New Tools link text is : " + newtoolstxt);
		Assert.assertEquals(newtoolstxt,"New Tools");
	}
	
	@Description("Dealslink test")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void dealslinkExistTest() {
		String dealstxt = homePage.dealslinktxt();
		System.out.println("Deals link text is : " + dealstxt);
		Assert.assertEquals(dealstxt,"Deals");
	}
	
	@Description("Shop All Brands link test")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void shopbylinkExistTest() {
		String shopbytxt = homePage.shopbylinktxt();
		System.out.println("Shop All Brands link text is : " + shopbytxt);
		Assert.assertEquals(shopbytxt,"Shop All Brands");
	}
	
	@Description("Member-only deals link test")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void membersonlylinkExistTest() {
		String membersonlytxt = homePage.membersonlylinktxt();
		System.out.println("members-only Deals link text is : " + membersonlytxt);
		Assert.assertEquals(membersonlytxt,"Member-Only Deals");
	}
	
	@Description("Join Inside Track Club link test")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void JoinITClinkExistTest() {
		String JoinITCtxt = homePage.JoinITClinktxt();
		System.out.println("JoinInside Track Club link text is : " + JoinITCtxt);
		Assert.assertEquals(JoinITCtxt,"Join Inside Track Club");
	}
	
	@Description("Credit Card link test")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void creditcardlinkExistTest() {
		String creditcardtxt = homePage.creditcardlinktxt();
		System.out.println("creditcard link text is : " + creditcardtxt);
		Assert.assertEquals(creditcardtxt,"Credit Card");
	}
	
	@Description("Join Our Team link test")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void joinourteamlinkExistTest() {
		String joinourteamtxt = homePage.joinourteamlinktxt();
		System.out.println("Shop All Brands link text is : " + joinourteamtxt);
		Assert.assertEquals(joinourteamtxt,"Join Our Team");
	}
	
	@Description("Gift cards link Test in Helpful section")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void giftcardslinktxtExistTest() {
		String giftcardslinktxt = homePage.giftcardslinktxt();
		System.out.println("Digital Gift Card link text is : " + giftcardslinktxt);
		Assert.assertEquals(giftcardslinktxt,"Gift Cards");
	}

}
