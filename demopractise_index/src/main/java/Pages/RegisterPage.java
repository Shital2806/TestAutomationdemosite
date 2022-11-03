package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	@FindBy (xpath = "(//input[@type='email'])[1]")private WebElement emailId;
	@FindBy (xpath = "(//input[@type='password'])[2]")private WebElement password;
	
	@FindBy (xpath = "//input[@name='register']")private WebElement register;
	
	@FindBy (xpath = "//li[contains(text(),'An account is al')]")private WebElement errorText;

	 public  RegisterPage(WebDriver driver) {
	    	PageFactory.initElements(driver, this);
	    	this.driver=driver;
	    }
	       
	     
	  public void setRegisterPageDetails() throws InterruptedException
	     {
	    	
	    	 emailId.sendKeys("gharjaleshiatl2806@gmail.com");
	    	 password.sendKeys("Shital@123");
	    	 Thread.sleep(1000);
	    	 register.click();
	    	// System.out.println(errorText.getText());
	    		
	     } 
	     
	 
	     
	    
	
}
