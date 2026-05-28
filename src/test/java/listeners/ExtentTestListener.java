package listeners;

import base.BaseTest;

import com.aventstack.extentreports.Status;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        BaseTest.test.get().log(
                Status.INFO,
                "Starting Test: " + result.getName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        BaseTest.test.get().log(
                Status.PASS,
                "Test Passed: " + result.getName()
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        BaseTest.test.get().log(
                Status.FAIL,
                "Test Failed: " + result.getName()
        );

        BaseTest.test.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        BaseTest.test.get().log(
                Status.SKIP,
                "Test Skipped: " + result.getName()
        );
    }
}

