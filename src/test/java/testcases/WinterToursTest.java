package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.WinterToursPage;

public class WinterToursTest extends BaseTest{

	@Test
	public void winterToursTest() throws InterruptedException{
		
		HomePage homePage = new HomePage();
		WinterToursPage winterToursPage = homePage.goToWinterToursPage();
		winterToursPage
			.enterName("Khaleefullah Akbar Ali")
			.enterEmail("khaleefullah.a@gmail.com")
			.enterPhone("9791253589")
			.enterMessage("Hi there, this is Khaleefullah");
		Thread.sleep(2000);
	}
}
