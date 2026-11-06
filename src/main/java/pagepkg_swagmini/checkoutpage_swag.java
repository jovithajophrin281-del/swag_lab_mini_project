package pagepkg_swagmini;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutpage_swag {
	
	WebDriver driver;
	
	@FindBy(id="first-name")
	WebElement firstname;
	
	@FindBy(id="last-name")
	WebElement lastname;
	
	@FindBy(id="postal-code")
	WebElement zip;
	
	@FindBy(id="continue")
	WebElement continuebutton;
	
	@FindBy(xpath="//*[@id=\"cancel\"]")
	WebElement cancelbutton;
	
	@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/span")
	WebElement title;
	
	@FindBy(id="finish")
	WebElement finishbutton;
	
	@FindBy(xpath ="//*[@id=\"checkout_complete_container\"]/h2")
	WebElement successmessage;
	
	@FindBy(id="back-to-products")
	WebElement backhomebutton;
	
	
	public checkoutpage_swag(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void enterfirstname(String fname)
	{
		firstname.sendKeys(fname);
//		
	}
	
	public void enterlastname(String lname)
	{
		lastname.sendKeys(lname);
	}
	public void enterzip(String code)
	{
		zip.sendKeys(code);
	}
	public void continueclick()
	{
		continuebutton.click();
		
	}
	public void finishclick()
	{
		finishbutton.click();
	}
	
	public WebElement checkouttitle()
	{
		return title;
	}
	public WebElement finishverify()
	{
		return finishbutton;
	}
	public WebElement verifysuccessmsg()
	{
		return successmessage;
	}
	public void backhomeclick()
	{
		backhomebutton.click();
	}
}
