package anotherTestPack;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.service.DriverCommandExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.PractiseSite;
import Pages.Register;
import Pages.RegisterPage;
import Pages.ToolsAtSite;

public class VerifyPractiseSiteFunctionality {
	WebDriver driver;
	PractiseSite practiseSite;
	JavascriptExecutor js;
	Register register;
	RegisterPage reg;
	ToolsAtSite toolAtsite;
	@BeforeClass
	public void launchBrowser() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\ftvas\\OneDrive\\Desktop\\selenium practise\\chromedriver_win32 (2)\\chromedriver.exe") ;
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	
	}
   // driver.get("https://demo.automationtesting.in/Index.html");
	
	@BeforeMethod
	public void launchApplication() {
    driver.get("https://demo.automationtesting.in/Register.html"); 
    register=new Register(driver);
    register.clichOnPractiseSiteLink();
	practiseSite=new PractiseSite(driver);
	 driver.switchTo().frame("aswift_2");
		try {
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
	   
		practiseSite.clickOnMyACcount();
		reg=new RegisterPage(driver) ;
		reg.setRegisterPageDetails();
		
		
		}

	
	@Test (priority = 0 ,enabled=true)
	public void verifySeleniumtutorial() {
	//practiseSite=new PractiseSite(driver);
	practiseSite.clickOnAtSite();
	toolAtsite =new ToolsAtSite(driver);
	toolAtsite.seleniumToolInfo();        //element clickintercepted
	String expctedString="Home-Selenium Webdriver Appium Complete Tutorial";
	if(driver.getTitle().equals(expctedString)) {
		System.out.println("Selenium Webdriver Tutorail AS EXpected");
	}
	
	
	} 
	@Test (priority = 0 ,enabled = true)
	public void verifyKatalontutorial() {
	//practiseSite=new PractiseSite(driver);
	practiseSite.clickOnAtSite();
	toolAtsite =new ToolsAtSite(driver);
	toolAtsite.katalonStudioToolInfo();
	String expctedString="Home-Selenium Webdriver Appium Complete Tutorial";
	if(driver.getTitle().equals(expctedString)) {
		System.out.println("Selenium Webdriver Tutorail AS EXpected");
	}
	System.out.println(driver.getTitle());
	}
	
	
	
	
    @AfterMethod
    public void afterMethod()
    {
    	driver.navigate().back();
    	driver.navigate().back();
    	
    }	
    @AfterClass
    public void AfterClass()
    {
    	System.out.println("Afetr class driver is closed:");
    	//driver.close();
    }
	
	
	
	
	
	
	
	
}
