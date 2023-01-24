package ElementUtil;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtil {

    static WebDriver driver;

    public WebDriver launchBrowser(String browsername) {
        System.out.println("Browser name is : " + browsername);

        switch (browsername.toLowerCase()){
            case "chrome":
                //System.setProperty("webdriver.chrome.driver", "/Users/amamilapally/Desktop/HarborFreight/Automation/harborfreight/src/test/Drivers/chromedriver1");
                driver = new ChromeDriver();
                break;

            case "safari":
                driver = new SafariDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;


        }
        return driver;
    }


}