package testpkg;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg_miniswag.Baseclass_swag;
import pagepkg_swagmini.Cartpage_swag;
import pagepkg_swagmini.checkoutpage_swag;
import pagepkg_swagmini.loginpage_swag;
import pagepkg_swagmini.productpage_swag;

public class checkouttest_swag extends Baseclass_swag {
	
	loginpage_swag log;
	productpage_swag pdt;
	Cartpage_swag cart;
	checkoutpage_swag checkout;
	
	@Test
	public void checkoutvalidation() throws InterruptedException
	{
		test=extent.createTest("Checkout Validation Test");
		log=new loginpage_swag(driver);
		log.setvalues("standard_user","secret_sauce");
		log.loginbutton();
		
		pdt=new productpage_swag(driver);
		pdt.additems();
		
		
		cart=new Cartpage_swag(driver);
		cart.cartclick();
		cart.checkoutclick();
		
		checkout=new checkoutpage_swag(driver);
		checkout.enterfirstname("Anu");
		checkout.enterlastname("Krishna");
		checkout.enterzip("876543");
		
		checkout.continueclick();
		String actualtitle = checkout.checkouttitle().getText();
		Assert.assertEquals(actualtitle,"Checkout: Overview");
		test.pass("Checkout Overview page displayed successfully");
		checkout.finishclick();
		String message = checkout.verifysuccessmsg().getText();
		Assert.assertEquals(message,"Thank you for your order!");
		test.pass("Order completed successfully");
		System.out.println("Checkout validation completed successfully");
		
	}
}
