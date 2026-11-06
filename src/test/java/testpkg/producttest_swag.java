package testpkg;

import java.io.IOException;
//import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg_miniswag.Baseclass_swag;
import basepkg_miniswag.Reporterclass_swag;
import pagepkg_swagmini.loginpage_swag;
import pagepkg_swagmini.productpage_swag;

public class producttest_swag extends Baseclass_swag {
	
	loginpage_swag log;
	productpage_swag pdt;
	
	
	@Test(priority=1)
	public void logo() throws IOException, InterruptedException
	{
		log = new loginpage_swag(driver);
		log.setvalues("standard_user","secret_sauce");
		log.loginbutton();
		test=extent.createTest("logo validation test");
		pdt = new productpage_swag(driver);
		Thread.sleep(5000);
		WebElement x=pdt.logoverify();
		if(x.isDisplayed())
		{
			test.pass("logo displayed in product page");
			
		}
		else
		{
			String path=Reporterclass_swag.screenshotMethod(driver,"logo validation");
			test.addScreenCaptureFromPath(path);
			test.fail("logo not displayed");
		}
	}
	@Test(priority = 2)
	public void additemstocart() throws InterruptedException
	{
		pdt = new productpage_swag(driver);
		pdt.additems();
		Thread.sleep(4000);
		List<WebElement>dtl=pdt.productdtls();
//		Thread.sleep(4000);
		System.out.println("Total number of products: "+dtl.size());
		for(WebElement product:dtl)
		{
			System.out.println(product.getText());
		}
		pdt.cartclicks(); 
	}	
		
		
}

