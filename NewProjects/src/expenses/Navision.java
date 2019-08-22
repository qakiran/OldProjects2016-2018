package expenses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Lib.ExcelDataConfig;

public class Navision implements ITestListener{

	WebDriver driver;
	
	@BeforeTest
	public void LaunchChrome()
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
	driver = new ChromeDriver ();
	driver.get("https://navisionuk.sogeti.com");
	driver.findElement(By.cssSelector("[id$=TravelExpensesCard]")).click();
	driver.findElement(By.id("IB_new")).click();
	}
	
	@Test (dataProvider="NavisionData")
	public void name1 (String date, String rubcode, String project, String description, String price)
	{
			
	driver.findElement(By.id("IB_newLine")).click();
	driver.findElement(By.cssSelector("[id$=EditF_Date]")).sendKeys(date);
	driver.findElement(By.cssSelector("[id$=EditF_RubricCode]")).sendKeys(rubcode);
	driver.findElement(By.cssSelector("[id$=EditF_Projet]")).sendKeys(project);
	driver.findElement(By.cssSelector("[id$=EditF_Description]")).sendKeys(description);
	driver.findElement(By.cssSelector("[id$=EditF_Quantity]")).clear();
	driver.findElement(By.cssSelector("[id$=EditF_Quantity]")).sendKeys("1");
	driver.findElement(By.cssSelector("[id$=EditF_UnitPrice]")).clear();
	driver.findElement(By.cssSelector("[id$=EditF_UnitPrice]")).sendKeys(price);
	driver.findElement(By.xpath("//img[@ src='/Images/checked.gif']")).click();
	
	}
	
//	@AfterTest
//	public void teardown()
//	{
//	driver.quit();
//	}
			
	@DataProvider
	public Object[][] NavisionData()
	{
		
		ExcelDataConfig config=new ExcelDataConfig("C:\\ExcelData\\NavisionData.xlsx");
		
		int rows=config.getRowCount(0);
		
		Object[][] data=new Object[rows][5];
		
		for(int i=0;i<rows;i++)
			
		{
			data[i][0]=config.getData(0, i, 0);
			data[i][1]=config.getData(0, i, 1);
			data[i][2]=config.getData(0, i, 2);
			data[i][3]=config.getData(0, i, 3);
			data[i][4]=config.getData(0, i, 4);
		}
		
		return data;
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
}
	
