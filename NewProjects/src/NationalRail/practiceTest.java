package NationalRail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class practiceTest {
	
	WebDriver driver;
	
	@Test
	public void name() throws InterruptedException{
//		System.setProperty("webdriver.gecko.driver","C:\\Users\\mardarri\\Downloads\\geckodriver.exe");
//		driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.get("http://www.nationalrail.co.uk");
//		driver.findElement(By.xpath("//*[@href='/personal/login/login']")).click();
		driver.switchTo().frame("omnibarDD");
		driver.findElement(By.xpath("//*[@class='acc clear']")).click();
		
		


	}

}
