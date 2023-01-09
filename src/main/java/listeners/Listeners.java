package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReport;

public class Listeners extends Base implements ITestListener {

	ExtentReports extentReports = ExtentReport.getExtentReport();
	WebDriver driver = null;
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThreadSafe = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		extentTest  = extentReports.createTest(testName);
		extentTestThreadSafe.set(extentTest);
	}

	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		//extentTest.log(Status.PASS, testName +" Got Pass");
		extentTestThreadSafe.get().log(Status.PASS, testName +" Got Pass");
	}

	public void onTestFailure(ITestResult result) {
		
		String testName = result.getName();
		//extentTest.fail(result.getThrowable());
		extentTestThreadSafe.get().fail(result.getThrowable());
		try 
		{
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			 String screenshotFilPath = takeScreenshot(testName, driver);
			 extentTestThreadSafe.get().addScreenCaptureFromPath(screenshotFilPath, testName);
		}
		catch(Exception e)
		{
			
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extentReports.flush();
	}

}
