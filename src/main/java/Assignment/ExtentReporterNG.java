package Assignment;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporterNG {

	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		reporter.config().setReportName("Assesment Results");
		
		
		 extent =new ExtentReports();
		 extent.attachReporter(reporter);
	     return extent;
			
		
	}
}
