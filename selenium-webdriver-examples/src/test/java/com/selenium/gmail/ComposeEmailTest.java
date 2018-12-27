package com.selenium.gmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.ComposeEmailPage;
import pom.LoginPage;
import pom.LogoutPage;

public class ComposeEmailTest extends BaseTest {
	WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void loadDriver(String browser) {
		driver = super.loadBrowser(browser);
	}

	@DataProvider(name = "GmailLogin")
	public Object[][] createData() {
		Object[][] retObjArr = { { "supriya.gotlamitta", "$March13", "ss@gmail.com", "hellooo" } };
//		Object[][] retObjArr = { { "supriya.gotlamitta", "$March13", "ss@gmail.com", "hellooo" }, { "sreedhar.vl", "$March13", "s1@gmail.com", "haiii" } };
		return retObjArr;
	}

	@Test(dataProvider = "GmailLogin")
	public void composeEmail(String userName, String password, String toEmail, String sub) {
		LogoutPage logoutPage = new LogoutPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		ComposeEmailPage composeEmailapge = new ComposeEmailPage(driver);
		driver.get("https://www.gmail.com");

		loginPage.setUserName(userName);
		loginPage.clickLogin();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		loginPage.setPassword(password);
		loginPage.passwordNext();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Create object of WebDriverWait class
		// WebDriverWait wait=new WebDriverWait(driver,40);
		// Wait till the element is not visible
		// WebElement
		// element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\":iv\\\"]")));
		composeEmailapge.clickComposeBox();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.className("vO")).sendKeys(toEmail);
		driver.findElement(By.className("aoT")).sendKeys(sub);
		driver.findElement(By.xpath("//*[@id=\":nx\"]")).click();
		String title = "supriya.gotlamitta@gmail.com";
		if (driver.getTitle().contains(title)) {
			System.out.println("logged in successfully::" + driver.getTitle());

		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// #passwordNext > content > span
		// driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div/div[2]")).click();
		logoutPage.googleAccountClick();

		// driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[6]/div[4]/div[2]")).click();
		logoutPage.signoutButtonClick();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}

	public void toMessage() {//
		// driver.findElement(By.xpath("))//
	}

	@AfterTest
	public void closeBrowser() {
		System.out.println("After test");
		
	}

}
