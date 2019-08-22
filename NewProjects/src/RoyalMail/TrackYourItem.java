package RoyalMail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Lib.ScreenShot;

public class TrackYourItem {
	
	SoftAssert softAssert = new SoftAssert();
	WebDriver driver;

	@BeforeMethod
	public void launchChrome()
	{
		//Launch Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.royalmail.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void tracking() throws InterruptedException{
		//click track your item button
		driver.findElement(By.xpath("//li[@class='track']/a")).click();
		
		//Assert title
		String one = driver.findElement(By.tagName("body")).getText();
		softAssert.assertTrue(one.contains("Track and Trace - Track your Item | Royal Mail Ltd"));
//		System.out.println("Title is correct");
//		System.out.println("Title is wrong");
		
		//Switch to frame
//		driver.switchTo().frame("tracking-code-form");
		
		//enter tracking number
		driver.findElement(By.xpath("//*[@name='trackingNumber']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name='trackingNumber']")).sendKeys("AAAAAAAAAABBBBBBBB");
		
		//Switch to default content
//		driver.switchTo().defaultContent();
		
		//Click track button
		driver.findElement(By.xpath("//span[@class='track-bt-text ng-binding']")).click();
		
		//Verify error message
		String two = driver.findElement(By.xpath("//div[@class='track-errors']")).getText();
		System.out.println(two);
		
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