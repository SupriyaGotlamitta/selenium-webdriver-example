package com.selenium.gmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.LoginPage;
import pom.LogoutPage;

public class GmailTest extends BaseTest {
	public WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = loadBrowser(browser);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.gmail.com");
	}

	@Test
	public void test() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		LogoutPage logoutPage = new LogoutPage(driver);

		// driver.findElement(By.id("identifierId")).sendKeys("supriya.gotlamitta");
		loginPage.setUserName("supriya.gotlamitta");
		// Call take screenshot function
		this.takeScreenShot(driver, "1.png");
		Thread.sleep(1000);
		loginPage.clickLogin();
		// driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();
		// Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("$March13");
		loginPage.setPassword("$March13");
		this.takeScreenShot(driver, "2.png");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
		loginPage.passwordNext();

		// #passwordNext > content > span
		// driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div/div[2]")).click();
		logoutPage.googleAccountClick();

		// driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[6]/div[4]/div[2]")).click();
		logoutPage.signoutButtonClick();
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
		// driver.quit();
	}

}
