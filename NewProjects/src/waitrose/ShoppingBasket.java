package waitrose;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class ShoppingBasket {

	WebDriver driver;
	
	@BeforeTest
	public void LaunchChrome()
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
	driver = new ChromeDriver ();
	driver.get("http://www.waitrose.com/");
	driver.findElement(By.cssSelector("[id$=TravelExpensesCard]")).click();
	driver.findElement(By.id("IB_new")).click();
	}
	
}
