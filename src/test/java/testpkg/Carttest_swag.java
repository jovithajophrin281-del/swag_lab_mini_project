package testpkg;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



import basepkg_miniswag.Baseclass_swag;
import pagepkg_swagmini.Cartpage_swag;
import pagepkg_swagmini.loginpage_swag;
import pagepkg_swagmini.productpage_swag;

public class Carttest_swag extends Baseclass_swag {
	
	loginpage_swag log;
	productpage_swag pdt;
	Cartpage_swag cart;
	
	@Test
	public void cartvalidation() throws InterruptedException
	{
		test = extent.createTest("Cart Validation Test");
		log=new loginpage_swag(driver);
		log.setvalues("standard_user","secret_sauce");
		log.loginbutton();
		
		pdt=new productpage_swag(driver);
		int expectedcount=pdt.productdtls().size();
		pdt.additems();
		
		cart = new Cartpage_swag(driver);
		cart.cartclick();
		String title = cart.carttitleverify().getText();
		Assert.assertEquals(title,"Your Cart");
		test.pass("Cart Title Validation passed");
		List<WebElement>dtl=cart.productdtls();
		System.out.println("Total products in cart "+dtl.size());
		Assert.assertEquals(dtl.size(),expectedcount);
		test.pass("Product count validation passed");
		
		Assert.assertTrue(cart.verifycheckout().isDisplayed());
		test.pass("Checkout button displayed successfully");
		System.out.println("Cart Validation completed successfully");
		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document,body.scrollHeight)");
		cart.checkoutclick();
	}
	
	 
	

}
