package skyScanner;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import expenses.ExcelDataConfigFile;

public class Flights {

WebDriver driver;
	
	@BeforeMethod
	public void launchChrome() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.skyscanner.net");
		Thread.sleep(20000);
	}
	

//	String xxxx,
//	String xxxx, 
//	String xxxxx
	
	@Test //(dataProvider="Flying")
	public void searchProperties() throws InterruptedException
	{
		
//		driver.findElement(By.className("return-trip checked")).click();
		
		driver.findElement(By.id("js-origin-input")).clear();
		driver.findElement(By.id("js-origin-input")).sendKeys("Birmingham");
		
		driver.findElement(By.id("js-destination-input")).clear();
		driver.findElement(By.id("js-destination-input")).sendKeys("Edinburgh");
		
		driver.findElement(By.id("js-depart-input")).click();
		Thread.sleep(2000);
		
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
		
		driver.findElement(By.id("js-return-input")).click();
		Thread.sleep(2000);
		
		List <WebElement> dates1=driver.findElements(By.xpath("//*[@id='category-flights']//td"));
		
		int total_nodes=dates1.size();
		
		for(int i=0;i<total_nodes;i++)
		{
			String date=dates1.get(i).getText();			
			if(date.equals("26"))
			{
				dates1.get(i).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//*[@id='js-search-controls-container']/form/section[2]/button")).click();
		Thread.sleep(5000);
		
	}
	//*[@id="js-search-controls-container"]/form/section[2]/button

//	@AfterMethod
//	public void quit(){
//		driver.quit();
//	}
	
//	@DataProvider
//	public Object[][] Flying()
//	{
//		
//		ExcelDataConfigFile config=new ExcelDataConfigFile("C:\\Users\\mardarri\\workspace\\NewProjects\\src\\zoopla\\Houses.xlsx");
//		
//		int rows=config.getRowCount(0);
//		
//		Object[][] data=new Object[rows][3];
//		
//		for(int i=0;i<rows;i++)
//			
//		{
//			data[i][0]=config.getData(0, i, 0);
//			data[i][1]=config.getData(0, i, 1);
//			data[i][2]=config.getData(0, i, 2);
//		}
//		
//		return data;
//	}
	
}
