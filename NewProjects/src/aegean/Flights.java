package aegean;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import expenses.ExcelDataConfigFile;

public class Flights {

	WebDriver driver;
	
	@BeforeMethod
	public void launchChrome()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.skyscanner.net");
		driver.manage().window().maximize();
	}
	
	@Test (dataProvider="HouseAreas")
	public void searchProperties(
			String postcode,
			String max, 
			String radiuss){
		driver.findElement(By.id("search-input-location")).clear();
		driver.findElement(By.id("search-input-location")).sendKeys(postcode);
		
		Select price_max = new Select(driver.findElement(By.id("forsale_price_max")));
		price_max.selectByValue(max);
			
		Select property_type = new Select(driver.findElement(By.id("property_type")));
		property_type.selectByValue("houses");
		
		Select beds_min = new Select(driver.findElement(By.id("beds_min")));
		beds_min.selectByVisibleText("3+");
		
		driver.findElement(By.xpath("//div[1]/div[1]/form/div[2]/div[3]/div[1]/a")).click(); 
		Select radius = new Select(driver.findElement(By.id("radius")));
		radius.selectByValue(radiuss);
				
		driver.findElement(By.id("search-submit")).click();
		
		WebElement name = driver.findElement(By.className("listing-results-utils-count"));
	    String text = name.getText();
	    
	    WebElement count = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[5]/a/span"));
	    String area = count.getText();
	    
	    System.out.println("Area " +area   +text);
		}

//	@AfterMethod
//	public void quit(){
//		driver.quit();
//	}
	
	@DataProvider
	public Object[][] HouseAreas()
	{
		
		ExcelDataConfigFile config=new ExcelDataConfigFile("C:\\Users\\mardarri\\workspace\\NewProjects\\src\\zoopla\\Houses.xlsx");
		
		int rows=config.getRowCount(0);
		
		Object[][] data=new Object[rows][3];
		
		for(int i=0;i<rows;i++)
			
		{
			data[i][0]=config.getData(0, i, 0);
			data[i][1]=config.getData(0, i, 1);
			data[i][2]=config.getData(0, i, 2);
		}
		
		return data;
	}
	
}
