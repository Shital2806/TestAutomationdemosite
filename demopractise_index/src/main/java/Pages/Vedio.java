package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vedio {

	private WebDriver driver;
	private Actions actions;

	@FindBy(xpath = "//a[text()='Video']")private WebElement vedio;
	@FindBy(xpath = "//a[text()='Youtube']")private WebElement youtube;
	@FindBy(xpath = "//iframe[@width='720']")private WebElement youtubeframe;

	@FindBy(xpath = "//div[@aria-label='YouTube Video Player']")private WebElement youtubevedioPlayer;

	@FindBy(xpath = "//button[@aria-label='Play']")private WebElement youtubPlayBtn2;

	@FindBy(xpath = "//button[contains(@class,'ytp-large-play')]")private WebElement youtubPlayBtn3;

	@FindBy(xpath = "//button[@title='Play (k)']")private WebElement youtubPlayBtn1;
	@FindBy (xpath = "//div[@id='dismiss-button']") private WebElement closeAdd;

	public Vedio(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		actions=new Actions(driver);
	}
   public void clickOnYoutube() {
		actions.moveToElement(vedio).moveToElement(youtube).click().build().perform();


	}
	public void playYoutubeVedio() {
		driver.switchTo().frame(youtubeframe);
		youtubPlayBtn3.click();

	}
   public void clickOnAdd() {
		closeAdd.click();

	}











}
