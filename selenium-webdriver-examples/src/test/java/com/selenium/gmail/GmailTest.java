package com.selenium.gmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GmailTest {
	public WebDriver driver;

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browser) {
		if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\supriya\\selenium-projects\\selenium-webdriver-example\\selenium-webdriver-examples\\src\\lib\\IEDriverServer.exe");

			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\supriya\\selenium-projects\\selenium-webdriver-example\\selenium-webdriver-examples\\src\\lib\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\supriya\\selenium-projects\\selenium-webdriver-example\\selenium-webdriver-examples\\src\\lib\\geckodriver.exe");

			driver = new FirefoxDriver();
		}
	}

	@Test
	public void test() throws InterruptedException {

		driver.get("https://www.gmail.com");
//		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.id("identifierId")).sendKeys("supriya.gotlamitta");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();
		//Thread.sleep(10000);	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("$March13");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
		//#passwordNext > content > span
		driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[6]/div[4]/div[2]")).click();
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
//		driver.quit();
	}

}
