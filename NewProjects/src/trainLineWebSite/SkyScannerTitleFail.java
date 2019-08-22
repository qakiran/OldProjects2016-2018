package trainLineWebSite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SkyScannerTitleFail {

	WebDriver driver;
		
	@BeforeTest
	public void loadSite(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver ();
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
		assertTrue(driver.getTitle().contains("Skyscanner - Compare Cheap Flights, Hotels & Car Hiree"));
	}
	
	@AfterTest
	public void quit(){
		driver.quit();
	}
	
	
	
}
