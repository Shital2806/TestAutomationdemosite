package TestPackage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.SwitchTo;
import setup.Base;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class VerifyFramesFunctionalityTestNg {
	private WebDriver driver;
	//private Register register;
	private SwitchTo switchTo ;
	JavascriptExecutor js;
	 SoftAssert softAssert;
	 
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
		
		}


	@Test
	public void verifySingleFrameFubctionality()
	{
        switchTo.switchToSingleFrame();
		System.out.println("Entered Text Inside Single Frame...PASS!!");
		String title=driver.getTitle();
		String url=driver.getCurrentUrl();
	//	Assert.assertEquals(title,"Frames");
	   //Assert.assertEquals(title,"Frams");
   
	//	Assert.assertEquals(url,"https://demo.automationtesting.in/Frames.html" );
		boolean result=title.equals("Frames")&&url.equals("https://demo.automationtesting.in/Frames.html");
		Assert.assertTrue(result);
		System.out.println(driver.getTitle());

	}
	
	@BeforeMethod
//	public void launchApplication(String url) {
//		
//		driver.get(url); 
		public void launchApplication() throws InterruptedException {
		    driver.get("https://demo.automationtesting.in/Register.html"); 
		// softAssert=new SoftAssert();

		  //switchTo=new SwitchTo(driver);
		  switchTo.clickOnSwitchtoTab();
			driver.switchTo().frame("aswift_2");
			try {
				driver.switchTo().frame("ad_iframe");
				switchTo.clickOnAdd();
			}catch(NoSuchFrameException fm) {
				System.out.println("No Such Frame Cought:");
			}catch(NoSuchElementException fm) {
				System.out.println("No Such Element Cought:");
			}


			finally{
				driver.switchTo().defaultContent();	
			}
	     
	}
	@AfterMethod
	public void afterMethod(){
		System.out.println("Index AfterMethod");
		driver.navigate().back();

	}

	@BeforeClass

	public void createPOMObjects() {
		 softAssert=new SoftAssert();

		  switchTo=new SwitchTo(driver);	
	}


	@AfterClass
	public void afterClass(){
		System.out.println("Index Afterclass");
		//driver.close();
	}
	
     @Test //(dependsOnMethods = {"verifySingleFrameFubctionality"})
     public void verifyMutipleFramesFunctionality()
     {
    	 System.out.println("Multipe Or inner frames demo");
    	 switchTo.switchToFrameWithInFrame();
    	 String title=driver.getTitle();
 		 String url=driver.getCurrentUrl();
 		 System.out.println(driver.getTitle());
 		softAssert.assertEquals(title,"Frams");
 		 
    	// Assert.fail();
 		// softAssert.assertEquals(title, "Frames");
 		 
    	 System.out.println("After Assert.fail(Hard Assert)..");
    	
     }
     @AfterClass
     public void clearObjects()
     {
    	 softAssert=null;
    	 switchTo=null;
     }   
     @AfterTest
     public void closeBrowser() {
    	 driver.close();
    	 driver=null;
     }


}
