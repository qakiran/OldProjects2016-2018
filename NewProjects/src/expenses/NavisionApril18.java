package expenses;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NavisionApril18 {

//	/**
//	 * @author Marc Darrie on 02/08/17
//	 * Build program to speed up entering expenses and eradicate the effort of manual repetitive input
//	 * Just update and maintain your excel sheet accordingly to feed the data
//	 * Remember to put a ' before any number in the excel to read it as a number
//	 * CHECK your Navision expenses are correct before releasing
//	 **/

			WebDriver driver;
			
			@BeforeTest
			public void LaunchChrome()
			{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\mardarri\\Downloads\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver ();
			driver.get("https://navisionuk.sogeti.com");
			driver.manage().window().maximize();
			driver.findElement(By.cssSelector("[id$=TravelExpensesCard]")).click();
			driver.findElement(By.id("IB_new")).click();
			}
			
			@Test (dataProvider="NavisionData")
			public void Inputdata 
					(String date,
					String rubcode,
					String project,
					String description,
					String price)
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
//			driver.findElement(By.xpath("//img[@ src='/Images/checked.gif']")).click();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,250)", "");	
			}
			
//			@AfterTest
//			public void teardown()
//			{
//			driver.quit();
//			}
					
			@DataProvider
			public Object[][] NavisionData()
			{
				
				ExcelDataConfigFile config=new ExcelDataConfigFile("C:\\ExcelData\\AAAAAA.xlsx");
				
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
			
	}
			

