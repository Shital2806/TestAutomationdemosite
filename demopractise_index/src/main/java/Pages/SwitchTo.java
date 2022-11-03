package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchTo {

	WebDriver driver;
	Actions actions;
	 
	@FindBy(xpath = "//a[text()='SwitchTo']")private WebElement switchTo;

	@FindBy(xpath = "//a[text()='Frames']")private WebElement frames;
	@FindBy(xpath = "//a[text()='Alerts']")private WebElement alerts;
	@FindBy(xpath = "Windows")private WebElement windows;
	@FindBy (xpath = "//div[@id='dismiss-button']") private WebElement closeAdd;
	@FindBy (xpath = "//a[text()='Single Iframe ']") private WebElement singleFrameTab;
	@FindBy (xpath = "//input[@type='text']") private WebElement textOfSingleFrame;

	@FindBy (xpath = "//a[contains(text(),'in an Iframe')]") private WebElement framewithinframeTab;
	  // Or Use //iframe[@src='MultipleFrames.html']
	@FindBy (xpath = "//*[@id=\"Multiple\"]/iframe") private WebElement outerFrame;
	//iframe[@src='SingleFrame.html'] OR Use  /html/body/section/div/div/iframe
	@FindBy (xpath = "/html/body/section/div/div/iframe") private WebElement innerFrame;
	@FindBy (xpath = "//input[@type='text']") private WebElement textOfInnerFrame;


	public SwitchTo(WebDriver driver) {
		PageFactory.initElements(driver, this);


		this.driver=driver; 
		actions=new Actions(driver);
	}

	public void switchToSingleFrame() {
		singleFrameTab.click();
		driver.switchTo().frame("singleframe");
		textOfSingleFrame.sendKeys("...WELCOME SHITAL...");
	}
	public void switchToFrameWithInFrame() {
		framewithinframeTab.click();
	//	driver.switchTo().frame("outerFrame");
		driver.switchTo().frame(outerFrame);
	  //driver.switchTo().frame(0);
		driver.switchTo().frame(innerFrame);
		textOfInnerFrame.sendKeys("...KING-ADHYAY...");
	}
	public void clickOnAdd() throws InterruptedException {
		Thread.sleep(2000);
		closeAdd.click();

	}
	public void clickOnSwitchtoTab() {
		actions.moveToElement(switchTo).moveToElement(frames).click().build().perform();


	}

}


