package testpkg;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepkg_miniswag.Baseclass_swag;
import basepkg_miniswag.Reporterclass_swag;
import pagepkg_swagmini.loginpage_swag;
import utilitiespkg.Excelutil;

public class logintest_swag extends Baseclass_swag {
	loginpage_swag log;
	
	//data provider
	
	@DataProvider(name="loginData")
	public Object[][]getData() throws IOException
	{
		String path = "C:\\Users\\Admin\\OneDrive\\Desktop\\selenium automation\\SWAG_maven.xlsx";
		return Excelutil.getTestData(path,"sheet1");
	}
	//login test
	
	@Test(dataProvider="loginData",priority = 1)
	public void logintest(String user,String password) throws IOException
	{
	driver.get("https://www.saucedemo.com/");
	test=extent.createTest("Login Test - " +user);
	log = new loginpage_swag(driver);
	log.setvalues(user,password);
	System.out.println("Executed for: "+user);
	loginpage_swag ob = new loginpage_swag(driver);
	ob.loginbutton();
	String currentUrl = driver.getCurrentUrl();
	
	// if login is successful
	
	if(currentUrl.equals("https://www.saucedemo.com/inventory.html"))
	{
		test.pass("Login successfull for: "+user);
    }
	else
	{
		String screenshotName = "Loginfailed "+user;
		Reporterclass_swag.screenshotMethod(driver,screenshotName);
		test.addScreenCaptureFromPath("screenshot\\ " +screenshotName+".png");
		test.fail("Login failed for: "+user);
		Assert.fail("Login failed for: "+user);
	}
	}
	//LOGO validation
	
	@Test(priority = 2)
	public void logoverification() throws IOException
	{
		driver.get("https://www.saucedemo.com/");
		test=extent.createTest("Logo validation test");
		log = new loginpage_swag(driver);
		WebElement x = log.logoverification();
		
		if(x.isDisplayed())
		{
			test.pass("Logo Displayed");
	    }
		else
		{
			String screenshotName = "Logo_validation";
			Reporterclass_swag.screenshotMethod(driver,screenshotName);
			test.addScreenCaptureFromPath("screenshot\\ " +screenshotName+".png");
			test.fail("Logo not displayed");
			Assert.fail("Logo not displayed");
		}
	
	}
	//BUTTON TEXT VALIDATION
	@Test(priority = 3)
	public void buttontextvalidation() throws IOException
	{
		driver.get("https://www.saucedemo.com/");
		test=extent.createTest("Button Text Validation Test");
		log = new loginpage_swag(driver);
		String text = log.login.getDomAttribute("value");
		
		if(text.equals("Login"))
			
		{
			test.pass("Button Text is Login");
	    }
		else
		{
			String screenshotName = "Button_Text_validation";
			Reporterclass_swag.screenshotMethod(driver,screenshotName);
			test.addScreenCaptureFromPath("screenshot\\ " +screenshotName+".png");
			test.fail("Button text is not Login");
			Assert.fail("Button text is not Login");
		}
	}
	//PLACEHOLDER VALIDATION
	@Test(priority = 4)
	public void placeholdervalidation() throws IOException
	{
		driver.get("https://www.saucedemo.com/");
		test = extent.createTest("Placeholder Validation Test");
		log = new loginpage_swag(driver);
		String username= log.username.getDomAttribute("placeholder");
		String password = log.pass.getDomAttribute("placeholder");
		if(username.equals("Username")&& password.equals("Password"))
		{
			test.pass("Placeholder Validation Passed");
		}
		else
		{
			String screenshotName = "placeholder_validation";
			Reporterclass_swag.screenshotMethod(driver, screenshotName);
			test.addScreenCaptureFromPath("screenshot\\"+screenshotName+".png");
			test.fail("Placeholder validation failed");
			Assert.fail("Placeholder validation failed");
		}
	}
	
	@Test(priority = 5)
	public void fetchtitlle() throws IOException
	{
		driver.get("https://www.saucedemo.com/");
		test = extent.createTest("Title validation test");
//		log = new loginpage_swagmini(driver);
		String act = driver.getTitle();
		String exp = "Swag Labs";
		if(exp.equals(act))
		{
			test.pass("Title validation passed");
			
		}
		else
		{
			String screenshotName = "title_validation";
			Reporterclass_swag.screenshotMethod(driver, screenshotName);
			test.addScreenCaptureFromPath("screenshot\\"+screenshotName+".png");
			test.fail("title validation failed");
			Assert.fail("title validation failed");
		}
		}
	
	
}

