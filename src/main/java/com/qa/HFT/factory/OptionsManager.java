package com.qa.HFT.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		co.setBrowserVersion("121");
		co.addArguments("--remote-allow-origins=*");
		co.addArguments("--headless");
		co.addArguments("start-maximized");

		co.addArguments("--disable-dev-shm-usage");
		co.addArguments("--no-sandbox");

		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			System.out.println(".....Running the test in Headless mode.......");
			co.setHeadless(true);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(co.getBrowserVersion());
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			System.out.println(".....Running the test in Incognito mode.......");
			co.addArguments("--incognito");
		}
		return co;
	}

	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			System.out.println(".....Running the test in Headless mode.......");
			fo.setHeadless(true);
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			System.out.println(".....Running the test in Incognito mode.......");
			fo.addArguments("--incognito");
		}
		return fo;
	}

}
