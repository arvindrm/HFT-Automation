package com.qa.HFT.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.HFT.factory.DriverFactory;
import com.qa.HFT.pages.AccountsPage;
import com.qa.HFT.pages.CheckOutPage;
import com.qa.HFT.pages.LoginPage;
import com.qa.HFT.pages.MyCartPage;
import com.qa.HFT.pages.ProductInfoPage;
import com.qa.HFT.pages.RegPage;
import com.qa.HFT.pages.ResultsPage;

public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected ResultsPage resultsPage;
	protected ProductInfoPage prodInfoPage;
	protected MyCartPage myCartPage;
	protected CheckOutPage checkOutPage;
	protected RegPage regPage;
	
	protected SoftAssert softAssert;
	
	protected Properties prop;
	
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
