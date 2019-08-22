package pHpTravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainSite {

	WebDriver driver;
	
	@BeforeMethod
	public void messageBroswerOpen()
	{
		System.out.println("Launching Chrome and loading website");
	}
	
	@BeforeTest
	public void launchChrome()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.get("http://www.phptravels.net/");
	}
	
	@Test
	public void runTest()
	{
		
	}
	@AfterTest
	public void closeChrome()
	{
		
	}
	@AfterMethod
	public void messageBrowserClose()
	{
		
	}
	@DataProvider
	public void dataMarco()
	{
		
	}
	
}
