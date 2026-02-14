package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import core.ConfigLoader;
import core.DriverFactory;

public class BaseTest {

	@BeforeMethod
	public void setUp() {
		ConfigLoader
				.getInstance(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
		DriverFactory.initDriver(ConfigLoader.getConfig().getProperty("browser"));
		DriverFactory.getDriver().get(ConfigLoader.getConfig().getProperty("testUrl"));
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}

}
