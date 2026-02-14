package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import core.ExtentManager;
import core.ExtentTestManager;
import utils.ScreenshotUtil;

public class CustomListener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		ExtentManager.getInstance(System.getProperty("user.dir") + "\\src\\test\\resources\\reports\\extent.html");
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getMethodName().toUpperCase()+" - Thread: "+Thread.currentThread().getId();
		ExtentTest test = ExtentManager.getExtent().createTest(testName);
		ExtentTestManager.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(Status.PASS, "Test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String screenshotFilePath = ScreenshotUtil.captureScreenshot(result.getName().toUpperCase());
		ExtentTestManager.getTest().log(Status.FAIL, "Test is failed");
		ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotFilePath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(Status.SKIP, "Test is skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentManager.getExtent().flush();
		ExtentTestManager.unLoad();
	}

}
