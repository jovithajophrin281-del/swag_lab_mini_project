package pagepkg_swagmini;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartpage_swag {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a")
	WebElement carticon;
	
	@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/span")
	WebElement title;
	
	@FindBy(className="cart_item")
	List<WebElement> productdetails;
	
	@FindBy(xpath="//button[contains(@id,'remove')]")
	List<WebElement> removebutton;
	
	@FindBy(name="continue-shopping")
	WebElement continueshopping;
	
	@FindBy(xpath = "//*[@id=\"checkout\"]")
	WebElement checkout;
	
//	@FindBy(id="checkout")
//	WebElement checkout;
	
	@FindBy(className = "cart_item")
	List<WebElement> cartitems;

	public Cartpage_swag(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void cartclick()
	{
		carticon.click();
	}
	public WebElement carttitleverify()
	{
		return title;
	}
	public List<WebElement>productdtls()
	{
		return productdetails;
	}
	public int cartcount()
	{
	    return cartitems.size();
	}
	public void removeitem(int index)
	{
		removebutton.get(index).click();
	}
	public void continueshoppingclick()
	{
		continueshopping.click();
	}
	public void checkoutclick()
	{
		checkout.click();
	}
	public WebElement verifycheckout()
	{
		return checkout;
	}
	
	
	

}
