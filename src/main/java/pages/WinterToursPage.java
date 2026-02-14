package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class WinterToursPage extends BasePage {

	private By nameField = By.id("field_qh4icy4");
	private By emailField = By.id("field_29yf4d4");
	private By phoneField = By.id("field_e5nnt");
	private By messageField = By.id("field_9jv0r13");

	public WinterToursPage enterName(String name) {
		getElement(nameField).sendKeys(name);
		return this;
	}

	public WinterToursPage enterEmail(String email) {
		getElement(emailField).sendKeys(email);
		return this;
	}

	public WinterToursPage enterPhone(String phone) {
		getElement(phoneField).sendKeys(phone);
		return this;
	}

	public WinterToursPage enterMessage(String message) {
		getElement(messageField).sendKeys(message);
		return this;
	}
}
