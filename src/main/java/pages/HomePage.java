package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class HomePage extends BasePage{
	
	private By winterToursMenu = By.linkText("Alaska Winter Tours");
	
	public WinterToursPage goToWinterToursPage() {
		getElement(winterToursMenu).click();
		return new WinterToursPage();
	}

}
