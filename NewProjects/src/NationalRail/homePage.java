package NationalRail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Lib.ScreenShot;

public class homePage {

	WebDriver driver;
	
	@BeforeTest
	public void launchChrome() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.nationalrail.co.uk");
//		Thread.sleep(3000);
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyTitle(){
		String Currenturl=(driver.getTitle());
		Assert.assertEquals(Currenturl, "National Rail Enquiries - Official source for UK train times and timetables");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	
		if(ITestResult.FAILURE==result.getStatus())
		{
			ScreenShot.captureScreenShot(driver, result.getName());
			
			
		}
		
		driver.quit();

	}
		
}
