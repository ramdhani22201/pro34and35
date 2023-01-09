package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static  ExtentReports extentReports;
	public static ExtentReports getExtentReport()
	{
		String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(extentReportPath);
		extentSparkReporter.config().setReportName("TutorialsNinja.com");
		extentSparkReporter.config().setDocumentTitle("Test Result");
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Operating System", "Windows 7");
		extentReports.setSystemInfo("Tested By", "Ramdhani Chuhan");
		
		return extentReports;
		
	}

}
