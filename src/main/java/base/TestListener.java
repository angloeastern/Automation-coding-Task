package base;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListener extends Base implements ITestListener {
	
	

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
		Log.info(result.getMethod().getMethodName() + " Started");
		Log.info(result.getMethod().getDescription());
		ExtentManager.getInstance().flush();

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		//ExtentTestManager.getTest().log(Status.PASS,
		//		"" + result.getMethod().getMethodName() + "  test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName() + " - Test Case Passed", ExtentColor.GREEN));
		Log.info(result.getMethod().getMethodName() + " Passed");

		
		String ss=null;
		try {
			ss = Base.getScreenShot(System.getProperty("user.dir") + "\\" + result.getMethod().getMethodName()
					+ "\\ScreenShotsDetails\\" + Base.getDateTimeStamp() + ".png");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentTestManager.getTest().addScreenCaptureFromPath(ss);
		ExtentManager.getInstance().flush();
	}

	public void onTestFailure(ITestResult result) {
		String ss=null;
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		//ExtentTestManager.getTest().log(Status.FAIL, "" + result.getMethod().getMethodName() + "  Test Failed");
		ExtentTestManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName() + " - Test Case Failed", ExtentColor.RED));
		ExtentTestManager.getTest().log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		Log.error("Failed because of - " + result.getThrowable());
		ExtentTestManager.getTest().info(result.getThrowable());
		
		
		try {
			ss = Base.getScreenShot(System.getProperty("user.dir") + "\\" + result.getMethod().getMethodName()
					+ "\\ScreenShotsDetails\\" + Base.getDateTimeStamp() + ".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ExtentTestManager.getTest().generateLog(Status.FAIL, MarkupHelper.createCodeBlock(ss));
		ExtentTestManager.getTest().addScreenCaptureFromPath(ss);
		ExtentManager.getInstance().flush();
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "" + result.getMethod().getMethodName() + "Test Skipped");
		ExtentTestManager.getTest().info(result.getThrowable());
		Log.info("Skipped because of - " + result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}
}