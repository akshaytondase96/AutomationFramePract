package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseTest implements ITestListener 
{
	//WebDriver driver;
	ExtentReports ext=getExtentObject();
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		test=ext.createTest(result.getMethod().getMethodName());
		System.out.println("Test execution started");
		}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String filePath=null;
		test.fail(result.getThrowable());
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 filePath=getScreenShot(driver);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Skippped");
	}

	@Override
	public void onFinish(ITestContext context) {
		ext.flush();
	}
  
}
