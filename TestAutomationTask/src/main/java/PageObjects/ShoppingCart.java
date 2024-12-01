package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementActions;

public class ShoppingCart {
	private WebDriver driver;
	private By checkOutButton=By.cssSelector("button[data-role='proceed-to-checkout']");

	public ShoppingCart(WebDriver driver) {
		this.driver = driver;
	}
	
	public void proceedToCheckOut() throws InterruptedException
	{
		ElementActions.clickElement(driver, checkOutButton);
	}

}
