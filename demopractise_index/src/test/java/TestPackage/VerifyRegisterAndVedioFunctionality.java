package TestPackage;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Pages.Register;
import Pages.Vedio;
import setup.Base;
import utils.UtilityClass;

public class VerifyRegisterAndVedioFunctionality {
	private WebDriver driver;
	private Register register;
	 private Vedio vd;
	JavascriptExecutor js;	
	SoftAssert soft;
	private int testId;
	
	@Parameters("browser")
	@BeforeTest
	public void launchbrowsers(String browserName) {
		if(browserName.equals("Chrome")) {
			driver=Base.openChromeBrowser();
		}
		if(browserName.equals("Firefox")) {
			driver=Base.openFirefoxBrowser();
		}
		if(browserName.equals("Edge")) {
			driver=Base.openEdgeBrowser();
		}
	//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
		@BeforeClass
		public void createPOMObjects() {
			 register=new Register(driver);
			 vd=new Vedio(driver); 
		}
	   // driver.get("https://demo.automationtesting.in/Index.html");
	//	@Parameters("url")
		@BeforeMethod
//		public void launchApplication(String url) {
//	    driver.get(url); 
	    
		public void launchApplication() {
		    driver.get("https://demo.automationtesting.in/Register.html"); 
	    soft=new SoftAssert();
		}
		@Test (priority = 0,enabled=true)
		public void PersonalInfo() throws InterruptedException, IOException {
		 testId=001;
		register.PersonalInfo();
		register.clickOnFemaleOrMale();
		 js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,500)");
		 register.clickOnHobbies();
		 register.clickOnLanguage1();
		 register.clickOnskills();
		 register.clickncountry1();
		 register.clickOnDay();
		 register.clichOnMonth();
		 register.clichOnYear();
		String pass=UtilityClass.fetchDataFromExcel("AutomationDemoSite",1,5);

		register.clichOnPasswrds(pass);
		
//		String newpass=UtilityClass.fetchDataFromExcel("AutomationDemoSite",1,6);
//		register.clichOnPasswrds(newpass);
		
		}
		
		@Test
		public void verifyYoutubeVedioPlay()
		{
		testId=002;
		vd.clickOnYoutube();
		 driver.switchTo().frame("aswift_2");
			try {
			driver.switchTo().frame("ad_iframe");
			vd.clickOnAdd();
			}catch(NoSuchFrameException fm) {
				System.out.println("No Such Frame Cought:");
			}catch(NoSuchElementException fm) {
				System.out.println("No Such Element Cought:");
			}
			finally{
				driver.switchTo().defaultContent();
				}
			vd.playYoutubeVedio();
		System.out.println("Vedio Played Succssfully...PASS!!");
	//	Assert.assertEquals(driver.getTitle(), "Youtube");
		//if((driver.getTitle().equals("Youtube")))
		System.out.println(" YOutube Vedio PASS");
		Assert.assertEquals(driver.getTitle(), "Youtube");
		}		
		
		
		@AfterMethod
		public void logOutfromApp(ITestResult result) throws IOException{
			
		System.out.println("Scrreshots for failed tast cases:");{
		if(ITestResult.FAILURE==result.getStatus())
		UtilityClass.captureScreenShots(driver,testId);
		}
		driver.navigate().back();
		//TestngListeners=maintains the result or staus of testng methods
		//ITestresult
		//ItestListner
		//ItestReporter
		
		}
		@AfterClass
		public void afterClass(){
		System.out.println("Index Afterclass");
		vd=null;
		register=null;
		}
		@AfterTest
		public void afterTest()
		{   driver.close();
			driver=null;
			System.gc();
			
		}	
	

}

