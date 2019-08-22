package headless;

import java.io.File;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

import Lib.ScreenShot;

public class PhantomJS {
	
	WebDriver driver;
	
	@Test
	public void FacebookTitle(){
		File src=new File("C:\\Users\\mardarri\\Downloads\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
		driver=new PhantomJSDriver();
		driver.get("http://www.facebook.com");
		System.out.println(driver.getTitle());
		ScreenShot.captureScreenShot(driver, "PhantomJSDriverExample");
		}
	}

