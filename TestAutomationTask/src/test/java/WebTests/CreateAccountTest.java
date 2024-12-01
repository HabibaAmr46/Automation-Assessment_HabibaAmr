package WebTests;

import java.io.IOException;

import org.json.simple.JSONObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.AddHasCasting;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import PageObjects.CreateAccountPage;
import PageObjects.HomePage;
import utils.BrowserFactory;
import utils.ExtentReportManager;
import utils.JsonFileManager;

public class CreateAccountTest extends TestBase {

	private WebDriver driver;
	JSONObject testData;
	private HomePage homePage;
	private CreateAccountPage createAccountPage;
	private String currentTime = String.valueOf(System.currentTimeMillis());

	@Test
	public void CheckUserCanCreateNewAccount() throws InterruptedException {
		
		String uniqueEmail=JsonFileManager.getJsonValue(testData, "email")+currentTime+"@test.com";
		
		ExtentReportManager.createTest("Create new account");
		
		ExtentReportManager.info("Navigate to URL and \"Go to Create an Account\" page");
		homePage.openURL()
				.clickCreateAccountLink();
		
		ExtentReportManager.info("Enter all the required fields");
		createAccountPage.
				fillAccountDetails(JsonFileManager.getJsonValue(testData, "firstName"), 
				JsonFileManager.getJsonValue(testData, "lastName"), 
				uniqueEmail, 
				JsonFileManager.getJsonValue(testData, "password"), 
				JsonFileManager.getJsonValue(testData, "confirmPassword"));
		
		ExtentReportManager.info("Check Account is created Successfully");	
		homePage.
			checkAcccountIsCreated(JsonFileManager.getJsonValue(testData, "successMessage"));
		

	}

	/////////////// Configurations////////////////////////////////
	@BeforeClass
	public void classSetup() {
		testData =JsonFileManager.readJsonFile("src/test/resources/CreateAccountTestData.json");
	}

	@BeforeMethod
	public void methodSetup() throws IOException {
		driver = BrowserFactory.getBrowserInstance();

		homePage = new HomePage(driver);
		createAccountPage = new CreateAccountPage(driver);
	}

	@AfterMethod
	public void methodTearDown() {
		BrowserFactory.closeBrowserInstance(driver);
	}

}
