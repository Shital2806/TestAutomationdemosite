package TestPackage;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.service.DriverCommandExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.PractiseSite;
import Pages.Register;
import Pages.RegisterPage;
import Pages.ToolsAtSite;
import Pages.Vedio;
import setup.Base;
import utils.UtilityClass;

public class VerifyPractiseSiteFunctionality {
	WebDriver driver;
	PractiseSite practiseSite;
	JavascriptExecutor js;
	Register register;
	RegisterPage reg;
	ToolsAtSite toolAtsite;
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
	}
	@BeforeClass
	public void createPOMObjects() {
		 register=new Register(driver);
		 practiseSite=new PractiseSite(driver);
		 reg=new RegisterPage(driver) ;
		 toolAtsite =new ToolsAtSite(driver);
	}
	
 // @Parameters("url")
	@BeforeMethod
//	public void launchApplication(String url) {
//    driver.get(url); 
    public void launchApplication() {
	    driver.get("https://demo.automationtesting.in/Register.html"); 
    register.clichOnPractiseSiteLink();
   
		try {
		 driver.switchTo().frame("aswift_2");
		driver.switchTo().frame("ad_iframe");
		practiseSite.clickAdd();
		}catch(NoSuchFrameException fm) {
			System.out.println("No Such Frame Cought:");
		}catch(NoSuchElementException fm) {
			System.out.println("No Such Element Cought:");
		}
		finally{
			driver.switchTo().defaultContent();	
		}
    }
	
	@Test (priority = 0,enabled = false)
	public void verifymyAccount() throws InterruptedException {
	//practiseSite=new PractiseSite(driver);
		testId=005;
	   
		practiseSite.clickOnMyACcount();
		
		reg.setRegisterPageDetails();
		}

	
	@Test (priority = 0 ,enabled=true)
	public void verifySeleniumtutorial() {
		testId=004;
	//practiseSite=new PractiseSite(driver);
	practiseSite.clickOnAtSite();
	//toolAtsite =new ToolsAtSite(driver);
	toolAtsite.seleniumToolInfo();        //element clickintercepted
	String expctedString="Home-Selenium Webdriver Appium Complete Tutorial";
	if(driver.getTitle().equals(expctedString)) {
		System.out.println("Selenium Webdriver Tutorail AS EXpected");
	}
    } 
	@Test (priority = 0 ,enabled = true)
	public void verifyKatalontutorial() {
	//practiseSite=new PractiseSite(driver);
		testId=003;
		
    practiseSite.clickOnAtSite();
	//toolAtsite =new ToolsAtSite(driver);
	toolAtsite.katalonStudioToolInfo();
	String expctedString="Home-Selenium Webdriver Appium Complete Tutorial";
	if(driver.getTitle().equals(expctedString)) {
		System.out.println("Selenium Webdriver Tutorail AS EXpected");
	}
	System.out.println(driver.getTitle());
	}
	
	@AfterMethod
   
   public void logOutfromApp(ITestResult result) throws IOException {
			
			System.out.println("Scrreshots for failed tast cases:");{
			if(ITestResult.FAILURE==result.getStatus())
			UtilityClass.captureScreenShots(driver,testId);
			}
			
		
    	driver.navigate().back();
    	driver.navigate().back();
    	
    }	
	@AfterClass
	public void clearObjects()
	{
		register=null;
		 practiseSite=null;
		 reg=null;
		 toolAtsite =null;
	}	
    @AfterTest
    public void AfterClass()
    {
    	System.out.println("Afetr class driver is closed:");
    	driver.close();
    	driver=null;
    	System.gc();
    }
	
}
