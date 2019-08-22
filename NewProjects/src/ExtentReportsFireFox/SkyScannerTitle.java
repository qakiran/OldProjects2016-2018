package ExtentReportsFireFox;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ExtentReports.ExtentManager;

public class SkyScannerTitle {

	WebDriver driver;
			
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	
	@BeforeTest
	public void loadSite(){
		System.setProperty("webdriver.gecko.driver","C:\\Users\\mardarri\\Downloads\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.skyscanner.net");
	}
	
	@Test(priority=1)
	public void confirmTitle(){
		test = rep.startTest("confirmTitle");
		test.log(LogStatus.INFO, "Starting the test");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Skyscanner - Compare Cheap Flights, Hotels & Car Hire";
		assertEquals(expectedTitle,actualTitle);
		test.log(LogStatus.PASS, "Test Passed");
	}
	
	@Test(priority=2)
	public void confirmTitlee(){
		test = rep.startTest("confirmTitlee");
		test.log(LogStatus.INFO, "Starting the test");
		assertTrue(driver.getTitle().contains("Skyscanner - Compare Cheap Flights, Hotels & Car Hire"));
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
