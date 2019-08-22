package trainLineWebSite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoadSiteTrainLine {

	WebDriver driver;
		
	@BeforeMethod
	public void loadSite(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.get("https://www.thetrainline.com");
	}
	
	@Test
	public void confirmTitle(){
		String actualTitle = driver.getTitle();
		String expectedTitle = "Trainline | Buy Cheap Train Tickets | Live Train Times & Fares";
		assertEquals(expectedTitle,actualTitle);
	}
	
	@AfterMethod
	public void quit(){
		driver.quit();
	}
	
	
	
}
