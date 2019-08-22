package o2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Lib.ScreenShot;
import expenses.ExcelDataConfigFile;

public class BuyingAContractStrings {

	SoftAssert softAssert = new SoftAssert();
	WebDriver driver;

	
	@BeforeMethod
	public void launchChrome()
	{
		//Launch Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.o2.co.uk/shop");
		driver.manage().window().maximize();
	}
	
	@Test (dataProvider="phoneData")
	public void buyAmobile(
			String color
			) throws InterruptedException {
		//Try to catch pop ups and close
		
		
		//Select phone
		driver.findElement(By.xpath("//nav[@id='nav-secondary']/div/ul/li/a")).click();
		driver.findElement(By.xpath(color)).click();
		//Scroll down
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");	
		
		//select colour dropdown
//		driver.findElement(By.id("colourSelectBoxItArrowContainer")).click();
//		Thread.sleep(2000);
//		
//		List <WebElement> dates1=driver.findElements(By.xpath("//*[@id='colourSelectBoxItOptions']/li/a/span[2]"));
//		
//		for(int i=0;i<dates1.size();i++)
//		{
//			WebElement element=dates1.get(i);
//			
//			String innerhtml=element.getAttribute("innerHTML");
//			
//			if(innerhtml.equals(color))
//			{
//				element.click();
//				break;
//			}
//		}

		//Select device
		driver.findElement(By.id("deviceDetailsSubmit")).click();
		
		//Filter data and expand view
		driver.findElement(By.xpath("//div[@class='filter-options']/button[3]")).click();
		driver.findElement(By.xpath("//div[@class='plusImage']")).click();
		Thread.sleep(2000);
		
		//Select price plan
		driver.findElement(By.xpath("//button[@id='callToAction']/preceding::button[@id='callToAction']/preceding::button[@id='callToAction']")).click();
		
		//Basket Page
		driver.findElement(By.id("qa-proceed-to-basket-dock-header")).click();
		
		//Assert title
		String bodyText = driver.findElement(By.tagName("body")).getText();
		softAssert.assertTrue(bodyText.contains("O2 | Basket"));
	
		//go to checkout
		driver.findElement(By.name("securecheckout")).click();
		
		//Assert title
		String bodyText1 = driver.findElement(By.tagName("body")).getText();
		softAssert.assertTrue(bodyText1.contains("O2 | Delivery"));
		System.out.println(bodyText1);
		
		//click other button
		driver.findElement(By.xpath("//*[@id='deliver-to-store-tab']")).click();
		Thread.sleep(1500);
		
		//Click original button
		driver.findElement(By.xpath("//*[@id='deliver-to-home-tab']")).click();
		Thread.sleep(1500);
		
		//enter house number
		driver.findElement(By.id("housenumber")).clear();
		driver.findElement(By.id("housenumber")).sendKeys("12");
		
		//enter postcode
		driver.findElement(By.id("postcode")).clear();
		driver.findElement(By.id("postcode")).sendKeys("eh11 4rt");
		
		//click search
		driver.findElement(By.id("postcode-submit")).click();
		Thread.sleep(1500);
		
		//select address
		driver.findElement(By.xpath("//*[@id='delivery-address-selection']")).click();
		Thread.sleep(1500);
		
		//personal details
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("name@email.com");
		
		//Select Title
		driver.findElement(By.id("title")).click();
		Thread.sleep(2000);
		
		List <WebElement> name=driver.findElements(By.xpath("//*[@id='title']/option"));
		
		for(int i=0;i<name.size();i++)
		{
			WebElement element=name.get(i);
			
			String innerhtml=element.getAttribute("innerHTML");
			
			if(innerhtml.equals("Mr"))
			{
				element.click();
				break;
			}
		}
		
		//details
		driver.findElement(By.id("first-name")).clear();
		driver.findElement(By.id("first-name")).sendKeys("marco");
		driver.findElement(By.id("last-name")).clear();
		driver.findElement(By.id("last-name")).sendKeys("McLarrryie");
		driver.findElement(By.id("contact-number")).clear();
		driver.findElement(By.id("contact-number")).sendKeys("07890987655");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("marco90000");
		
		//Memorable name dropdown
		driver.findElement(By.id("security-questions")).click();
		Thread.sleep(2000);
		
		List <WebElement> name1=driver.findElements(By.xpath("//*[@id='security-questions']/option"));
		
		for(int i=0;i<name1.size();i++)
		{
			WebElement element=name1.get(i);
			
			String innerhtml=element.getAttribute("innerHTML");
			
			if(innerhtml.equals("Name of first school attended"))
			{
				element.click();
				break;
			}
		}
		
		//Answer
		driver.findElement(By.id("security-answer")).clear();
		driver.findElement(By.id("security-answer")).sendKeys("MurrayBurnoanohdh");
		driver.findElement(By.id("date-dd")).clear();
		driver.findElement(By.id("date-dd")).sendKeys("09");
		driver.findElement(By.id("date-mm")).clear();
		driver.findElement(By.id("date-mm")).sendKeys("09");
		driver.findElement(By.id("date-yy")).clear();
		driver.findElement(By.id("date-yy")).sendKeys("1981");
		
		//untick box
		driver.findElement(By.xpath("//*[@id='marketing-info-required']")).click();
		
		//click button
		
		
		
		
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
	
	@DataProvider
	public Object[][] phoneData()
	{
		
		ExcelDataConfigFile config=new ExcelDataConfigFile("C:\\Users\\mardarri\\workspace\\NewProjects\\src\\o2\\Book1.xlsx");
		
		int rows=config.getRowCount(0);
		
		Object[][] data=new Object[rows][1];
		
		for(int i=0;i<rows;i++)
			
		{
			data[i][0]=config.getData(0, i, 0);
//			data[i][1]=config.getData(0, i, 1);
//			data[i][2]=config.getData(0, i, 2);
//			data[i][3]=config.getData(0, i, 3);
//			data[i][4]=config.getData(0, i, 4);
		}
		
		return data;
	}
	
}
