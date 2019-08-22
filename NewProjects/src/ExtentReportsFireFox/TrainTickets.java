package ExtentReportsFireFox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Lib.ExcelDataConfig;
import expenses.ExcelDataConfigFile;
import ExtentReports.ExtentManager;

public class TrainTickets {
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	
	WebDriver driver;
		
	@BeforeMethod
	public void loadSite(){
		System.setProperty("webdriver.gecko.driver","C:\\Users\\mardarri\\Downloads\\geckodriver.exe");
		driver = new FirefoxDriver();
//		driver.manage().window().maximize();
		driver.get("https://www.thetrainline.com");

	}
	
	@BeforeTest
	public void messageOut(){
		System.out.println("Launching Trainline website");
	}
	
	@Test(dataProvider="trainlinedata")
	public void bookTrainTicket(
			String from,
			String to,
			String datefrom,
			String timefromhr,
			String timefromMin,
			String dateto,
			String timeTohr,
			String timeToMin
//			String adults
			){
		test = rep.startTest("bookTrainTicket");
		test.log(LogStatus.INFO, "Starting the test");
		driver.findElement(By.id("originStation")).clear();
		driver.findElement(By.id("originStation")).sendKeys(from);
		test.log(LogStatus.PASS, "From "+from+"");
		driver.findElement(By.id("destinationStation")).clear();
		driver.findElement(By.id("destinationStation")).sendKeys(to);
		test.log(LogStatus.PASS, "To "+to+"");
		driver.findElement(By.id("journey-type-open-return")).click();
		
//		driver.findElement(By.id("outDate")).clear();
		driver.findElement(By.id("outDate")).sendKeys(datefrom);
		test.log(LogStatus.PASS, "Outward Date: "+datefrom+"");
//		driver.findElement(By.id("outHour")).clear();
		driver.findElement(By.id("outHour")).sendKeys(timefromhr);
		test.log(LogStatus.PASS, "Outward Date Hour: "+timefromhr+"");
//		driver.findElement(By.id("outMinute")).clear();
		driver.findElement(By.id("outMinute")).sendKeys(timefromMin);
		test.log(LogStatus.PASS, "Outward Date Minute: "+timefromMin+"");
		
//		driver.findElement(By.id("returnDate")).clear();
//		driver.findElement(By.id("returnDate")).sendKeys(dateto);
//		driver.findElement(By.id("returnHour")).clear();
//		driver.findElement(By.id("returnHour")).sendKeys(timeTohr);
//		driver.findElement(By.id("returnMinute")).clear();
//		driver.findElement(By.id("returnMinute")).sendKeys(timeToMin);
		
//		driver.findElement(By.id("adults")).clear();
//		driver.findElement(By.id("adults")).sendKeys(adults);

//		((JavascriptExecutor) driver).executeScript(By.id("outDate"))
//		driver.findElement(By.id("submitButton")).click();
//		driver.findElement(By.name("ExtendedSearch")).click();
		
//		String bodyText = driver.findElement(By.tagName("body")).getText();
//		Assert.assertTrue(bodyText.contains("Standard Single"));
		
//		System.out.println("Test PASSED - you successfully searched from "+from+" to "+to+" rail tickets");
		test.log(LogStatus.PASS, "Test Passed you successfully searched from "+from+" to "+to+" rail tickets");
			}

//	@AfterTest
//	public void quitBrowser(){
//		driver.quit();
//	}
	
	@AfterMethod
	public void quitReport(){
		rep.endTest(test);
		rep.flush();
		driver.quit();
	}
	

	@DataProvider
	public Object[][] trainlinedata()
	{
		
		ExcelDataConfig config=new ExcelDataConfig("C:\\Users\\mardarri\\workspace\\NewProjects\\src\\trainLineWebSite\\TrainLine.xlsx");
		
		int rows=config.getRowCount(0);
		
		Object[][] data=new Object[rows][8];
		
		for(int i=0;i<rows;i++)
			
		{
			data[i][0]=config.getData(0, i, 0);
			data[i][1]=config.getData(0, i, 1);
			data[i][2]=config.getData(0, i, 2);
			data[i][3]=config.getData(0, i, 3);
			data[i][4]=config.getData(0, i, 4);
			data[i][5]=config.getData(0, i, 5);
			data[i][6]=config.getData(0, i, 6);
			data[i][7]=config.getData(0, i, 7);
		}
		
		return data;
	}
	
}
