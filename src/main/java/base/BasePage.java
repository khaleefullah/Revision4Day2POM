package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.DriverFactory;

public class BasePage {

	protected WebDriver driver;

	public BasePage() {
		this.driver = DriverFactory.getDriver();
	}
	
	public WebElement getElement(By by) {
		return driver.findElement(by);
	}

}
