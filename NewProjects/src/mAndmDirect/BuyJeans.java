package mAndmDirect;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BuyJeans {

	
	WebDriver driver;
	
	
		@BeforeTest 
		public void homepage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.musicmagpie.co.uk");
		driver.findElement(By.id("ctl00_ctl00_ctl00_ContentPlaceHolderDefault_signIn_8_pnlLoggedOut")).click();
		Thread.sleep(6000);
	}
	
		@Test
		public void musicMagPie() throws InterruptedException {
		driver.findElement(By.id("ctl00_ctl00_ctl00_ContentPlaceHolderDefault_mainContent_ctl00_LoginPage2018_11_txtSignInEmail")).sendKeys("marcdarrie@hotmail.com");
		driver.findElement(By.id("ctl00_ctl00_ctl00_ContentPlaceHolderDefault_mainContent_ctl00_LoginPage2018_11_txtSignInPassword")).sendKeys("Edinburgh100");
		Thread.sleep(3000);
		driver.findElement(By.id("btnLogin")).click();
//		driver.
		
		@AfterTest
		public void quit () {
		driver.quit();
	}
	
	}
}
