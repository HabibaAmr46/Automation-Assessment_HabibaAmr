package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.ElementActions;

public class CreateAccountPage {
	
	private WebDriver driver;
	private By firstName=By.id("firstname");
	private By lastName=By.id("lastname");
	private By emailAddress=By.id("email_address");
	private By password=By.id("password");
	private By confirmPassword=By.id("password-confirmation");
	private By createAccountButton=By.cssSelector("button[title='Create an Account']");
	
	
	
	public CreateAccountPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public CreateAccountPage fillAccountDetails(String firstname,String lastname,String mail, String password, String confirmPassword) throws InterruptedException
	{
		ElementActions.type(driver, this.firstName, firstname);
		ElementActions.type(driver, this.lastName, lastname);
		ElementActions.type(driver, this.emailAddress, mail);
		ElementActions.type(driver, this.password, password);
		ElementActions.type(driver, this.confirmPassword, confirmPassword);
		ElementActions.clickElement(driver, createAccountButton);
		
		return this;
		
	}
	
	
}
