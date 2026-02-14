package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import core.ConfigLoader;
import core.DriverFactory;

public class BaseTest {

	@BeforeMethod
	public void setUp() throws InterruptedException{
		ConfigLoader
				.getInstance(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
		DriverFactory.initDriver(ConfigLoader.getConfig().getProperty("browser"));
		DriverFactory.getDriver().get(ConfigLoader.getConfig().getProperty("testUrl"));
		Thread.sleep(3000);
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}

}
