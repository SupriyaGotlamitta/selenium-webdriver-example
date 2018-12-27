package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComposeEmailPage {
	WebDriver driver;

	public ComposeEmailPage(WebDriver driver) {
     this.driver=driver;
	}
public void clickComposeBox() {
	driver.findElement(By.xpath("//*[@id=\":iv\"]")).click();
}
}
