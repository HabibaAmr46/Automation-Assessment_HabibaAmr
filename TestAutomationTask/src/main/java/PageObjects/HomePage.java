package PageObjects;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.ElementActions;
import utils.PropertiesReader;

public class HomePage {
	
	private WebDriver driver;
	private Properties prop;
	private By createAccountLink=By.xpath("//a[text()='Create an Account']");
	private By signInLink=By.cssSelector(".authorization-link a");
	private By whatsNewLink=By.id("ui-id-3");
	private By successMessage=By.cssSelector(".page.messages");
	
	public HomePage(WebDriver driver) throws IOException
	{
		this.driver=driver;
		prop=PropertiesReader.getProperties();
	}
	
	public HomePage openURL()
	{
		driver.get(prop.getProperty("url"));
		return this;
	}
	public HomePage clickCreateAccountLink() throws InterruptedException
	{
		ElementActions.clickElement(driver, createAccountLink);
		return this;
	}
	
	public HomePage clickSignInLink() throws InterruptedException
	{
		ElementActions.clickElement(driver, signInLink);
		return this;
	}
	
	public HomePage navigateToWhatsNew() throws InterruptedException
	{
		ElementActions.clickElement(driver, whatsNewLink);
		return this;
	}
	
	public void checkAcccountIsCreated(String expectedMessage) 
	{
		
		Assert.assertTrue(ElementActions.getText(driver, this.successMessage).contains(expectedMessage));
	}

}
