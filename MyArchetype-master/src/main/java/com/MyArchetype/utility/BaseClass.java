package com.MyArchetype.utility;

import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.MyArchetype.helper.PageActions;
import com.MyArchetype.helper.PageManager;

public class BaseClass {

	public PageActions helper = new PageActions();
	public static Logger log = Logger.getLogger(BaseClass.class);
	public WebDriver driver;
	public Properties property;
	PageManager pageManager = new PageManager();

	/**
	 * select driver class type
	 * 
	 * @param browserType
	 * @throws IOException
	 */

	public void openBrowser() throws IOException {
		property = pageManager.loadpropertyFile(ConstantPaths.configPropertiesFilePath);
		String browserType = property.getProperty("browser");

		switch (browserType) {

		case "chrome":
			ChromeOptions optionschrome = new ChromeOptions();
			optionschrome.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", ConstantPaths.chromeDriverPath);
			driver = new ChromeDriver(optionschrome);
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", ConstantPaths.fireFoxDriverPath);
			driver = new FirefoxDriver();
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", ConstantPaths.IEDriverPath);
			driver = new InternetExplorerDriver();
			break;

		}

		driver.manage().window().maximize();
		PageManager.manageTimeOuts(driver);
		driver.get(property.getProperty("url"));

	}

	public void quitBrowser() {
		driver.quit();
	}
}
