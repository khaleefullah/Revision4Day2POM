package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import core.DriverFactory;

public class BaseTest {
	
	@BeforeMethod
	public void setUp() {
		
		DriverFactory.initDriver("chrome");
		DriverFactory.getDriver().get("https://www.alaskatrips.com");
	}
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}

}
