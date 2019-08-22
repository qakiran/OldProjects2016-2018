package headless;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class noBrowser {

	WebDriver driver;
	
	@Test
	public void facebook(){
		driver=new HtmlUnitDriver();
		driver.get("http://www.facebook.com");
		String facebook_title = driver.getTitle();
		
		Assert.assertTrue(facebook_title.contains("Facebook"));
		
	}
	
	@Test
	public void facebook2(){
		driver=new HtmlUnitDriver();
		driver.get("http://www.facebook.com");
		String facebook_title = driver.getTitle();
		
		Assert.assertTrue(facebook_title.contains("selenium"));
		
	}
	
}
