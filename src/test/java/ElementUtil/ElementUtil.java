package ElementUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementUtil {

   private WebDriver Driver1;

   public ElementUtil (WebDriver Driver1){

       this.Driver1 = Driver1;
   }

   public WebElement getElement(By locator) {

       return Driver1.findElement(locator);
   }

   public void doSendKeys(By locator, String value) {

       getElement(locator).sendKeys(value);
   }

    public String getAttributeValue(By locator){

       return getElement(locator).getAttribute("value");
   }

    public void doClick(By locator){

       getElement(locator).click();
    }
    public String doGetElementText (By locator){
       return getElement(locator).getText();
    }
}
