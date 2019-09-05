package com.hackathon.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFaxtory {
	
	public WebDriver startApplication(WebDriver driver,String browserName,String appUrl)
	{
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sanchari.b\\Desktop\\chromeDrive27thAug\\chromedriver.exe");
			driver=new ChromeDriver();

		}
		
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();

		}
		else if(browserName.equals("IE"))
		{
			
		}
		else
		{
			System.out.println("We do not support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	

}
