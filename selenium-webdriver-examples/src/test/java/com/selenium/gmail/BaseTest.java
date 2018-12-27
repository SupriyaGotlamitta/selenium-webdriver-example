package com.selenium.gmail;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {
	public WebDriver loadBrowser(String browser) {
		WebDriver driver = null;
		String srtDriverPath = "";

		try {
			// get the canonical path of project root directory
			String path = new File(".").getCanonicalPath();
			srtDriverPath = path.concat("\\src\\main\\resources\\");
			System.out.println("srtDriverPath::" + srtDriverPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", srtDriverPath.concat("IEDriverServer.exe"));

			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", srtDriverPath.concat("chromedriver.exe"));

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", srtDriverPath.concat("geckodriver.exe"));

			driver = new FirefoxDriver();
		}
		return driver;
	}

	public void takeScreenShot(WebDriver driver, String fileName) {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// Call getScreenshotAs method to create image file
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String destFilePath = "";
		try {
			String path = new File(".").getCanonicalPath();
			destFilePath = path.concat("\\src\\main\\reports\\").concat(fileName);
			System.out.println("destFilePath::" + destFilePath);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Move image file to new destination
		File destFile = new File(destFilePath);
		// Copy file at destination

		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
