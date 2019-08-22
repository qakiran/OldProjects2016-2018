package expenses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PDFExepenses {

	WebDriver driver;
	
	@BeforeTest
	public void LaunchChrome()
	{
	System.setProperty("webdriver.gecko.driver","C:\\Users\\mardarri\\Downloads\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.get("https://navisionuk.sogeti.com");
	driver.manage().window().maximize();

//	driver.findElement(By.cssSelector("[id$=EditF_UnitPrice]")).clear();
}

	@Test
	public void name(){
		driver.findElement(By.cssSelector("[id$=TravelExpensesCard]")).click();
//		driver.findElement(By.cssSelector("[href$="MenuRelease']")).click();
//		href="javascript:__doPostBack('MenuRelease','Functions\\Release')"
	}
	
	
}