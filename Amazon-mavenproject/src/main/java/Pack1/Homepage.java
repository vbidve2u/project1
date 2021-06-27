package Pack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="a[@id='nav-link-accountList']")
	private WebElement signIn;
	
	@FindBy(xpath="//a[text()='Amazon Pay']")
	private WebElement amazonPay;
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	public void clickSignIn()
	{
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(signIn)).click();
	}
	
	public void clickAmazonPay()
	{
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(amazonPay)).click();
	}
}

