package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementActions;

public class CompareList {

	private WebDriver driver;
	private By addToCart = By.cssSelector(".action.tocart");
	private By goToShoppingCart=By.cssSelector("div[data-ui-id='message-success'] a");

	public CompareList(WebDriver driver) {
		this.driver = driver;
	}
	
	public CompareList addProductToShoppingCart() throws InterruptedException {
		ElementActions.clickElement(driver, addToCart);
		return this;
	}
	public CompareList goToShoppingCart() throws InterruptedException {
		ElementActions.clickElement(driver, goToShoppingCart);
		return this;
	}
}
