package com.MyArchetype.testscenario;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyArchetype.testscript.TestScript;

public class TestScenaio {
	TestScript script = new TestScript();

//@Parameters({"browserType"})
	@BeforeTest
	public void setBrowser() throws IOException {
		script.openBrowser();
	}

	@Test(priority = 1)
	public void loginPage() throws Exception {
		script.loginPage();
	}

	@Test(priority = 2)
	public void homePage() throws Exception {
		script.homePage();
	}

//	@AfterTest
//	public void closeBrowser() {
//		script.quitBrowser();
//	}
}
