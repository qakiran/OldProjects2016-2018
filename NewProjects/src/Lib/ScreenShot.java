package Lib;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot
{
	
	public static void captureScreenShot(WebDriver driver,String screenshotName)
	{
	try
	{	
			TakesScreenshot ts=(TakesScreenshot)driver;

			File source=ts.getScreenshotAs(OutputType.FILE);
			
		    String timeStamp = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
		    
			FileUtils.copyFile(source, new File("./ScreenShots/" +screenshotName+ timeStamp+".png"));

			System.out.println(screenshotName+ " failed = Screenshot taken");
	}	
			catch (Exception e)
	{	
				
			System.out.println("Exception while takin screenshot "+e.getMessage());		
			
				}		
	}
}
