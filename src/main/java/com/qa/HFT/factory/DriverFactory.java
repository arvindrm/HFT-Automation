package com.qa.HFT.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;

	public static String highlight;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver(Properties prop) {

		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is : " + browserName);
		

		highlight = prop.getProperty("highlight");

		optionsManager = new OptionsManager(prop);

		if (browserName.equalsIgnoreCase("chrome")) {
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		} 
		else if (browserName.equalsIgnoreCase("firefox")) {
			//driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		} else if (browserName.equalsIgnoreCase("safari")) {
			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			//driver = new EdgeDriver();
			tlDriver.set(new EdgeDriver());
		} else {
			System.out.println("Please pass the right browser name...." + browserName);
		}

		//getDriver().manage().deleteAllCookies();
		//getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url3"));
		getDriver().get(prop.getProperty("url2"));
		getDriver().get(prop.getProperty("url1"));
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();

		return getDriver();

	}
	
	//get the local thread copy of the driver
	public synchronized static WebDriver getDriver() {
		return tlDriver.get();
	}
		
	public Properties initProp() {
		prop = new Properties();
		FileInputStream ip = null;

		// mvn clean install -Denv="qa"
		// mvn clean install

		String envName = System.getProperty("env");
		String browserName = System.getProperty("browser");
		System.out.println("-----> Running test cases on environment----> " + envName);
		System.out.println("-----> Running test cases on Browser -test----> " + browserName);
		
		if (envName == null) {
			System.out.println("No env is given...hence running it on default QA env....");
			try {
				ip = new FileInputStream("./src/test/resources/config/stage3.config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {

			try {
				switch (envName.toLowerCase()) {
				case "stage":
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;
				case "test":
					ip = new FileInputStream("./src/test/resources/config/test.config.properties");
					break;
				case "stage3":
					ip = new FileInputStream("./src/test/resources/config/stage3.config.properties");
					break;
				case "stage4":
					ip = new FileInputStream("./src/test/resources/config/stage4.config.properties");
					break;
				case "prod":
					ip = new FileInputStream("./src/test/resources/config/config.properties");
					break;

				default:
					System.out.println("Please pass the right env name...." + envName);
					break;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
		
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//prop.setProperty("env", envName);
		//prop.setProperty("browser", browserName);
		
		return prop;
	}
	
	/**
	 * take screenshot
	 */
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileHandler.copy(srcFile, destination);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;

	}

}
