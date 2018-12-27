package com.selenium.gmail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumTest1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\supriya\\selenium-projects\\selenium-webdriver-example\\selenium-webdriver-examples\\src\\lib\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.gmail.com");
		
	}
	
}
