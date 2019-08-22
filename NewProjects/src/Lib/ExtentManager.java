package Lib;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;
	static String reportPath = "C:\\Users\\mardarri\\workspace\\myMavenProject\\test-output";
			
	public static ExtentReports getInstance(){
		if (extent == null){
			
			extent = new ExtentReports(reportPath, true, DisplayOrder.OLDEST_FIRST);
			
			extent.loadConfig(new File(System.getProperty("user.dir")+"/test-output/ReportsConfig.html"));
			extent.addSystemInfo("HostName", "Marc")
			.addSystemInfo("Environment", "QA")
			.addSystemInfo("User Name", "Marc Darrie");
			
			
		}
		return extent;
	}

}
