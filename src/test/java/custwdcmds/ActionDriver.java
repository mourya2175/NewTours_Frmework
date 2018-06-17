package custwdcmds;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.StartBrowser;

public class ActionDriver {
	
	public WebDriver driver;
	
	public ActionDriver()
	{
		driver = StartBrowser.driver;
	}
	
	/**
	 * used for launching application
	 * @param url --Application URl
	 * @throws Exception 
	 */
	public void launchApplication(String url) throws Exception
	{
		try {
			driver.get(url);
			StartBrowser.childTest.pass("Navigated successfully to :"+url);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to Navigate to Application URL: "+url);
			throw e;
		}
		
	}
	/**
	 * used to type in text box
	 * @param locator  --Get it from Object Repository
	 * @param data -- what text you want to enter
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void type(By locator, String data, String eleName) throws IOException, Exception
	{
		try {
			driver.findElement(locator).sendKeys(data);
			StartBrowser.childTest.pass("Successfully typed in "+eleName + "with Data :"+data);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unablt to type in "+eleName + "with Data :"+data + StartBrowser.childTest.addScreenCaptureFromPath(screenshot(driver)));
			throw e;
		}
		
	}
	/**
	 * used to perform click on radio, chk, link and buttons
	 * @param locator --get it from OR
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void click(By locator, String eleName) throws IOException, Exception
	{
		try {
			driver.findElement(locator).click();
			StartBrowser.childTest.pass("Successfully clicked Element "+eleName);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to click element "+eleName + StartBrowser.childTest.addScreenCaptureFromPath(screenshot(driver)));
			throw e;
		}
		
	}
	/**
	 * to perform mouse hover on an element
	 * @param locator
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void mouseHover(By locator, String eleName) throws IOException, Exception
	{
		try {
			WebElement mo=driver.findElement(locator);
			Actions a = new Actions(driver);
			a.moveToElement(mo).perform();
			StartBrowser.childTest.pass("Successfully MouseHover on Element "+eleName);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to  MouseHover on Element "+eleName + StartBrowser.childTest.addScreenCaptureFromPath(screenshot(driver)));
			throw e;
		}
		
	}
	
	public void waituntilText(By locator, String text) throws IOException, Exception
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
			StartBrowser.childTest.pass("Successfully waitd for text" +text);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Text is not visible: "+text + StartBrowser.childTest.addScreenCaptureFromPath(screenshot(driver)));
			throw e;
		}
		
	}
	/**
	 * Select Drop down by visible text
	 * @param locator --get it from OR
	 * @param text ----visible Text
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void selectByVisibleText(By locator, String vtext, String text) throws IOException, Exception
	{
		try {
			WebElement dd=driver.findElement(locator);
			Select s = new Select(dd);
			s.selectByVisibleText(vtext);
			StartBrowser.childTest.pass("Selected value from DD : "+text);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to select value from DD :"+text + StartBrowser.childTest.addScreenCaptureFromPath(screenshot(driver)));
			throw e;
		}
		
	}
	
	public String screenshot(WebDriver driver) throws Exception
	{
		String src_path="/SShot/";
		UUID uuid = UUID.randomUUID();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(src_path+uuid+".jpeg"));
		}
		catch(Exception e)
		{
			System.out.println("Unable tp capture screenshot");
		}
		return src_path+uuid+".jpeg";
	}

}
