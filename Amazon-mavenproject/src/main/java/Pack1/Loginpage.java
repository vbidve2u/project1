package Pack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	@FindBy (xpath="//input[@id='username']")
	private WebElement userId;
		
	@FindBy (xpath="(//input[@type='password'])[1]")
	private WebElement password;
	
	@FindBy (xpath="//div[text()='Login ']")
	private WebElement login;
	
	public void LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String u)
	{
		userId.sendKeys(u);
	}
	
	public void enterPassword(String p)
	{
		password.sendKeys(p);
	}
	
	public void clickLogin()
	{
		login.click();
	}
}
