package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementActions;

public class WhatsNewPage {
	
	private WebDriver driver;
	//private By product=By.cssSelector("ol.product-items .product-item");
	private By product=By.id("old-price-4-widget-product-grid");
	private By addProductToCompareList=By.cssSelector(".action.tocompare");
	private By goToCompareList=By.cssSelector("div[data-ui-id='message-success'] a");
	
	public WhatsNewPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WhatsNewPage addProductToCompareList() throws InterruptedException
	{
		ElementActions.moveToElement(driver, product);
		ElementActions.clickElement(driver, addProductToCompareList);
		return this;
	}

	public void goToCompareList() throws InterruptedException
	{
		ElementActions.clickElement(driver, goToCompareList);
	}
}
