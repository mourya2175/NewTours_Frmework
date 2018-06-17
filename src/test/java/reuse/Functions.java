package reuse;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import config.StartBrowser;
import custwdcmds.ActionDriver;
import or.Businesspage;
import or.HomePage;
import or.LoginPage;
import or.MyAccountPage;
import or.NewFlights;
import or.NewLoginPage;

public class Functions {
	
	public WebDriver driver;
	public ActionDriver aDriver;
	
	public Functions()
	{
		driver = StartBrowser.driver;
		aDriver = new ActionDriver();
	}
	
	/*public void clickSignIn()
	{
		aDriver.launchApplication("https://www.costco.com/");
		aDriver.click(HomePage.lnkSignIn);
	}

	public void login()
	{
		aDriver.type(LoginPage.txtEmail, "dnr5dnr@gmail.com");
		aDriver.type(LoginPage.txtPassword, "selenium123");
		aDriver.click(LoginPage.btnSignIn);
	}
	
	public void logout()
	{
		aDriver.mouseHover(MyAccountPage.lnkMyAccount);
		aDriver.click(MyAccountPage.btnSignOut);
	}
	
	public void navigateToShopBusiness()
	{
		aDriver.launchApplication("https://www.costco.com/");
		aDriver.mouseHover(HomePage.lnkBusinessDelivery);
		aDriver.click(HomePage.lnkShopBusiness);
	}
	
	public void clickJuices()
	{
		aDriver.click(Businesspage.lnkJuices);
		aDriver.click(Businesspage.lnkProduct);
		aDriver.type(Businesspage.txtZipCode, "21058");
	}*/
	
	public void newLogin() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to New Tours Application");
		aDriver.launchApplication("http://newtours.demoaut.com/mercurysignon.php");
		aDriver.type(NewLoginPage.txtUserName, "dnr5dnr","UserName");
		aDriver.type(NewLoginPage.txtPassword, "Testing@1234","Password");
		aDriver.click(NewLoginPage.btnSubmit, "Submit");
	}
	
	public void newLogin(String uName, String password) throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to New Tours Application");
		aDriver.launchApplication("http://newtours.demoaut.com/mercurysignon.php");
		aDriver.type(NewLoginPage.txtUserName, uName,"UserName");
		aDriver.type(NewLoginPage.txtPassword, password,"Password");
		aDriver.click(NewLoginPage.btnSubmit, "Submit");
	}
	
	public void newFlights() throws IOException, Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Search for Flights");
		aDriver.selectByVisibleText(NewFlights.ddPassenger, "3","Passenger");
		aDriver.selectByVisibleText(NewFlights.ddDepart, "London","Depart");
		aDriver.click(NewFlights.rbBusiness,"Business");
		aDriver.click(NewFlights.btnContinue,"Continue");
		
	}
	
	public void newLogOff() throws IOException, Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Log off from application");
		aDriver.click(NewLoginPage.lnkLogOff,"Sign Off");
	}
}
