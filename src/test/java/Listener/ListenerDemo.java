package Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Execution has been started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Method" + " " +  result.getName()+  " " + " has been successfully executed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Method" + " " + result.getName() +  " " + " has been failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Method" + " " +  result.getName() +  " " + " has been skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Started the listener");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("End of listener");
    }
}
