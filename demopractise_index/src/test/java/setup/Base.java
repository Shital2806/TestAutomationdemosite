package setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	//CODE IS DELETED FROM REPOSITORY
	//some of the code modified
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ftvas\\OneDrive\\Desktop\\selenium practise\\chromedriver_win32 (2)\\chromedriver.exe") ;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver;
    }
	 public static WebDriver openFirefoxBrowser() {
			System.setProperty("webdriver.gecko.driver","E:\\selenium practise\\geckodriver-v0.32.0-win32\\geckodriver.exe") ;
			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			return driver;
	    }
	   public static WebDriver openEdgeBrowser() {
			System.setProperty("webdriver.edge.driver","E:\\selenium practise\\edgedriver_win64 (1)\\msedgedriver.exe") ;
            WebDriver driver=new EdgeDriver();
            driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
	   
	   }


}
