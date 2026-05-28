package base;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;

public class ExtentTestListener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        BaseTest.test.log(Status.PASS, result.getName() + " passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        BaseTest.test.log(Status.FAIL, result.getName() + " failed: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        BaseTest.test.log(Status.SKIP, result.getName() + " skipped");
    }
}
