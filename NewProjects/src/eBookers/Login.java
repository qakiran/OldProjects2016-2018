package eBookers;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login {

	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void logInUser(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mardarri\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		File src=new File("C:\\Users\\mardarri\\Downloads\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
//		System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
//		driver=new PhantomJSDriver();
		driver.get("https://www.ebookers.com");
		driver.findElement(By.id("header-account-menu")).click();
		driver.findElement(By.id("header-account-signin")).click();
		String Currenturl=(driver.getCurrentUrl());
		softAssert.assertEquals(Currenturl, "Sign In");
		
		//Login Screen
		driver.findElement(By.id("signin-loginid")).clear();
		driver.findElement(By.id("signin-loginid")).sendKeys("marcofilexfer@gmail.com");
		driver.findElement(By.id("signin-password")).clear();
		driver.findElement(By.id("signin-password")).sendKeys("marco100");
		driver.findElement(By.id("submitButton")).click();
		
		//User LoggedIn
		driver.findElement(By.id("tab-flight-tab")).click();
		driver.findElement(By.id("flight-origin")).clear();
		driver.findElement(By.id("flight-origin")).sendKeys("Birmingham");
		driver.findElement(By.id("flight-destination")).clear();
		driver.findElement(By.id("flight-destination")).sendKeys("Athens");
		
		//Date Out
		driver.findElement(By.id("flight-departing")).clear();
		driver.findElement(By.id("flight-departing")).sendKeys("06/06/2018");
		//Date return
		driver.findElement(By.id("flight-returning")).clear();
		driver.findElement(By.id("flight-returning")).sendKeys("20/06/2018");
		//Adults
		Select adults = new Select(driver.findElement(By.id("flight-adults")));
		adults.selectByVisibleText("3");
		//Search Button
		driver.findElement(By.id("search-button")).click();
		
		//AssertPage
		String Currenturl2=(driver.getCurrentUrl());
		softAssert.assertEquals(Currenturl2, "Please help us with a little more information");
		Select radiobutton = new Select(driver.findElement(By.id("Leg1departureLocationOptionId1")));
		radiobutton.selectByVisibleText("Birmingham BHX-All Airports");

		//Continue Button
		driver.findElement(By.id("continue-search")).click();
	
		//Assert Title
		String Currenturl3=(driver.getCurrentUrl());
		softAssert.assertEquals(Currenturl3, "BHX to ATH Flights | Ebookers");
		
		//*[@id="flightDisAmbigSearch"]/fieldset[1]/section/label[1]/span
		
		
	}
		
		
		
		
	}
	

