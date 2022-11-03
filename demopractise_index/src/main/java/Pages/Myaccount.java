package Pages;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Myaccount {
	WebDriver driver;
	//ad_iframe
	@FindBy (xpath = "//iframe[@name='ad_iframe']")private WebElement frameAdd;
	@FindBy (xpath = "//a[text()='Account Details']']")private WebElement accountDetails;
	@FindBy (xpath = "//a[text()='Orders']")private WebElement orders;
	
	@FindBy (xpath = "//input[contains(@id,'first_name')]")private WebElement firstName;
	@FindBy (xpath = "//input[contains(@id,'last_name')]")private WebElement lastName;
	@FindBy (xpath = "//input[contains(@id,'email')]")private WebElement email;
	@FindBy (xpath = "//input[contains(@id,'password_2')]")private WebElement confmNwPass;
	
	@FindBy (xpath = "(//input[@type='submit'])[1]")private WebElement saveChanges;
	@FindBy (xpath = "(//input[@type='submit'])[2]")private WebElement subscirbeBtn;

	 public Myaccount(WebDriver driver) {
	    	PageFactory.initElements(driver, this);
	    	this.driver=driver;
	    }
	     public void clickOnAccountDetails()
	     {
	    	 accountDetails.click();
	     }    
	     
	     
	     public void setAccountDetails()
	     {
	    	 firstName.sendKeys("shital");
	    	 lastName.sendKeys("gharjale");
	    	 email.sendKeys("gharjaleshiatl2806@gmail.com");
	    	 confmNwPass.sendKeys("Shital@123");
	    	 saveChanges.click();
	    	 
	     } 
	     
	    
	
	
	
	
	
	
	
	
	
	
}
