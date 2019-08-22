package Lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dropdown {

		WebDriver driver;
	
	
		@Test
		public void dropdownFacebook(){
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\mardarri\\Downloads\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.facebook.com");
		
		
		WebElement month_dropdown = driver.findElement(By.id("month"));
		Select month_dd=new Select(month_dropdown);
		month_dd.selectByVisibleText("Jul");		//Best Option
		
//		month_dd.selectByValue(arg0);				//2nd used
//		month_dd.selectByIndex(arg0);				//Least Used		

//		month_dd.deselectByValue(arg0);
//		month_dd.deselectByIndex(arg0);	
//		month_dd.deselectByVisibleText("xxxxx");

		
		
		//Return_value
		WebElement selected_value = month_dd.getFirstSelectedOption();
		
		System.out.println("After selection, first selected value is " +selected_value.getText());
		}
	
	
}




		
