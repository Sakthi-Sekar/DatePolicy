package com.MyArchetype.testscript;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.MyArchetype.helper.LogReports;
import com.MyArchetype.helper.PageManager;
import com.MyArchetype.helper.Validation;
import com.MyArchetype.utility.BaseClass;
import com.MyArchetype.utility.ConstantPaths;

public class TestScript extends BaseClass {
	String actualText, expectedText,expectedClass;
	Properties userProperty;
	PageManager pageManager = new PageManager();
	Validation validate = new Validation();
	LogReports log = new LogReports();

	public void loginPage() throws Exception {
		property = pageManager.loadpropertyFile(ConstantPaths.locatorsPropertiesFilePath);
		userProperty = pageManager.loadpropertyFile(ConstantPaths.credentialsFilePath);
		helper.getElement(driver, property, "email").sendKeys(userProperty.getProperty("usrname"));
		log.info("username is entered as user@phptravels.com");
		helper.getElement(driver, property, "passwd").sendKeys(userProperty.getProperty("pswd"));
		log.info("password is typed as demouser");
		helper.getElement(driver, property, "login").click();
		log.info("Logged in");

	}

	public void homePage() throws Exception {
		property = pageManager.loadpropertyFile(ConstantPaths.locatorsPropertiesFilePath);
		userProperty = pageManager.loadpropertyFile(ConstantPaths.credentialsFilePath);
		actualText = helper.getElement(driver, property, "homepagetext").getText();
		expectedText = userProperty.getProperty("text");
		validate.validate(actualText, expectedText, "Usename is not matched");
		System.out.println(actualText);
		log.info("Verified the text Hi,Demo User ");
		actualText=helper.getElement(driver, property, "bookings").getAttribute("class");
		

	}
}
