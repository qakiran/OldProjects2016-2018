package ExtentReportsFireFox;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ExtentReports.ExtentManager;

public class SkyScannerTitleFail {

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	
	WebDriver driver;
		
	@BeforeTest
	public void loadSite(){
		System.setProperty("webdriver.gecko.driver","C:\\Users\\mardarri\\Downloads\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.skyscanner.net");
	}
	
//	@Test(priority=1)
//	public void confirmTitle(){
//		String actualTitle = driver.getTitle();
//		String expectedTitle = "Skyscanner - Compare Cheap Flights, Hotels & Car Hireee";
//		assertEquals(expectedTitle,actualTitle);
//	}
	
	@Test(priority=2)
	public void confirmTitlee(){
		test = rep.startTest("confirmTitlee");
		test.log(LogStatus.INFO, "Starting the test");
		assertTrue(driver.getTitle().contains("Skyscanner - Compare Cheap Flights, Hotels & Car Hiree"));
		test.log(LogStatus.PASS, "Test Passed");
	}
	
	@AfterTest
	public void quit(){
		driver.quit();
	}
	
	@AfterMethod
	public void quitReport(){
		rep.endTest(test);
		rep.flush();
	}
	
	
}
