package pagepkg_swagmini;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productpage_swag {
	
	WebDriver driver;
	
	@FindBy(className = ".app_logo")
	WebElement logo;
	
	@FindBy(xpath ="//*[text()='Add to cart']")
	List<WebElement>cartbutton;
	
    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div/div")
	List<WebElement>productdetails;
	
	@FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
	WebElement carticon;
	
	public productpage_swag(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement logoverify()
	{
		return logo;
	}
	public void additems() throws InterruptedException
	{
		for(WebElement items: cartbutton)
		{
			Thread.sleep(4000);
			System.out.println(items);
			
			items.click();
			Thread.sleep(4000);
		}
		
		
	}
	public List<WebElement>productdtls()
	
	{
		return productdetails;
	}
	public void cartclicks()
	{
		carticon.click();
	}
	

}
