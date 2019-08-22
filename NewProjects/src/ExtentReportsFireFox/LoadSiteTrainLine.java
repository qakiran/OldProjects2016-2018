package ExtentReportsFireFox;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ExtentReports.ExtentManager;

public class LoadSiteTrainLine {

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	
	WebDriver driver;
		
	@BeforeMethod
	public void loadSite(){
		System.setProperty("webdriver.gecko.driver","C:\\Users\\mardarri\\Downloads\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.thetrainline.com");
	}
	
	@Test
	public void confirmTitle(){
		test = rep.startTest("confirmTitle");
		test.log(LogStatus.INFO, "Starting the test");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Trainline | Buy Cheap Train Tickets | Live Train Times & Fares";
		assertEquals(expectedTitle,actualTitle);
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
