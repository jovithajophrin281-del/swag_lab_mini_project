package pagepkg_swagmini;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage_swag {
	
	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"user-name\"]")
	public WebElement username;
	
	@FindBy(xpath = "//*[@id=\"password\"]")
	public WebElement pass;
	
	@FindBy(id="login-button")
	public WebElement login;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]")
	public WebElement logo;
	
	public loginpage_swag(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement logoverification()
	{
		return logo;
	}
	public void setvalues(String user,String password)
	{
		username.sendKeys(user);
		pass.sendKeys(password);
	}
	public void loginbutton()
	{
		login.click();
	}

}
