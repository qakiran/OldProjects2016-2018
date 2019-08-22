package CheckList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DatePickerDemo {

	WebDriver driver;
	
	@Test
	public void xxxx() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get("http://www.skyscanner.net");
		
		driver.findElement(By.id("js-depart-input")).click();
		Thread.sleep(3000);
		
		List <WebElement> dates=driver.findElements(By.xpath("//*[@id='category-flights']//td"));
		
		int total_node=dates.size();
		
		for(int i=0;i<total_node;i++)
		{
			String date=dates.get(i).getText();			
			if(date.equals("20"))
			{
				dates.get(i).click();
				break;
			}
		}
		
	}
	
}
