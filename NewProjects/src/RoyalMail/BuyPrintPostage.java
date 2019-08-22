package RoyalMail;

import static org.testng.Assert.assertNotEqualsDeep;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Lib.ScreenShot;

public class BuyPrintPostage {

	SoftAssert softAssert = new SoftAssert();
	WebDriver driver;

	@BeforeMethod
	public void launchChrome()
	{
		//Launch Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.royalmail.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void buyprintpostage() throws InterruptedException{
		//click track your item button
		driver.findElement(By.xpath("//li[@class='buy-and-print']/a")).click();
		Thread.sleep(2500);
		
		//Assert title
		String one = driver.findElement(By.tagName("body")).getText();
		softAssert.assertTrue(one.contains("Online Postage - buy postage online with this simple, free service | Royal Mail Group Ltd"));
//		System.out.println("Title is correct");
//		System.out.println("Title is wrong");
	
		//Scroll down
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,250)", "");	
		
		//click buy now button
		driver.findElement(By.xpath("//a[@class='primary btn_big btn_forward']")).click();
		Thread.sleep(2500);		
		
		//TextOnPage
		String two = driver.findElement(By.tagName("body")).getText();
		softAssert.assertTrue(two.contains("Sending a one-off, or a handful of items?"));
		
		//click getStartedNow button
		driver.findElement(By.xpath("//div[@class='buttons no-border']/a")).click();
		Thread.sleep(2500);
		
		//AssertTitle
		String three = driver.findElement(By.tagName("body")).getText();
		softAssert.assertTrue(three.contains("Buy & Print Online Postage Quickly - Click & Drop | Royal Mail Group Ltd."));

		//Select Country
		driver.findElement(By.xpath("//*[@id='s2id_Main_hdnRecipientCountry']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='s2id_autogen1_search']")).sendKeys("Greece");
		driver.findElement(By.xpath("//*[@id='select2-results-1']")).click();
		
//		List <WebElement> countries=driver.findElements(By.xpath("//*[@id='select2-results-1']/li"));
//		
//		for(int i=0;i<countries.size();i++)
//		{
//			WebElement element=countries.get(i);
//			
//			System.out.print(countries);
//			
//			String innerhtml=element.getAttribute("innerHTML");
//			
//			if(innerhtml.equals("Poland"))
//
//			{
//				element.click();
//				break;
//			}
//		}
		
		//enter weight//a[@class='primary btn_big btn_forward']
		driver.findElement(By.xpath("//*[@id='Main_txtPackageWeight']")).sendKeys("1.2");
		
		//click continue1
		driver.findElement(By.xpath("//*[@id='Main_btnDeliveryDetailsContinue']")).click();
		Thread.sleep(1500);
		
		//Select Package
//		driver.findElement(By.xpath("//input[@id='high_rdoPackageFormat_SmallParcel']")).click();
		driver.findElement(By.xpath("//tr[@class='package-format-table-view']/td[2]")).click();
		Thread.sleep(1500);
	
		//click continue2
		driver.findElement(By.xpath("//*[@id='Main_btnPackageFormatContinue']")).click();
		Thread.sleep(1500);
		
		//select compensation
		driver.findElement(By.xpath("//*[@id='Main_ddlInternationalCompensationAmount']")).click();
		Thread.sleep(2000);
		
		List <WebElement> comp=driver.findElements(By.xpath("//*[@id='Main_ddlInternationalCompensationAmount']/option"));

		for(int i=0;i<comp.size();i++)
		{
			WebElement list=comp.get(i);
			
			System.out.print(list);
			
			String innerhtml=list.getAttribute("innerHTML");
			
			if(innerhtml.equals(innerhtml+2))
			{
				list.click();
				break;
			}
		}
					
		//click packageChoice
		driver.findElement(By.xpath("//*[@id='ctrlServiceGrid']/table[1]/tbody/tr[1]/td")).click();
		//*[@id="ctrlServiceGrid"]/table[1]/tbody/tr
		Thread.sleep(1000);
		
		//Click Continue3
		driver.findElement(By.xpath("//*[@id='Main_btnServiceContinue']")).click();
		Thread.sleep(1000);
		
		//Enter recipient Details
		driver.findElement(By.xpath("//*[@id='Main_txtRecipientTitle']")).sendKeys("Mr");
		driver.findElement(By.xpath("//*[@id='Main_txtRecipientFirstName']")).sendKeys("Marco");
		driver.findElement(By.xpath("//*[@id='Main_txtRecipientLastName']")).sendKeys("McDarrio");
		driver.findElement(By.xpath("//*[@id='Main_txtRecipientCompany']")).sendKeys("MD");
		driver.findElement(By.xpath("//*[@id='Main_txtRecipientAddressLine1']")).sendKeys("Flat 3");
		driver.findElement(By.xpath("//*[@id='Main_txtRecipientAddressLine2']")).sendKeys("Con Court");
		driver.findElement(By.xpath("//*[@id='Main_txtRecipientAddressCity']")).sendKeys("Edinburgh");
		driver.findElement(By.xpath("//*[@id='Main_txtRecipientAddressCounty']")).sendKeys("Midlothian");
		driver.findElement(By.xpath("//*[@id='Main_txtRecipientPostcode']")).sendKeys("EH11 4DF");

		//Search sender address
		driver.findElement(By.xpath("//*[@id='Main_btnRecipientDetailsContinue']")).sendKeys("B13 8NB");
		
		List <WebElement> addr=driver.findElements(By.xpath("/html/body/div[4]/ul/li"));
		
		for(int i=0;i<addr.size();i++)
		{
			WebElement element=addr.get(i);
			
			String innerhtml=element.getAttribute("innerHTML");
			
			if(innerhtml.equals("B13 8NB, Flat 3, Conifer Court, Moor Green Lane, Birmingham "))
			{
				element.click();
				break;
			}
		}
		
//		//Enter send Details
		driver.findElement(By.xpath("//*[@id='Main_txtSenderTitle']")).sendKeys("Miss");
		driver.findElement(By.xpath("//*[@id='Main_txtSenderFirstName']")).sendKeys("Elena");
		driver.findElement(By.xpath("//*[@id='Main_txtSenderLastName']")).sendKeys("McDarrio");
		driver.findElement(By.xpath("//*[@id='Main_txtSenderCompany']")).sendKeys("MD");
		driver.findElement(By.xpath("//*[@id='Main_txtSenderAddressLine1']")).sendKeys("Flat 6");
		driver.findElement(By.xpath("//*[@id='Main_txtSenderAddressLine2']")).sendKeys("John Drive");
		driver.findElement(By.xpath("//*[@id='Main_txtSenderAddressCity']")).sendKeys("Brumland");
		driver.findElement(By.xpath("//*[@id='Main_txtSenderAddressCounty']")).sendKeys("West Midlands");
		driver.findElement(By.xpath("//*[@id='Main_txtSenderPostcode']")).sendKeys("B13 8NJ");
		
		//click continue 4
		driver.findElement(By.xpath("//*[@id='Main_btnSenderDetailsContinue']")).click();
		Thread.sleep(1500);
		
		//click confirm buttons
		driver.findElement(By.xpath("//table[@class='confirmation']/tbody/tr[1]/td[2]/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//table[@class='confirmation']/tbody/tr[2]")).click();
		Thread.sleep(1000);
		
		//Enter Email
		driver.findElement(By.xpath("//*[@id='Main_txtSenderEmail']")).sendKeys("nameonetwo@gmail.com");
	}
		//Click confirm payment button
		
		
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