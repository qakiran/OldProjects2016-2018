package RoyalMail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePage {
	
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
	public void buyAmobile(){
		//button text
		String one = driver.findElement(By.tagName("body")).getText();
		softAssert.assertTrue(one.contains("Royal Mail | Royal Mail Group Ltd"));

		
		String two = driver.findElement(By.tagName("body")).getText();
		softAssert.assertTrue(two.contains("Sending mail"));

		
		String three = driver.findElement(By.tagName("body")).getText();
		softAssert.assertTrue(three.contains("Receiving mail"));

		
		String four = driver.findElement(By.tagName("body")).getText();
		softAssert.assertTrue(four.contains("Shop"));

		
		String five = driver.findElement(By.tagName("body")).getText();
		softAssert.assertTrue(five.contains("Help & support"));

		
		String six = driver.findElement(By.tagName("body")).getText();
		softAssert.assertTrue(six.contains("Business services"));

	}
	
	
	
	
}
