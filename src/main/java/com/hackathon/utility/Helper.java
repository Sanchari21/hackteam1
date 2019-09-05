package com.hackathon.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;
import java.util.logging.FileHandler;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Helper {
	
	WebDriver driver;
	public static String captureScreenShot(WebDriver driver)
	{
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
		String Screenshotpath=System.getProperty("user.dir")+"/ScreenShots/Hackathon_"+ getCurrentDateTime() +".png";
		try {
			FileUtils.copyFile(src, new File(Screenshotpath));
			System.out.println("Screenshot captured");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
		
		return Screenshotpath;
	}
public static String getCurrentDateTime()
{
	DateFormat customformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	Date currentDate=new Date();
	return customformat.format(currentDate);
}
/*public void MouseHoverFunction(WebElement e) {
	
	try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(waitForElementToBeDisplayed(e,40)){
		String javaScript = "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
				+ "arguments[0].dispatchEvent(evObj);";

		js.executeScript(javaScript, e);

		System.out.println("MouseHoverFunction");
		}
	} catch (Exception ee) {
	}

}*/
/*public boolean waitForElementToBeDisplayed(WebElement element, int timeInSeconds) {
	
	handleUnexpectedDialog(3);
	
	try {
		
		if(element == null)
			return false;
	
		WebDriverWait wait=new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		if (element.isDisplayed()) 
			return true;
		
		return false;
	
	} catch(NoSuchElementException e){
		handleUnexpectedDialog(3);
		Reporter.log("FAIL"+"--No Such Element Exception--", true);
		Reporter.log(ExceptionUtils.getStackTrace(e));
		return false;
		
	} catch (StaleElementReferenceException e) {
		
		handleUnexpectedDialog(3);
		Reporter.log("--Stale Time  Exception ignored--", true);
		return false;
		
	} catch (TimeoutException toe) {
		
		handleUnexpectedDialog(3);
		Reporter.log("FAIL"+"--Time Out Exception--", true);
		Reporter.log(ExceptionUtils.getStackTrace(toe));
		return false;
		
	} catch(Exception e){
		//Catch the exception if it is not caught in the above catches
		handleUnexpectedDialog(3);
		Reporter.log("FAIL"+"--Exception found--", true);
		Reporter.log(ExceptionUtils.getStackTrace(e));
		return false;
	}
}
public void handleUnexpectedDialog(int timeout) {

	WebDriverWait Wait = new WebDriverWait(driver, timeout);

	WebElement element = null;
	try {

		element = Wait
				.until(ExpectedConditions.presenceOfElementLocated(By
						.xpath("//*[@class='fsrCloseBtn' or @id='tcChat_btnCloseChat_img']")));
		if (element != null) {
			if (element.isEnabled()) {
				element.click();
				Reporter.log("Feedback  or chat dialog poped up. Clicked to get rid off");
			}
		}
	} catch (Exception e) {
		// System.out.println("some exception occured dialog  "
		// +e.toString());

	}

}*/


}
