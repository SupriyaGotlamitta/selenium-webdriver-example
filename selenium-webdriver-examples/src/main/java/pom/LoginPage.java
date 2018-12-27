package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}
	public void setUserName(String strUserName) {
		WebElement userID = driver.findElement(By.id("identifierId"));
		
		userID.sendKeys(strUserName);
		
	}
	public void clickLogin() {
		
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();
	// TODO Auto-generated method stub

	}
	public void setPassword(String strPassword) {
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(strPassword);

	}
	public void passwordNext() {
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();

	}
}
