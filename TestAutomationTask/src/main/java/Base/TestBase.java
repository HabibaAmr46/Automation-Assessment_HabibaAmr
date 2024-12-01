package Base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;

import utils.ExtentReportManager;

public class TestBase {
	
	@BeforeSuite
	public void intializeReport()
	{
		ExtentReportManager.initReports();
	}
	
	@AfterSuite
	public void finalizeReport()
	{
		ExtentReportManager.flushReports();
	}

}
