package testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataprovider.TestDataProvider;
import pages.HomePage;
import pages.WinterToursPage;

public class WinterToursTest extends BaseTest{

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "dp")
	public void winterToursTest(Hashtable<String, String> data) throws InterruptedException{
		
		HomePage homePage = new HomePage();
		WinterToursPage winterToursPage = homePage.goToWinterToursPage();
		winterToursPage
			.enterName(data.get("Name"))
			.enterEmail(data.get("Email"))
			.enterPhone(data.get("Phone"))
			.enterMessage(data.get("Message"));
		Thread.sleep(3000);
		Assert.fail();
	}
}
