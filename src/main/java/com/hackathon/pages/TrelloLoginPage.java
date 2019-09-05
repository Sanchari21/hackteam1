package com.hackathon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class TrelloLoginPage {

	WebDriver driver;
	public TrelloLoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	@FindBy(xpath="//header[@class='fixed-top ']") WebElement landingPageHeader;
	@FindBy(xpath="//a[text()='Log In']") WebElement btnLogin;
	@FindBy(id="user") WebElement txtBoxEmail;
	@FindBy(id="password") WebElement txtBoxPwd;
	@FindBy(xpath="//div[@class='layout-centered-content']") WebElement logOutPage;
	@FindBy(xpath="//div[@class='big-message quiet']/h1[text()='Page not found.']") WebElement headerPageNotFound;
	@FindBy(xpath="//div[@id='login-info']/../h1") WebElement headerLoginPage;
	@FindBy(xpath="//input[@class='button button-green']") WebElement btnLoginSubmit;
	
	public void verifyLandingPage()
	{
		landingPageHeader.isDisplayed();
		Reporter.log("Landing page for Trello.com is displayed",true);
	}
	public void clickLoginOption() throws InterruptedException
	{
		Thread.sleep(5000);
		btnLogin.click();
		Reporter.log("Clicked successfully on login tab",true);
	}
	public void verifyLoginPage()
	{
		headerLoginPage.isDisplayed();
		Reporter.log("Login page for Trello.com is displayed",true);
	}
	public void enterLoginDetailsAndLogin()
	{
		txtBoxEmail.sendKeys("Sanchari.410286@gmail.com");
		txtBoxPwd.sendKeys("hackathon@123");
		btnLoginSubmit.click();
		
	}
}
