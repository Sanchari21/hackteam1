package com.hackathon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class TrelloBoardPage {
	
	WebDriver driver;
	public TrelloBoardPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	@FindBy(xpath="//div[@class='boards-page-board-section-header']") WebElement pageHeader;
	@FindBy(xpath="//span[text()='Create new board']") WebElement createBoardoption;
	
	public void verifyBoardPage()
	{
		pageHeader.isDisplayed();
		Reporter.log("Board page for Trello.com is displayed",true);
	}
}
