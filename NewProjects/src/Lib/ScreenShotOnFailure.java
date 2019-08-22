package Lib;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class ScreenShotOnFailure {

		WebDriver driver;
			
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