package com.qa.HFT.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.HFT.utils.AppConstants;
import com.qa.HFT.utils.ElementUtil;
import com.qa.HFT.utils.TimeUtil;

public class CheckOutPage {

	// Login
	// search an item (63531)
	// add an item to the cart
	// overlay pop up
	// go to check out page
	// enter details on check out page
	// Shipping address
	// Delivery method
	// cc info
	// place an order
	// Order Confirmation page
	// Assert

	// Guest user
	// search an item (63531)
	// add an item to the cart
	// go to check out page
	// guest user
	// enter details on check out page
	// Shipping address
	// Delivery method
	// cc info
	// place an order
	// Order Confirmation page
	// Assert

	private WebDriver driver;
	private ElementUtil eleUtil;

	// Shipping Section
	// addToCartOverLay=By.xpath("//*[@id='product-wrap']/div[1]/div[3]/div[7]/div[2]/div[2]/div/div[2]/div[2]/a");
	private By shippingLabel = By.xpath("//*[@id=\"step-title-1\"]/h2");
	private By shippingStepNo = By.xpath("//*[@id=\"step-title-1\"]/h2/span");
	private By shippingsavedAddress = By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[1]/form/div/div[2]/label");
	private By shippingFirstName = By.id("address-firstname");
	private By shippingLastName = By.id("address-lastname");
	private By shippingAddress = By.id("address-street1");
	private By shippingZipcode = By.id("address-postcode");
	private By shippingPhone = By.id("address-telephone");
	private By shippingCity = By.id("address-city");
	private By shippingState = By.id("address-region");
	private By shippingSaveButton = By.xpath("//button[text()='Save & Continue']");
	private By shippingAddressConfirmation = By.xpath("//p/strong");
	// To select a saved address
	private By shippingAddressSaved = By.xpath("//form/div/div[1]/label");
	private By shippingAddressEdit = By.id("//*[@id=\"step-title-1\"]/span");
	private By shippingAddressShowAll = By.xpath("//span[text()='Show All']");
	private By shippingAddressCreateNew = By.xpath("//strong[text()='+ Create New Address']");
	

	// Delivery Method Section
	private By deliveryMethodLabel =  By.xpath("//*[@id=\"step-title-2\"]/h2");
	private By deliveryMethodStepNo = By.xpath("//*[@id=\"step-title-2\"]/h2/span");
	private By deliveryAddressEdit = By.id("//*[@id=\"step-title-2\"]/span");
	private By deliveryMethodFlate = By.xpath("//form/div/label");
	private By deliveryMethod = By.xpath("//button[text()='Save & Continue']");
	private By deliverySaveButton = By.xpath("//form//button");

	// Payment Section
	private By PaymentGiftCardlabel = By.xpath("//div[contains(@class,'gift-card')]/span");
	//private By PaymentGiftCardNumber = By.xpath("//*[@name="card"]");
	private By PaymentGiftCardPin = By.xpath("//*[@id=\"giftCode\"]");
	private By PaymentGiftCardAddBtn = By.xpath("//button[text()='Add']");
	
	private By paymentMethodLabel =  By.xpath("//*[@id=\"step-title-3\"]/h2");
	private By paymentMethodStepNo = By.xpath("//*[@id=\"step-title-3\"]/h2/span");
	private By paymentEdit = By.id("//*[@id=\"step-title-3\"]/span");
	private By paymentCardName=By.xpath("//input[@id='cName']");
	private By paymentCardNumber=By.xpath("//input[@id='cNumber']");
	private By PaymentSecurityCode=By.xpath("//input[@id='secCode']");
	private By PaymentExpDate = By.xpath("//input[@id='exDate']");
	private By paymentSaveButton = By.xpath("//button[text()='Save & Continue']");
	private By paymentCCVerify = By.xpath("//div[contains(@class,'cardReminder')]");
	
	//save payment cards
	private By paymentCCSaved = By.xpath("//strong[text()='ending in 1111']");
	
	//confirm security code pop up
	private By paymentconfirmedCCV = By.xpath("//*[@id=\"secCode\"]");
	//private By paymentconfirmedSubmit = By.xpath("//button[text()='Submit']");
	private By paymentconfirmedSubmit = By.xpath("//div[contains(@class,'modal__modal-')]/section/div/button");
	private By paymentconfirmedframe = By.xpath("//div[contains(@class,'confirm-security')]/iframe");
	
	//Review Section
	private By ReviewLabel =  By.xpath("//*[@id=\"step-title-4\"]/h2");
	private By ReviewStepNo = By.xpath("//*[@id=\"step-title-4\"]/h2/span");
	private By ReviewPlaceOrderbtn = By.xpath("//button[text()='Place My Order']");
	
	
	
	
	

	// 2. page constructor:
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public void hello() {
		System.out.println("hello");
	}
	
	public WebElement doCreateAddressClick() {
		return eleUtil.waitForElementPresence(shippingAddressCreateNew, TimeUtil.LARGE_TIME_OUT);
	}
	public WebElement doDeliveryMethodClick() {
		return eleUtil.waitForElementPresence(deliverySaveButton, TimeUtil.LARGE_TIME_OUT);
	}
	public WebElement doPaymentClick() {
		return eleUtil.waitForElementPresence(paymentSaveButton, TimeUtil.LARGE_TIME_OUT);
	}
	
	public WebElement doRewviewClick() {
		return eleUtil.waitForElementPresence(ReviewPlaceOrderbtn, TimeUtil.LARGE_TIME_OUT);
	}
	
	//waitForFramePresentAndSwitch
	public void switchtoframe() {
		eleUtil.waitForFramePresentAndSwitch(paymentconfirmedframe, 4000);
	
	}
	
	
	
	public void paymentconfirmBtn() throws InterruptedException {
		eleUtil.doSendKeys(paymentconfirmedCCV, "111");
		Thread.sleep(4000);
		eleUtil.switchToDefaultContentFromFrame(10);
		eleUtil.clickElementWhenReady(paymentconfirmedSubmit, TimeUtil.LARGE_TIME_OUT);
	}
	
	public boolean enterShippingAddress(String firstName, String lastName, String Address, String telephone) {
		eleUtil.waitForElementVisible(this.shippingFirstName, TimeUtil.DEFAULT_TIME_OUT).sendKeys(firstName);
		eleUtil.doSendKeys(this.shippingLastName, lastName);
		eleUtil.doSendKeys(this.shippingAddress, Address);
		eleUtil.doClick(shippingZipcode);
		eleUtil.doActionsSendKeys(this.shippingPhone, telephone);
		//eleUtil.doSendKeys(this.confirmpassword, password);
		//eleUtil.doActionsSendKeys(this.telephone,telephone);
		eleUtil.doClick(shippingSaveButton);

		//System.out.println("Landed on Accounts page after registration");

		String successMesg = eleUtil.waitForElementVisible(shippingAddressConfirmation, TimeUtil.DEFAULT_TIME_OUT).getText();
		System.out.println(successMesg);

		if (successMesg.contains("Aravind")) {
			// eleUtil.doClick(logoutLink);
			// eleUtil.doClick(registerLink);
			return true;
		}
		// else { eleUtil.doClick(registerLink);
		// }

		return false;
	}
}
