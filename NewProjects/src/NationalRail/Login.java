package NationalRail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Lib.ScreenShot;

public class Login {

WebDriver driver;
	
	@BeforeTest
	public void launchChrome() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\mardarri\\Downloads\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.nationalrail.co.uk");
//		driver.manage().window().maximize();
	}
	
	@Test
	public void login(){
//		WebDriverWait wait = new WebDriverWait(driver, 40);
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("txtFrom")));	
		
		driver.switchTo().frame("omnibarDD");
//		driver.findElement(By.xpath("//*[@class='acc clear']")).click();
		driver.findElement(By.xpath("//a[@href='/personal/login/login']")).click();

		driver.switchTo().defaultContent();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("signinEmail")));
		
		driver.findElement(By.id("signinEmail")).clear();
		driver.findElement(By.id("signinEmail")).sendKeys("name@hotmail.com");
		
		driver.findElement(By.id("signinPword")).clear();
		driver.findElement(By.id("signinPword")).sendKeys("12345");
		
		driver.findElement(By.id("loginNow")).click();
		
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains("This email address or password has not been recognised"));
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
