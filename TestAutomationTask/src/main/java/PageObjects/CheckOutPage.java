package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementActions;

public class CheckOutPage {
	
	private WebDriver driver;
	private By shippingMethod=By.cssSelector("input[value='flatrate_flatrate']");
	private By nextButton=By.cssSelector("button[data-role='opc-continue']");
	private By placeOrderButton=By.cssSelector("button[title='Place Order']");
	private By orderSuccessMessage=By.xpath("//span[text()='Thank you for your purchase!']");

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public CheckOutPage fillPaymentDetails() throws InterruptedException
	{
		ElementActions.clickElement(driver, shippingMethod);
		ElementActions.clickElement(driver, nextButton);
		ElementActions.clickElement(driver, placeOrderButton);
		return this;
	}
	
	public CheckOutPage verifyOderCreatedSuccessfully() throws InterruptedException
	{
		Assert.assertTrue(ElementActions.checkIfElementExists(driver, orderSuccessMessage));
		return this;
	}
	
	
	

}
