package com.hackathon.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.hackathon.utility.BrowserFaxtory;
import com.hackathon.utility.ConfigDataProvider;
import com.hackathon.utility.ExcelDataProvider;
import com.hackathon.utility.Helper;

public class BaseClass {
	BrowserFaxtory bf = new BrowserFaxtory();

	WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite()
	{
		Reporter.log("Inside setupsuite",true);
		excel= new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Hackathon"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("setupsuite completed",true);
		extent.config().setDocumentTitle("Hackathon Automation Test Report");
		extent.config().setReportName("Functional Test Report");
		extent.config().setProtocol(Protocol.HTTPS);
		extent.config().setEncoding("utf-8");
		report.setSystemInfo("Host Name", "Local Host");
		report.setSystemInfo("OS Name", "Windows 10");
		report.setSystemInfo("Environment", "Test-Local");
		report.setSystemInfo("Tester Name", "Sanchari");
	}
	@BeforeClass
	public void setup()
	{
		driver = bf.startApplication(driver,config.getBrowser(),config.getStagingUrl());
	}
	
	@AfterClass
	public void teardown()	
	{
		bf.quitBrowser(driver);
	}
	
	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//logger.log(Status.FAIL,	MarkupHelper.createLabel("Test Case [" + result.getName() + "] is FAILED", ExtentColor.RED));
			logger.fail("Test" + result.getName() +"failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		report.flush();
	}
}
