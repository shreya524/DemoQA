package Assignment;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseClass implements ITestListener {

	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	
	
	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {

	test.log(Status.PASS, "Test passed");	
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());

		System.out.println("Failed Test case:---" + result.getMethod().getMethodName());
		
		BaseClass.capture(result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
     
		extent.flush();
	}

}
