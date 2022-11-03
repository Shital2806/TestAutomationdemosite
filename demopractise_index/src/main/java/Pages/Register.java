package Pages;

import java.io.IOException;
import java.util.List;

import javax.swing.JScrollBar;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.record.chart.SeriesChartGroupIndexRecord;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.UtilityClass;

public class Register {

	private WebDriver driver;
	//private Select sk;
	
	@FindBy(xpath = "//a[text()='Interactions ']")
	private WebElement interactons;

	@FindBy(xpath = "//a[text()='Practice Site']")
	private WebElement practiseSiteLink;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	private WebElement lastName;

	@FindBy(xpath = "//textarea[@ng-model='Adress']")
	private WebElement adress;


	@FindBy(xpath = "//input[@type='email']")
	private WebElement email;

	@FindBy(xpath = "//input[@type='tel']")
	private WebElement mobNo;

	@FindBy(xpath = "(//input[@type='radio'])[2]")
	private WebElement female;

	@FindBy(xpath = "(//input[@type='radio'])[1]")
	private WebElement male;

	@FindBy(xpath = "(//div[@class='form-group'])[6]//div[1]")
	private WebElement hobbiesChekbox;


	@FindBy(xpath = "//input[@type='checkbox']")   //All Three selected
	private List<WebElement> hobbiesChekbox2;

	@FindBy(xpath = "(//input[@id='checkbox3']")
	private WebElement hocky;

	@FindBy(xpath = "//div[@id='msdd']")
	private WebElement languagesChekbox;   //for click operation

	@FindBy(xpath = "//li/a[@class='ui-corner-all']")       //all laungauges
	private List<WebElement> allLaunges;

	@FindBy (xpath = "//a[text()='Arabic']")
	private WebElement arabic;

	@FindBy (xpath = "//select[@id='country']")
	private WebElement country;

	@FindBy (xpath = "//select[@id='Skills']")
	private WebElement skills;

	@FindBy (xpath = "(//select[@type='text'])[3]")
	private WebElement yearbox;

	@FindBy (xpath = "(//select[@type='text'])[4]")
	private WebElement month;

	@FindBy (xpath = "(//select[@type='text'])[5]")
	private WebElement day;

	@FindBy (xpath = " //input[@id='firstpassword']")
	private WebElement firstpassword;

	@FindBy (xpath = "//input[@id='secondpassword']")
	private WebElement secondpasword;


	@FindBy (xpath = "//button[@id='submitbtn']")
	private WebElement submitButton;



	@FindBy (xpath = "//li[@class='select2-results__option']")
	private List<WebElement> countries;

	public Register(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;

	}
	public void PersonalInfo() throws EncryptedDocumentException, IOException {
		//firstName.sendKeys("shital");
		String name=UtilityClass.fetchDataFromExcel("AutomationDemoSite",1,0);
		firstName.sendKeys(name);
		//lastName.sendKeys("gharjale");
		String surname=UtilityClass.fetchDataFromExcel("AutomationDemoSite",1,1);
		lastName.sendKeys(surname);
		String emailId=UtilityClass.fetchDataFromExcel("AutomationDemoSite",1,3);
		//email.sendKeys("gharjaleshiatl2806@gmail.com");
		email.sendKeys(emailId);
		String addr=UtilityClass.fetchDataFromExcel("AutomationDemoSite",1,2);
        adress.sendKeys(addr);
		String mobileNo=UtilityClass.fetchDataFromExcel("AutomationDemoSite",1,4);
        mobNo.sendKeys(mobileNo);
	}
	public void clickOnFemaleOrMale() {
		if(female.getAttribute("value").equals("FeMale")){
			female.click();}
		else
			male.click();
	}
	public void clickOnHobbies() {
		System.out.println(hobbiesChekbox2.size());

		for (WebElement hobby : hobbiesChekbox2) {
			String checkbox=hobby.getAttribute("value");
			if(checkbox.equals("Movies")||checkbox.equals("Cricket")||checkbox.equals("Hockey")) {
				hobby.click();	
			}
		}
	}
	public void clickOnLanguage1() throws InterruptedException {
		//  arabic.click();
		languagesChekbox.click();     // Series click
		System.out.println(allLaunges.size());
		Thread.sleep(2000);
		for (WebElement launges : allLaunges) {
			String lang=launges.getText();
			if(lang.equals("English")||lang.equals("Hindi")) {
				launges.click();  
			}
		}
	}
	public void clickOnskills(){

		selectMultipleDropDown(skills,"Adobe Photoshop");
	}
	public void clickncountry1(){
		selectMultipleDropDown(country,"India");
	}
	public void clickOnDay(){
		selectMultipleDropDown(day,"28");	 
	}

	public void clichOnMonth(){
		selectMultipleDropDown( month,"January");
	}
	public void clichOnYear(){
		selectMultipleDropDown(yearbox,"1994"); 
	}

	public static void selectMultipleDropDown(WebElement ele,String value) {

		Select  sk=new Select(ele);
		List<WebElement>dropvalue=sk.getOptions();

		for(WebElement wb:dropvalue) {
			if(wb.getText().equals(value)) {
				wb.click();
				break;
			}
		}
	}
	public String clichOnPasswrds(String password) {
		firstpassword.sendKeys(password);
		secondpasword.sendKeys(password);
		submitButton.click();
		return password;
	}
	 public void clichOnPractiseSiteLink() {

	 		practiseSiteLink.click();
	 	}


}