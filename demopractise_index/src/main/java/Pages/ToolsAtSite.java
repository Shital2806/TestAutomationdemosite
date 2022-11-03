package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolsAtSite {
@FindBy (xpath="//a/span[text()='Selenium']")
	private WebElement selenium;

@FindBy (xpath="//span[contains(text(),'is a tool')]")
private WebElement seleniumText;

@FindBy (xpath="//a/span[text()='Katalon Studio']")
private WebElement katalonStudio;	

@FindBy (xpath="//span[contains(text(),'is a free and ')]")
private WebElement katalonText;
	
	public ToolsAtSite(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void seleniumToolInfo() {
		selenium.click();
		System.out.println(seleniumText.getText());
	}
	
	public void katalonStudioToolInfo() {
		katalonStudio.click();
		System.out.println(katalonText.getText());

	}
	
	
	
}
