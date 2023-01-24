package harborfreightfrontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ElementUtil.ElementUtil;
import libraryUtils.libraryUtils;

import java.time.Duration;

public class digitalGiftCardForm {

	public static WebDriver Driver1;
	static String verifyimag;
	static String giftcardLabel;

	public static void main(String[] args)throws InterruptedException {

		Driver1 = new ChromeDriver();
		ElementUtil eleutil = new ElementUtil(Driver1);
		// Driver1.get("https://stage:Sup3rs3cr3t%23%21@www-stage4.harborfreight.com");
		//Driver1.get("https://stage:Sup3rs3cr3t%23%21@www-test.harborfreight.com");
		//Driver1.get("https://stage:Sup3rs3cr3t%23%21@www-stage4.harborfreight.com");
		
		Driver1.get("https://stage:Sup3rs3cr3t%23%21@www-test.harborfreight.com");
		Driver1.get("https://stage:Sup3rs3cr3t%23%21@api-test.harborfreight.com");

		Driver1.navigate().to("https://www-test.harborfreight.com/digital-gift-card");
		Thread.sleep(3000);
		// giftcardLabel = Driver1.findElement(By.xpath("//h2")).getText();
		By giftcardLabel = By.xpath("//h2");

		System.out.println(eleutil.getElement(giftcardLabel).getText());

		// WebElement giftCardDesignPrimary =
		// Driver1.findElement(By.xpath("//div[contains(@class,'radio__radio')]/div/label/img"));
		// WebElement giftCardDesignHoliday =
		// Driver1.findElement(By.xpath("//div[contains(@class,'radio__radio')]/div[2]/label/img"));
		// WebElement giftCardToolBox =
		// Driver1.findElement(By.xpath("//div[contains(@class,'radio__radio')]/div[3]/label/img"));
		// WebElement giftCardMetal =
		// Driver1.findElement(By.xpath("//div[contains(@class,'radio__radio')]/div[4]/label/img"));
		// WebElement giftCardPaintRoller =
		// Driver1.findElement(By.xpath("//div[contains(@class,'radio__radio')]/div[5]/label/img"));

		By giftCardDesignPrimary = By.xpath("//div[contains(@class,'radio__radio')]/div/label/img");

		By giftCardDesignHoliday = By.xpath("//div[contains(@class,'radio__radio')]/div[2]/label/img");
		By giftCardToolBox = By.xpath("//div[contains(@class,'radio__radio')]/div[3]/label/img");
		By giftCardMetal = By.xpath("//div[contains(@class,'radio__radio')]/div[4]/label/img");
		By giftCardPaintRoller = By.xpath("//div[contains(@class,'radio__radio')]/div[5]/label/img");
		By imgPrimary = By.xpath("//div[contains(@class,'aQbsRg')]/img");
		// WebElement imgPrimary
		// =Driver1.findElement(By.xpath("//div[contains(@class,'aQbsRg')]/img"));

		// *[@id="amount_Custom Amount_undefined"]
		// *[@id="root"]/div[3]/div/div/div[2]/div[3]/form/div[1]/div[4]/div/div[6]/label

		// https://www-stage4.harborfreight.com/media/catalog/product/dgc/7/0/70205/HFTPrimary092022.png
		// https://www-stage4.harborfreight.com/media/catalog/product/dgc/7/0/70205/HFTHoliday112022.png
		// https://www-stage4.harborfreight.com/media/catalog/product/dgc/7/0/70205/HFTToolbox092022.png
		// https://www-stage4.harborfreight.com/media/catalog/product/dgc/7/0/70205/HFTMetal092022.png
		// https://www-stage4.harborfreight.com/media/catalog/product/dgc/7/0/70205/HFTPaintRollers092022.png

		// div[contains(@class,'aQbsRg')]
		// div[contains(@class,'digital-gift-card__bubble--m7spF8')]/blockquote -- gift
		// card text
		Thread.sleep(3000);
		//// div[contains(@class,'amount--2n-Tcf')]/div/div/input --$10 --
		//// //div[contains(@class,'amount--2n-Tcf')]/div/div/label/span
		// span[contains(@class,'Q537ya')]

		String amountTen = Driver1.findElement(By.xpath("//div[contains(@class,'amount--2n-Tcf')]/div/div/input"))
				.getAttribute("value");
		WebElement amountTen1 = Driver1
				.findElement(By.xpath("//div[contains(@class,'amount--2n-Tcf')]/div/div/label/span"));
		amountTen1.click();
		System.out.println("$ " + amountTen + " " + eleutil.getElement(giftcardLabel).getText());
		// System.out.println(amountTen.getAttribute("value"));

		Thread.sleep(3000);
		// $25
		// "//div[contains(@class,'amount--2n-Tcf')]/div/div[2]/input"))
		String amountTwentyFive = Driver1
				.findElement(By.xpath("//div[contains(@class,'amount--2n-Tcf')]/div/div[2]/input"))
				.getAttribute("value");
		WebElement amountTwentyFive1 = Driver1
				.findElement(By.xpath("//div[contains(@class,'amount--2n-Tcf')]/div/div[2]/label/span"));
		amountTwentyFive1.click();
		System.out.println("$ " + amountTwentyFive + " " + eleutil.getElement(giftcardLabel).getText());
		// System.out.println(amountTwentyFive.getAttribute("value"));

		Thread.sleep(3000);
		// $50
		String amountFifty = Driver1.findElement(By.xpath("//div[contains(@class,'amount--2n-Tcf')]/div/div[3]/input"))
				.getAttribute("value");
		WebElement amountFifty1 = Driver1
				.findElement(By.xpath("//div[contains(@class,'amount--2n-Tcf')]/div/div[3]/label/span"));
		amountFifty1.click();
		System.out.println("$ " + amountFifty + " " + eleutil.getElement(giftcardLabel).getText());
		// System.out.println(amountFifty.getAttribute("value"));

		Thread.sleep(3000);
		// $75
		String amountSeventyFive = Driver1
				.findElement(By.xpath("//div[contains(@class,'amount--2n-Tcf')]/div/div[4]/input"))
				.getAttribute("value");
		WebElement amountSeventyFive1 = Driver1
				.findElement(By.xpath("//div[contains(@class,'amount--2n-Tcf')]/div/div[4]/label/span"));
		amountSeventyFive1.click();
		System.out.println("$ " + amountSeventyFive + " " + eleutil.getElement(giftcardLabel).getText());
		// System.out.println(amountSeventyFive.getAttribute("value"));

		Thread.sleep(3000);
		// $100
		String amountHundred = Driver1
				.findElement(By.xpath("//div[contains(@class,'amount--2n-Tcf')]/div/div[5]/input"))
				.getAttribute("value");
		WebElement amountHundred1 = Driver1
				.findElement(By.xpath("//div[contains(@class,'amount--2n-Tcf')]/div/div[5]/label/span"));
		amountHundred1.click();
		System.out.println("$ " + amountHundred + " " + eleutil.getElement(giftcardLabel).getText());
		// System.out.println(amountHundred.getAttribute("value"));

		Thread.sleep(3000);
		WebElement amountCustom = Driver1.findElement(By.xpath("//div[contains(@class,'2n-Tcf')]/div/div[6]/label"));
		amountCustom.click();
		String amountCustonstg = amountCustom.getText();
		System.out.println(amountCustonstg);

		Thread.sleep(3000);
		WebElement customAmounttxt1 = Driver1.findElement(By.xpath("//div[contains(@class,'3TzVU')]/div/Input"));
		customAmounttxt1.sendKeys("40");

		Thread.sleep(3000);
		String errorMsg = Driver1.findElement(By.xpath("//div[contains(@class,'TLlWJk')]/small")).getText();
		System.out.println(errorMsg);

		eleutil.doClick(giftCardDesignPrimary);
		System.out.println(eleutil.getElement(giftCardDesignPrimary).getAttribute("src"));
		verifyimag = eleutil.getElement(imgPrimary).getAttribute("src");
		if (verifyimag.equals(
				"https://www-stage4.harborfreight.com/media/catalog/product/dgc/7/0/70205/HFTPrimary092022.png")) {
			System.out.println("Image of First card is correct");
		} else {
			System.out.println("Image of First card is not correct");
		}
		Thread.sleep(3000);

		eleutil.doClick(giftCardDesignHoliday);
		System.out.println(eleutil.getElement(giftCardDesignHoliday).getAttribute("src"));
		verifyimag = eleutil.getElement(imgPrimary).getAttribute("src");
		if (verifyimag.equals(
				"https://www-stage4.harborfreight.com/media/catalog/product/dgc/7/0/70205/HFTHoliday112022.png")) {
			System.out.println("Image of Secomd card is correct");
		} else {
			System.out.println("Image of Secomd card is not correct");
		}
		Thread.sleep(3000);

		eleutil.doClick(giftCardToolBox);
		System.out.println(eleutil.getElement(giftCardToolBox).getAttribute("src"));
		verifyimag = eleutil.getElement(imgPrimary).getAttribute("src");
		if (verifyimag.equals(
				"https://www-stage4.harborfreight.com/media/catalog/product/dgc/7/0/70205/HFTToolbox092022.png")) {
			System.out.println("Image of Third card is correct");
		} else {
			System.out.println("Image of Third card is not correct");
		}
		Thread.sleep(3000);

		eleutil.doClick(giftCardMetal);
		System.out.println(eleutil.getElement(giftCardMetal).getAttribute("src"));
		verifyimag = eleutil.getElement(imgPrimary).getAttribute("src");
		if (verifyimag.equals(
				"https://www-stage4.harborfreight.com/media/catalog/product/dgc/7/0/70205/HFTMetal092022.png")) {
			System.out.println("Image of Fourth card is correct");
		} else {
			System.out.println("Image of Fourth card is not correct");
		}
		Thread.sleep(3000);

		eleutil.doClick(giftCardPaintRoller);
		System.out.println(eleutil.getElement(giftCardPaintRoller).getAttribute("src"));
		verifyimag = eleutil.getElement(imgPrimary).getAttribute("src");
		if (verifyimag.equals(
				"https://www-stage4.harborfreight.com/media/catalog/product/dgc/7/0/70205/HFTPaintRollers092022.png")) {
			System.out.println("Image of Five card is correct");
		} else {
			System.out.println("Image of Five card is not correct");
		}
		Thread.sleep(3000);

		// Recipient's name
		By rName = By.id("recipientName");
		eleutil.doSendKeys(rName, "Darcy");
		// Driver1.findElement(By.id("recipientName")).sendKeys("Darcy");
		// Recipient's Email
		By rEmail = By.id("recipientEmail");
		eleutil.doSendKeys(rEmail, "reddy.aravindm@gmail.com");
		// Driver1.findElement(By.id("recipientEmail")).sendKeys("reddy.aravindm@gmail.com");
		// SenderName
		By sName = By.id("senderName");
		eleutil.doSendKeys(sName, "Aravind");
		// Driver1.findElement(By.id("senderName")).sendKeys("Aravind");
		// Recipient's Email
		By sEmail = By.id("senderEmail");
		eleutil.doSendKeys(sEmail, "reddy.aravind@gmail.com");
		// Driver1.findElement(By.id("senderEmail")).sendKeys("reddy.aravindm@gmail.com");
		// Buy Now
		By bNow = By.xpath("//button[contains(@class,'tRVCwJ')]");
		eleutil.doClick(bNow);
		// Driver1.findElement(By.xpath("//button[contains(@class,'tRVCwJ')]")).click();
		Driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		// wait
		boolean checkoutL = Driver1.findElement(By.xpath("//div[contains(@class,'checkout-login__guest')]/button"))
				.isDisplayed();
		if (checkoutL) {
			System.out.println("checkoutL clicked :" + checkoutL);
			Driver1.findElement(By.xpath("//div[contains(@class,'checkout-login__guest')]/button")).click();
		} else {
			Driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
			Driver1.findElement(By.xpath("//div[contains(@class,'checkout-login__guest')]/button")).click();
		}
		// Driver1.navigate().to("https://www-stage4.harborfreight.com/checkout/onepage");

		String pymt = Driver1.findElement(By.xpath("//div[contains(@class,'checkout-payment')]/div/h2")).getText();
		System.out.println(pymt);
		int size = Driver1.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Thread.sleep(5000);
		// Driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(20000));
		Driver1.switchTo()
				.frame(Driver1.findElement(By.xpath("//div[contains(@class,'checkout-payment')]/form/div/iframe")));

		// Driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		// Driver1.switchTo().window().
		String lblTxt = Driver1.findElement(By.xpath("//div[contains(@class,'credit-block')]/label")).getText();
		System.out.println(lblTxt);
		Driver1.findElement(By.xpath("//input[@id='cName']")).click(); //// div[contains(@class,'credit')]/input
		Driver1.findElement(By.xpath("//input[@id='cName']")).sendKeys("Aravind reddy");
		String val = "4111 1111 1111 1111";
		WebElement element = Driver1.findElement(By.xpath("//input[@id='cNumber']"));
		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			element.sendKeys(s);
		}
		Driver1.findElement(By.xpath("//input[@id='secCode']")).sendKeys("111");
		Driver1.findElement(By.xpath("//input[@id='exDate']")).sendKeys("03/24");
		Driver1.findElement(By.xpath("//input[@id='exDate']")).click();
		Driver1.switchTo().defaultContent();

		Driver1.findElement(By.id("address-firstname")).sendKeys("Aravind");
		Driver1.findElement(By.id("address-lastname")).sendKeys("reddy");
		Driver1.findElement(By.id("address-street1")).sendKeys("599 calle de las ovejas");
		Driver1.findElement(By.id("address-postcode")).sendKeys("91377");
		String phone = "415 699 8387";
		WebElement phnTxt = Driver1.findElement(By.id("address-telephone"));
		phnTxt.click();
		for (int i = 0; i < phone.length(); i++) {
			char c = phone.charAt(i);
			String s = new StringBuilder().append(c).toString();
			phnTxt.sendKeys(s);
		}
		Thread.sleep(3000);
		// Driver1.findElement(By.xpath("//div[contains(@class,'checkout-payment')]/form/button")).click();
		
		  libraryUtils .waitForElementToBeClicable(Driver1,
		  Driver1.findElement(By.xpath(
		  "//div[contains(@class,'checkout-payment')]/form/button")), 10) .click();
		 

		Driver1.findElement(By.xpath("//div[contains(@class,'checkout-review')]/button")).click();

		
		  libraryUtils.waitForElementToBeClicable(Driver1,
		  Driver1.findElement(By.id("password")), 10);
		 

		 Thread.sleep(3000);
		 Driver1.quit();

	}

}
