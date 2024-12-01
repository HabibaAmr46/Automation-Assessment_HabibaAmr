package WebTests;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import PageObjects.CheckOutPage;
import PageObjects.CompareList;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ShoppingCart;
import PageObjects.WhatsNewPage;
import utils.BrowserFactory;
import utils.ExtentReportManager;
import utils.JsonFileManager;

public class PlaceOrderTest extends TestBase {

	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private WhatsNewPage whatsNewPage;
	private CompareList compareList;
	private ShoppingCart shoppingCart;
	private CheckOutPage checkOutPage;
	JSONObject testData;
	@Test
	public void CheckUserCanCreatePlaceOrder() throws InterruptedException {
		
		ExtentReportManager.createTest("Place Order");
		
		ExtentReportManager.info("Navigate to the url and Go to \"Sign in\" link");
		homePage.openURL()
				.clickSignInLink();
		
		ExtentReportManager.info("Login with valid user credentials");
		loginPage.
				login(JsonFileManager.getJsonValue(testData, "email"), 
				JsonFileManager.getJsonValue(testData, "password"));
		
		ExtentReportManager.info("Navigate to What's New Page");
		homePage.navigateToWhatsNew();
		
		ExtentReportManager.info("Choose any product and click add to compare list.");
		whatsNewPage.addProductToCompareList()
					.goToCompareList();
		
		ExtentReportManager.info("Add same product to cart. and Go to the shopping cart");
		compareList.addProductToShoppingCart()
					.goToShoppingCart();
		
		ExtentReportManager.info("Proceed to the Checkout");
		shoppingCart.proceedToCheckOut();
		
		ExtentReportManager.info("Fill the payment details and Place the order");
		checkOutPage.fillPaymentDetails()
					.verifyOderCreatedSuccessfully();

	}

/////////////// Configurations////////////////////////////////
	@BeforeClass
	public void classSetup() {
		testData = JsonFileManager.readJsonFile("src/test/resources/PlaceOrderTestData.json");
	}

	@BeforeMethod
	public void methodSetup() throws IOException {
		driver = BrowserFactory.getBrowserInstance();

		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		whatsNewPage= new WhatsNewPage(driver);
		compareList= new CompareList(driver);
		shoppingCart=new ShoppingCart(driver);
		checkOutPage=new CheckOutPage(driver);
	}

	@AfterMethod
	public void methodTearDown() {
		BrowserFactory.closeBrowserInstance(driver);
	}
}
