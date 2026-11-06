package basepkg_miniswag;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Baseclass_swag {
	
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	String url="https://www.saucedemo.com/";
	
	@BeforeSuite
	public void setupreport()
	{
		extent = Reporterclass_swag.sam();
	}

	@BeforeTest
	public void browserlaunch()
	{
//		 driver = new ChromeDriver();
//		 driver.manage().window().maximize();
//		 driver.get(url);
		ChromeOptions options = new ChromeOptions();

	    Map<String, Object> prefs = new HashMap<>();

	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    prefs.put("profile.password_manager_leak_detection", false);

	    options.setExperimentalOption("prefs", prefs);

	    driver = new ChromeDriver(options);

	    driver.manage().window().maximize();
	    driver.get(url);
	}
	@AfterTest
	public void updateReport(ITestResult result) throws IOException
	{
		if(test==null)
		{
			test = extent.createTest(result.getMethod().getMethodName());
			
		}
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.pass("Test Passed : "+result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			test.fail("Test Failed: "+result.getName());
			test.fail(result.getThrowable());
			String path = Reporterclass_swag.screenshotMethod(driver,result.getName());
			test.addScreenCaptureFromPath(path);
		}
		else
		{
			test.skip("Test Skipped : "+result.getName());
		}
		if(driver !=null)
		{
			driver.quit();
		}
	}
	@AfterSuite
	public void closeReport()
	{
		if(extent !=null)
		{
			extent.flush();
		}
	}

}
