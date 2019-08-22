package PracticeSites;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class MemoryJan18 {
	
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.skyscanner.net");
	}

	@Test
	public void searchFlights (String origin, String destination){
		driver.findElement(By.id("js-origin-input")).clear();
		driver.findElement(By.id("js-origin-input")).sendKeys(origin);
		driver.findElement(By.id("js-destination-input")).clear();
		driver.findElement(By.id("js-destination-input")).sendKeys(destination);
		driver.findElement()
		driver.getPageSource().contains("results sorted");
		}
	
	@AfterTest
	public void assertPage(){
		
	}
	
	@DataProvider
	
	
}
