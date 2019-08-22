package RoyalMail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Lib.ScreenShot;

public class GetAPrice {

	SoftAssert softAssert = new SoftAssert();
	WebDriver driver;

	@BeforeMethod
	public void launchChrome()
	{
		//Launch Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.royalmail.com/price-finder");
		driver.manage().window().maximize();
	}
	
	@Test
	public void getaprice() throws InterruptedException{
		//click get a price link
//		driver.findElement(By.xpath("//li[@class='price-finder']a")).click();
	
//		driver.findElement(By.xpath("//li[@class='buy-and-print']/a")).click();
//		Thread.sleep(2000);
		
		//Assert title
		String Page = "Geeet a price | Royal Mail Group Ltd";
		String one = driver.findElement(By.tagName("body")).getText();
		if(Assert.assertEquals(Page, one);){
//			softAssert.assertTrue(one.equals(Page));
			System.out.println("Text present ======" +Page);
		}
		else{
		softAssert.assertEquals(one, Page, "text no present ");
		}
		
		
////		if (softAssert.equals(Page))
////		{
////			System.out.println("Text present ======" +Page);
////			
////		}
////		else{	System.out.println("*****Text NOT present****** " +Page);
////		}
//		
//		//Assert UK text
//		String UKservices = "UK services";
//		String two = driver.findElement(By.tagName("body")).getText();
//		softAssert.assertTrue(two.equals(UKservices));
////		if (two.equals(UKservices))
////		{
////			System.out.println("Text present ======" +UKservices);
////		}
////		else{	System.out.println("*****Text NOT present****** " +UKservices);
////		}
//		
//		//click overseas button
//		driver.findElement(By.xpath("//*[@id='where-choice-tab-1']")).click();
//		Thread.sleep(2000);
//		
//		//Assert overseas text
//		String overseas = "Overseas services";
//		String three = driver.findElement(By.tagName("body")).getText();
//		softAssert.assertTrue(three.equals(overseas));
////		if (softAssert.equals(overseas))
////		{
////			System.out.println("Text present ======" +overseas);
////		}
////		else{	System.out.println("*****Text NOT present****** " +overseas);
////		}
//		
//		//click overseas button
//		driver.findElement(By.xpath("//*[@id='where-choice-tab-2']")).click();
//		Thread.sleep(2000);
//		
//		//Assert overseas text
//		String HMforces = "HM Forces";
//		String four = driver.findElement(By.tagName("body")).getText();
//		softAssert.assertTrue(four.equals(HMforces));
////		if (softAssert.equals(HMforces))
////				{
////			System.out.println("Text present ======" +HMforces);
////		}
////		else{System.out.println("*****Text NOT present****** " +HMforces);
////		}
//		
////		softAssert.assertAll();
	}

	
//	@AfterMethod
//	public void tearDown(ITestResult result)
//	{
//	
//		if(ITestResult.FAILURE==result.getStatus())
//		{
//			ScreenShot.captureScreenShot(driver, result.getName());
//			
//			
//		}
//		
//		driver.quit();
//	
//}
	
}
	
