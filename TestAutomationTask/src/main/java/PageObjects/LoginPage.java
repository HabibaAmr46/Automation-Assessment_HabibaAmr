package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementActions;

public class LoginPage {

	private WebDriver driver;
	
	private By email= By.id("email");
	private By password= By.id("pass");
	private By signInButton=By.id("send2");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void login(String email, String password) throws InterruptedException
	{
		ElementActions.type(driver, this.email, email);
		ElementActions.type(driver, this.password, password);
		ElementActions.clickElement(driver, signInButton);
	}
	
	
	
	
}
