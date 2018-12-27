package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
	WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void googleAccountClick() {
		driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div/div[2]")).click();

	}
	public void signoutButtonClick() {
		driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[6]/div[4]/div[2]")).click();

	}
}
