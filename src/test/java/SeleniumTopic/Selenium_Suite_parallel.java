package SeleniumTopic;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


//@Test(priority = 2, enabled = true, groups = {"Regression"},retryAnalyzer = IRetryAnalyzer.class
//or
// @Listerners(IRetryAnalyzer)
    @Listeners(ITestListener.class)

    public class Selenium_Suite_parallel {

        private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
        static ExtentReports extent;
        static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

        public WebDriver getDriver() {
            return driver.get();
        }

        @BeforeClass
        public static void setUpReport() {
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
            // Save everything locally (not from CDN)
            htmlReporter.config().setTimelineEnabled(true);
            htmlReporter.config().setEncoding("utf-8");
            htmlReporter.config().setReportName("Test Report");
            htmlReporter.config().setDocumentTitle("Automation Test Results");


            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }

        @Parameters("browser")
        @BeforeMethod
        public void Setup(String browser) throws MalformedURLException {
            WebDriver localDriver = null;

            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
               options.addArguments("--remote-allow-origins=*");
                localDriver = new ChromeDriver(options);
            } else if (browser.equalsIgnoreCase("Remote_Chrome")) {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", "oauth-adityapawar180-d07bc");
                sauceOptions.put("accessKey", "9fa283b2-0e5f-41f7-8dcb-d178f729608a");
                sauceOptions.put("build", "selenium-build-O3A6O");
                sauceOptions.put("name", "Java Con");
                browserOptions.setCapability("sauce:options", sauceOptions);
                URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                localDriver = new RemoteWebDriver(url, browserOptions);
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                //options.addArguments("--headless");
                localDriver = new FirefoxDriver(options);
            } else if (browser.equalsIgnoreCase("IE")) {
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions options = new InternetExplorerOptions();
                options.ignoreZoomSettings();
                options.introduceFlakinessByIgnoringSecurityDomains();
                localDriver = new InternetExplorerDriver(options);
            }
            else if (browser.equalsIgnoreCase("grid_chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                URL gridUrl = new URL("http://172.28.0.1:5555");
                localDriver = new RemoteWebDriver(gridUrl, options);
            }

            else if (browser.equalsIgnoreCase("grid_firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                URL gridUrl = new URL("http://172.28.0.1:5555");
                localDriver = new RemoteWebDriver(gridUrl, options);
            }

            localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            localDriver.manage().window().maximize();
            driver.set(localDriver);
        }

        public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {

            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            // Ensure directory exists
            File screenshotDir = new File(System.getProperty("user.dir") + "/Screenshots/");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            // Save screenshot
            String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);

            return finalDestination.getAbsolutePath();
        }
        @AfterMethod
        public void getResult(ITestResult result) throws Exception {
            ExtentTest extentTest = test.get();
            WebDriver localDriver = getDriver();

            if (result.getStatus() == ITestResult.FAILURE) {
                extentTest.log(Status.FAIL, result.getName() + " - Test Case Failed");
                extentTest.log(Status.FAIL, result.getThrowable() + " - Test Case Failed");
                String screenshotPath = Selenium_Suite_parallel.getScreenShot(localDriver, result.getName());
                File screenshotFile = new File(screenshotPath);
                if (screenshotFile.exists()) {
                    extentTest.fail("Test Case Failed Snapshot is below:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                } else {
                    extentTest.fail("Screenshot not found at: " + screenshotPath);
                }
            } else if (result.getStatus() == ITestResult.SKIP) {
                extentTest.log(Status.SKIP, result.getName() + " - Test Case Skipped");
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                extentTest.log(Status.PASS, result.getName() + " - Test Case PASSED");
            }

            if (localDriver != null) {
                localDriver.quit();
                driver.remove();
            }
            test.remove();
        }

        @AfterClass
        public void endReport() {
            if (extent != null) {
                extent.flush();
            }
        }

        @Test(priority = 1, enabled = true, groups = {"Smoke"})
        public void Scroll_using_javascript() throws InterruptedException {
            ExtentTest extentTest = extent.createTest("This is the javascript for scrolling");
            test.set(extentTest);
            WebDriver localDriver = getDriver();

            localDriver.get("https://demo.automationtesting.in/Register.html");
            JavascriptExecutor js = (JavascriptExecutor) localDriver;
            WebElement element2 = localDriver.findElement(By.xpath("//button[@id='Button1']"));
            js.executeScript("arguments[0].scrollIntoView();", element2);
            Thread.sleep(5000);
            extentTest.pass("Scrolled to the element");
        }

        @Test(priority = 2, enabled = true, groups = {"Regression"},retryAnalyzer = RetryAnalyzer_IRetryAnalyzer.class)
        public void Scroll_using_javascript_bottom_page() {
            ExtentTest extentTest = extent.createTest("Scroll to bottom using javascript");
            test.set(extentTest);
            WebDriver localDriver = getDriver();
            localDriver.get("https://demo.automationtesting.in/Register.html");
            JavascriptExecutor js = (JavascriptExecutor) localDriver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            extentTest.pass("Scrolled to the bottom of the page");
        }

        @Test(priority = 3, enabled = true, groups = {"Regression"})
        public void Scroll_using_javascript_specific_pixels() {
            ExtentTest extentTest = extent.createTest("Scroll to specific pixel using javascript");
            test.set(extentTest);
            WebDriver localDriver = getDriver();

            localDriver.get("https://demo.automationtesting.in/Register.html");
            JavascriptExecutor js = (JavascriptExecutor) localDriver;
            js.executeScript("window.scrollBy(0,1000);");
            extentTest.pass("Scrolled by 1000 pixels");
        }

        @Test(priority = 4, enabled = true, groups = {"UI"}, invocationCount = 2)
        public void DragAndDrop() throws InterruptedException {
            ExtentTest extentTest = extent.createTest("Drag and drop image");
            test.set(extentTest);
            WebDriver localDriver = getDriver();

            localDriver.get("https://demo.automationtesting.in/Dynamic.html");
            WebElement from = localDriver.findElement(By.id("angular"));
            WebElement to = localDriver.findElement(By.id("droparea"));

            new Actions(localDriver).dragAndDrop(from, to).perform();
            Thread.sleep(3000);
            extentTest.pass("Drag and drop successful");
        }

        @Test(priority = 5, enabled = true, groups = {"Regression"})
        public void Verify() {
            ExtentTest extentTest = extent.createTest("Soft assertions verification");
            test.set(extentTest);

            SoftAssert softAssert = new SoftAssert();
            softAssert.fail("First failure");
            softAssert.fail("Second failure");

            try {
                softAssert.assertAll();
                extentTest.pass("All soft assertions passed");
            } catch (AssertionError e) {
                extentTest.fail("Soft assertion failures: " + e.getMessage());
                throw e;
            }
        }

        @Test(priority = 6, enabled = true)
        public void rightClick() throws InterruptedException {
            ExtentTest extentTest = extent.createTest("Right click on element");
            test.set(extentTest);
            WebDriver localDriver = getDriver();

            localDriver.get("https://practice.automationtesting.in/");
            Thread.sleep(5000);

            WebElement element = localDriver.findElement(By.xpath("//img[@title='Automation Practice Site']"));
            new Actions(localDriver).contextClick(element).perform();

            extentTest.pass("Right click performed successfully");
        }

    }
