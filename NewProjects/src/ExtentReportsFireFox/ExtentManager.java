package ExtentReportsFireFox;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;
	static String reportPath = "C:\\Users\\mardarri\\workspace\\myMavenProject\\test-output";
			
	public static ExtentReports getInstance(){
		if (extent == null){
			
			extent = new ExtentReports(reportPath, true, DisplayOrder.OLDEST_FIRST);
			
			extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/MyOwnReport.html",true);
			extent.addSystemInfo("HostName", "Marc")
			.addSystemInfo("Environment", "QA")
			.addSystemInfo("User Name", "Marc Darrie");
			
			
		}
		return extent;
	}

	}
	
