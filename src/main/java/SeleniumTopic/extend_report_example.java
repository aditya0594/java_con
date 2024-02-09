package SeleniumTopic;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class extend_report_example {
    private ExtentReports extent;
    private ExtentTest logger;

    @BeforeMethod
    public void startReport() {
        // Initialize ExtentReports
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Create a test case

    }

    @Test
    public void yourTestMethod() {
        // Your test method logic
        logger = extent.createTest("Your Test Name method");
        logger.log(Status.INFO, "This is a sample test log.");
        logger.log(Status.PASS, "Test case passed successfully.");
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, "Test Case Failed: " + result.getName());
            logger.log(Status.FAIL, "Test Case Failed Reason: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP, "Test Case Skipped: " + result.getName());
        }

        // End the test case
        extent.flush();
    }
}
