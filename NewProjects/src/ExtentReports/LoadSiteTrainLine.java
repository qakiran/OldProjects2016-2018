package ExtentReports;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ExtentReports.ExtentManager;
import junit.framework.Assert;

public class LoadSiteTrainLine {

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	SoftAssert softAssert = new SoftAssert();
	WebDriver driver;
		
	@BeforeMethod
	public void loadSite(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://www.thetrainline.com");
	}
	
	@Test
	public void confirmTitle(){
		test = rep.startTest("confirmTitle");
		test.log(LogStatus.INFO, "Starting the test");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Trainline | Buy Cheap Train Tickets | Live Train Times & Fares";
		softAssert.assertEquals(expectedTitle,actualTitle);
		test.log(LogStatus.INFO, "comparing the title");
		
		try{
			softAssert.assertAll();
			test.log(LogStatus.PASS, "Test Passed");
		}catch(Throwable t){
			test.log(LogStatus.FAIL, "Test Failed"+t.getMessage());
			Assert.fail(t.getMessage());
		}
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
