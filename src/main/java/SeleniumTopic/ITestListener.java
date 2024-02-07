package SeleniumTopic;


import org.testng.ITestContext;
import org.testng.ITestResult;

public class ITestListener implements org.testng.ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        org.testng.ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("The name of the testcase passed is :"+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
       // org.testng.ITestListener.super.onTestFailure(result);
        System.out.println("The name of the testcase failed is :"+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("The name of the testcase Skipped is :"+result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        org.testng.ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        org.testng.ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println(context.getName()+" test case started");
    }

    @Override
    public void onFinish(ITestContext context) {

        org.testng.ITestListener.super.onFinish(context);
    }
}

