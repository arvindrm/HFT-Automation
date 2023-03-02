package com.qa.HFT.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.HFT.utils.ElementUtil;

public class CheckOutPage {
	
	
	
	
	//Login 
	//search an item (63531)
	//add an item to the cart
	//overlay pop up 
	//go to check out page
	//enter details on check out page
		//Shipping address
		//Delivery method
		//cc info
		//place an order
	//Order Confirmation page
		//Assert 
	
	//Guest user
		//search an item (63531)
		//add an item to the cart
		//go to check out page
		//guest user
		//enter details on check out page
			//Shipping address
			//Delivery method
			//cc info
			//place an order
		//Order Confirmation page
			//Assert 
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//private By addToCartOverLay=By.xpath("//*[@id='product-wrap']/div[1]/div[3]/div[7]/div[2]/div[2]/div/div[2]/div[2]/a");
	private By shippingAddress = By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[1]/form/div/div[2]/label");
	private By shippingSaveButton = By.xpath("//button[text()='Save & Continue']");
	private By deliveryMethod = By.xpath("//button[text()='Save & Continue']");
	private By deliverySaveButton = By.xpath("//form//button");
	
	
	
	// 2. page constructor:
			public CheckOutPage(WebDriver driver) {
				this.driver = driver;
				eleUtil = new ElementUtil(driver);
			}
	
	public void hello() {
		System.out.println("hello");
	}
}
