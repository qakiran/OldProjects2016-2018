package NationalRail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Lib.ScreenShot;

public class LiveDepartures {

WebDriver driver;
	
	@BeforeTest
	public void launchChrome() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.nationalrail.co.uk");
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyTitle(){
		driver.findElement(By.xpath("//*[@href='/service/planjourney/search']")).click();
		driver.findElement(By.xpath("//*[@title='Live departure boards']")).click();
		driver.findElement(By.id("train-from")).clear();
		driver.findElement(By.id("train-from")).sendKeys("London");
		driver.findElement(By.id("train-to")).clear();
		driver.findElement(By.id("train-to")).sendKeys("Birmingham");
		
		driver.findElement(By.id("planJourney")).click();
		
		String Currenttitle=(driver.getTitle());
		Assert.assertEquals(Currenttitle, "Live Departure Boards - National Rail Enquiries");
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
