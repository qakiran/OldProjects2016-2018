package zoopla;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HouseSearchCOPY {
	
WebDriver driver;
	
	@BeforeTest
	public void launchChrome()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.zoopla.co.uk");
		driver.manage().window().maximize();
	}
	
	@Test
	public void searchProperties(){
		driver.findElement(By.id("search-input-location")).clear();
		driver.findElement(By.id("search-input-location")).sendKeys("b13 8nb");
		
		Select price_max = new Select(driver.findElement(By.id("forsale_price_max")));
		price_max.selectByValue("250000");
			
		Select property_type = new Select(driver.findElement(By.id("property_type")));
		property_type.selectByValue("houses");
		
		Select beds_min = new Select(driver.findElement(By.id("beds_min")));
		beds_min.selectByValue("3");
		
		driver.findElement(By.xpath("//div[1]/div[1]/form/div[2]/div[3]/div[1]/a")).click(); 
		Select radius = new Select(driver.findElement(By.id("radius")));
		radius.selectByValue("3");
				
		driver.findElement(By.id("search-submit")).click();
		
//		String my_title=driver.getTitle();
//		System.out.println(""+my_title);
			
		WebElement textElement = driver.findElement(By.className("listing-results-utils-count"));
	    String text = textElement.getText();
//	    System.out.println(""+ text);   
	    
	    WebElement textElements = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[5]/a/span"));
	    String area = textElements.getText();
//	    System.out.println(""+ area); 
	    
	    System.out.println(" "+area +text);
	    
	    }

	@AfterTest
	public void quit(){
		driver.quit();
	}
	
}
