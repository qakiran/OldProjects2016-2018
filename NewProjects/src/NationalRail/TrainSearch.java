package NationalRail;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Lib.ExcelDataConfig;
import Lib.ScreenShot;

public class TrainSearch 
{

	WebDriver driver;
	
	@BeforeMethod
	public void launchChrome()
	{
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
//		driver = new ChromeDriver();
//		File src=new File("C:\\Users\\mardarri\\Downloads\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
//		System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
//		driver=new PhantomJSDriver();
		System.setProperty("webdriver.gecko.driver","C:\\Users\\mardarri\\Downloads\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.nationalrail.co.uk");
		driver.manage().window().maximize();
	}
	
	@Test
	public void searchProperties(
		
			) throws InterruptedException
	{
		driver.findElement(By.id("txtFrom")).clear();
		driver.findElement(By.id("txtFrom")).sendKeys("Edinburgh");
		
		driver.findElement(By.id("txtTo")).clear();
		driver.findElement(By.id("txtTo")).sendKeys("London");
		
		driver.findElement(By.id("txtDate")).click();
		Thread.sleep(2000);
		
		List <WebElement> dates=driver.findElements(By.xpath("//*[@id='dp']//td"));
		
		String day = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
		
		int total_node=dates.size();
		
		for(int i=0;i<total_node;i++)
		{
			String date=dates.get(i).getText();			
			if(date.equals(day))
			{
				dates.get(i).click();
				break;
			}
		}
		
		
		driver.findElement(By.id("ret-ch")).click();
		Thread.sleep(2000);
				
		driver.findElement(By.id("txtDateRet")).click();
		Thread.sleep(2000);
		
		List <WebElement> dates1=driver.findElements(By.xpath("//*[@id='dp']//td"));
		
		int total_nodes=dates1.size();
		
		for(int i=0;i<total_nodes;i++)
		{
			String date=dates1.get(i).getText();			
			if(date.equals(day))
			{
				dates1.get(i+1).click();
				break;
			}
		}
				
		driver.findElement(By.xpath("//*[@id='jp']/div[1]/div[1]/button/span")).click();	
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("buyCheapestButton")));
		
		String Currenturl=(driver.getTitle());
		Assert.assertEquals(Currenturl, "Journey Planner - Trains Times and Fares - National Rail Enquiries");
				
		driver.quit();
	}
		
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	
		if(ITestResult.FAILURE==result.getStatus())
		{
			ScreenShot.captureScreenShot(driver, result.getName());
		}
		
		driver.quit();

	}
	
}