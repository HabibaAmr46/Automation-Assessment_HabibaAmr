package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BrowserFactory {
	
	public static WebDriver getBrowserInstance()
	{
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public static void closeBrowserInstance(WebDriver driver)
	{
		
		if(driver!=null)
			driver.quit();
		
	}


}
