package config;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class StartBrowser {
 
	public static WebDriver driver;
	//related to reports
	String method;
	ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	
	
	@BeforeTest
	public void report()
	{
		htmlReporter = new ExtentHtmlReporter("Reports/MyReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeMethod
	public void method(Method method)
	{
		parentTest = extent.createTest(method.getName());
	}
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "D:\\Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		//maximize browser
		driver.manage().window().maximize();
		//implicit wait will wait for element for given time
		//	  if the element is available then it will continue to the next command
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		extent.flush();
	}

}
