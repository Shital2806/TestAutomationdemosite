package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PractiseSite {
    @FindBy (xpath = "//div[@id='dismiss-button']") private WebElement closeAdd;

    @FindBy (xpath = "//a[text()='My Account']") private WebElement myAccont;
    @FindBy (xpath = "//a[text()='Shop']") private WebElement shop;
    @FindBy (xpath = "//a[text()='AT Site']") private WebElement atSite;

//    @FindBy (xpath = "//a[text()='My Account']") private WebElement myAccont;
//
//    @FindBy (xpath = "//a[text()='My Account']") private WebElement myAccont;
//
//    @FindBy (xpath = "//a[text()='My Account']") private WebElement myAccont;

   
     public PractiseSite(WebDriver driver) {
    	 PageFactory.initElements(driver, this);
	}
	public void clickOnMyACcount()
     {
    	 myAccont.click();
     }    
     public void clickOnMyShop()
     {
    	 shop.click();
     } 
     public void clickOnAtSite()
     {
    	 atSite.click();
    	 
    	 
     } 
   
     public void clickAdd()
     {
    	 closeAdd.click();
     }
    
    
}
