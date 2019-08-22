package Lib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectDropdownOption {

	driver.findElement(By.id("xxxxxxxxxxxx")).click();
	Thread.sleep(2000);
	
	List <WebElement> name=driver.findElements(By.xpath("xxxxxxxxxxxxxxx"));
	
	for(int i=0;i<name.size();i++)
	{
		WebElement element=name.get(i);
		
		String innerhtml=element.getAttribute("innerHTML");
		
		if(innerhtml.equals("xxxxxxxx"))
		{
			element.click();
			break;
		}
	}
	
}
