package base;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class TestListener extends Base implements ITestListener {
	String ss;

	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}
	
	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
		ExtentManager.getInstance().flush();
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
	ExtentTestManager.getTest().log(Status.PASS,"" + result.getMethod().getMethodName() + "  test successfully...");
	ExtentTestManager.getTest().log(Status.PASS,""+Thread.currentThread().getStackTrace());
		ExtentManager.getInstance().flush();
		// ExtentTestManager.getTest().addScreenCaptureFromPath(null);
		try {
			ss = Base.getScreenShot(System.getProperty("user.dir") + "/" + result.getMethod().getMethodName()
					+ "ScreenShotsDetails - " + Base.getDateTimeStamp() + ".png");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentTestManager.getTest().addScreenCaptureFromPath(ss);

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		ExtentTestManager.getTest().log(Status.FAIL, "" + result.getMethod().getMethodName() + "  Test Failed");
		ExtentTestManager.getTest().log(Status.FAIL,""+Thread.currentThread().getStackTrace());
		
		ExtentManager.getInstance().flush();
		try {
			ss = Base.getScreenShot(System.getProperty("user.dir") + "/" + result.getMethod().getMethodName()
					+ "ScreenShotsDetails - " + Base.getDateTimeStamp() + ".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentTestManager.getTest().addScreenCaptureFromPath(ss);
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}
}