package co.rahulShetty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlinAlerts {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ftvas\\OneDrive\\Desktop\\selenium practise\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("//www.rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.getCurrentUrl());

     //   System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        
	}}