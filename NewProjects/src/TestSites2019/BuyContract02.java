package TestSites2019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BuyContract02 {

	SoftAssert softAssert = new SoftAssert();
	WebDriver driver;

	@BeforeTest
	public void launchChrome()
	{
		//Launch Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.o2.co.uk/shop");
		driver.manage().window().maximize();
	}
		
		@Test
		public void buyAmobile() throws InterruptedException {
			//Try to catch pop ups and close
			
			
			//Select Shop Header
			driver.findElement(By.name("Shop")).click();
			driver.findElement(By.xpath("//a[@title='Samsung']")).click();
			
}
}