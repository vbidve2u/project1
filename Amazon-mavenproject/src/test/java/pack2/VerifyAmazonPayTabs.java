package pack2;


	import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pack1.Homepage;
import Pack1.Loginpage;

	public class VerifyAmazonPayTabs {
		
		private WebDriver driver;
		private amazonPay apay;
		private Homepage home;
		private SoftAssert soft;
		private Utilities1 utility;
		
		
		
		
		@BeforeTest
		public void openBrowser()
		{

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DEX\\Desktop\\Selenium Files\\chromedriver.exe");

			WebDriver driver =new ChromeDriver();
			
			driver.get("https://www.amazon.in/");
//			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Welcome To amazon");
			home=new Homepage(driver);
			home.clickSignIn();
			 soft = new SoftAssert();
		
			 
		}
		@BeforeMethod
		public void beforeMethod() 
		{
			Loginpage login = new Loginpage(driver);
			login.enterEmail();
			login.clickContinue();
			login.enterPassword();
			login.clickSignIn();
			System.out.println("Log in successfull");
			home.clickAmazonPay();
			aPay = new AmazonPay(driver);
		}
		
		@Test
		public void verifyMobileRecharge() throws EncryptedDocumentException, IOException
		{
			aPay.clickMobileRecharge();
			String url = driver.getCurrentUrl();
			
			MobileRechargePage mPay = new  MobileRechargePage(driver);
			soft.assertEquals(url, "https://www.amazon.in/hfc/mobileRecharge?ref_=apay_deskhome_MobileRecharge");
			
			soft.assertFalse(mPay.enterMobileNo(), "The Mobile enter field is Displayed");
//			soft.assertTrue(mPay.selectCircle(), "The select Mobile circle field is Displayed");
//			soft.fail();
			soft.assertAll();
		}
		@Test //(enabled =false)
		public void verifyDTH() 
		{
			aPay.clickDTH();
			
			String url = driver.getCurrentUrl();
			
			soft.assertEquals(url, "https://www.amazon.in/hfc/dth?ref_=apay_deskhome_DTH" ); 
			
			soft.assertAll();	
		}
		
		@AfterMethod
		public void signOut() throws IOException
		{
			utility.takeScreenshot(driver);
			aPay.clickDownArrow();
			aPay.clickSignOut();
			System.out.println("Thank you");
		}
		
		@AfterClass
		public void afterClass()
		{
		}
		
//		@AfterTest
//		public void closeBrowser()
//		{
//		driver.close();	
//		}
		
		
		@Test (enabled =false)
		public void verifyPostpaid()
		{
			aPay.clickPostpaid();
			
			String url = driver.getCurrentUrl();
			soft.assertEquals(url, "https://www.amazon.in/hfc/bill/mobile_postpaid?ref_" );
			soft.fail();
		}
		
		@Test(enabled =false)
		public void verifyElectricity()
		{
			aPay.clickElectricity();
			
			String url = driver.getCurrentUrl();
			soft.assertEquals(url, "https://www.amazon.in/hfc/bill/electrice_Electricity" );
		}
		
		@Test  (enabled =false)
		public void verifyInsurance()
		{
			aPay.clickInsurance();
			
			String url = driver.getCurrentUrl();
			soft.assertEquals(url, "https://www.amazon.in/hfc/bill/insome_Insurance");
		}
		
		@Test  (enabled =false)
		public void verifyGasCylinder()
		{
			aPay.clickCylinder();
			
			String url = driver.getCurrentUrl();
			soft.assertEquals(url, "https://www.amazon.in/hfc/bill/lpg?re");
			
		}
		
//		@AfterSuite
//		public void afterSuite()
//		{
//			
//		}
		
		
		

	
	}


