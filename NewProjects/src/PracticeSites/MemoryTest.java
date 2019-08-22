package PracticeSites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//*Author - Marc Darrie 04.08.17

public class MemoryTest {

	WebDriver driver;
	
	@BeforeMethod
	public void Signal ()
	{
		System.out.println("launching chrome browser");
	}
	
	@BeforeTest
	public void launchChrome()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.trainline.co.uk");
	}
	
	@Test
	public void steps (String aaa, String bbb, String ccc, String ddd, String eee)
	{
		driver.findElement(By.id("originStation")).clear();
		driver.findElement(By.id("originStation")).sendKeys(aaa);
		
		driver.findElement(By.id("destinationStation")).clear();
		driver.findElement(By.id("destinationStation")).sendKeys(bbb);
		
		driver.findElement(By.id("outDate")).sendKeys(ccc);
		
		driver.findElement(By.id("outHour")).sendKeys(ddd);
		
		driver.findElement(By.id("outMinute")).sendKeys(eee);
		
		driver.findElement(By.id("submitButton")).click();
	
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@AfterMethod
	public void closemssage()
	{
		System.out.println("closing chrome browser");
	}

	
	@DataProvider
	public Object [][] trainLineData()
	{
		
	}
	
	
	
	
	
}