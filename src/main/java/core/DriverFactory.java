package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	private DriverFactory() {

	}

	public static WebDriver initDriver(String browser) {
		if (driver.get() == null) {
			synchronized (DriverFactory.class) {
				if (driver.get() == null) {
					WebDriver webDriver;
					switch (browser.toLowerCase()) {
					case "chrome":
						webDriver = new ChromeDriver();
						break;
					case "firefox":
						webDriver = new FirefoxDriver();
						break;
					case "edge":
						webDriver = new EdgeDriver();
						break;
					default:
						throw new IllegalArgumentException("Invalid browser value passed");
					}
					driver.set(webDriver);
				}
			}
		}
		return driver.get();
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}
}
