package com.qa.testscripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.pages.Pages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	WebDriver driver;
	Actions action;
	JavascriptExecutor js;
	SoftAssert softAssert;
    Pages p;
	@Parameters({"Url","Browser"})
	@BeforeSuite
	public void setUp(String Url,String Browser) {
		if (Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("Edge")) {
			 WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		//Load the URl of the page
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		p = new Pages(driver);
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	public void captureScreenshot(WebDriver driver, String tName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tName + ".png");
		FileUtils.copyFile(source, target);
	}


}
