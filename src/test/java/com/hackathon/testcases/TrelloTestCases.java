package com.hackathon.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.hackathon.pages.TrelloBoardPage;
import com.hackathon.pages.TrelloLoginPage;

public class TrelloTestCases extends BaseClass {

	@Test
	public void loginValidation() throws InterruptedException
	{
		logger=report.createTest("Login Scenario Validation");
		TrelloLoginPage Loginpage=PageFactory.initElements(driver, TrelloLoginPage.class);
	    logger.info("Starting application");
	Thread.sleep(4000);
	Loginpage.verifyLandingPage();
	logger.pass("Trello Landing page loaded successfully");
	Loginpage.clickLoginOption();
	logger.info("Clicked on login button");
	Loginpage.verifyLoginPage();
	logger.pass("Trello login page loaded successfully");
	Loginpage.enterLoginDetailsAndLogin();
	logger.info("Id and password is passed and login button is clicked on the Trello login modal");
	TrelloBoardPage boardPage=PageFactory.initElements(driver, TrelloBoardPage.class);
	boardPage.verifyBoardPage();
	logger.pass("User logged in and board page loaded successfully");
}
}
