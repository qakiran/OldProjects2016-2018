package PracticeSites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.get("https://navisionuk.sogeti.com");
		driver.findElement(By.cssSelector("[id$=TravelExpensesCard]")).click();
		driver.findElement(By.id("IB_new")).click();		
		driver.findElement(By.id("IB_newLine")).click();
		driver.findElement(By.cssSelector("[id$=EditF_Date]")).sendKeys("170517");
		driver.findElement(By.cssSelector("[id$=EditF_RubricCode]")).sendKeys("238");
		driver.findElement(By.cssSelector("[id$=EditF_Projet]")).sendKeys("H3G_MTS_001");
		driver.findElement(By.cssSelector("[id$=EditF_Description]")).sendKeys("Wonder");
		driver.findElement(By.cssSelector("[id$=EditF_Quantity]")).clear();
		driver.findElement(By.cssSelector("[id$=EditF_Quantity]")).sendKeys("1");
		driver.findElement(By.cssSelector("[id$=EditF_UnitPrice]")).clear();
		driver.findElement(By.cssSelector("[id$=EditF_UnitPrice]")).sendKeys("7.66");
		driver.findElement(By.xpath("//img[@ src='/Images/checked.gif']")).click();
	}
		
	}

