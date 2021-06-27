package Pack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazonpay {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//span[text()='Mobile Recharge']")
	private WebElement mobile;
	
	@FindBy(xpath="//span[text()='Electricity']")
	private WebElement electricity;
	
	@FindBy(xpath="//span[text()='DTH Recharge']")
	private WebElement dth;
	
	@FindBy(xpath="//span[text()='Mobile Postpaid']")
	private WebElement postpaid;
	
	@FindBy(xpath="//span[text()='Gas Cylinder']")
	private WebElement gasCylinder;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	private WebElement signout;
	
	public Amazonpay(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickMobileRecharge()
	{
		mobile.click();
	}
	public void clickElectricity()
	{
		electricity.click();
	}
	public void clickDTH()
	{
		dth.click();
	}
	public void clickPostpaid()
	{
		postpaid.click();
	}
	
	public void clickCylinder()
	{
		gasCylinder.click();
	}
	public void clickSignOut()
	{
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(signout)).click();
	}
	
	
	
}
