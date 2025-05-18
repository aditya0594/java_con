import SeleniumTopic.ITestListener;
import SeleniumTopic.Selenium_other_methods;
import com.aventstack.extentreports.ExtentReports;
    import com.aventstack.extentreports.ExtentTest;
    import com.aventstack.extentreports.MediaEntityBuilder;
    import com.aventstack.extentreports.Status;
    import com.aventstack.extentreports.reporter.ExtentSparkReporter;
    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.chrome.ChromeOptions;
    import org.openqa.selenium.edge.EdgeOptions;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.firefox.FirefoxOptions;
    import org.openqa.selenium.ie.InternetExplorerDriver;
    import org.openqa.selenium.ie.InternetExplorerOptions;
    import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.remote.RemoteWebDriver;
    import org.testng.ITestResult;
    import org.testng.annotations.*;
    import org.testng.asserts.SoftAssert;

    import java.io.File;
    import java.net.MalformedURLException;
    import java.net.URL;
    import java.time.Duration;
    import java.util.HashMap;
    import java.util.Map;

    @Listeners(ITestListener.class)
    public class Selenium_Suite {
        WebDriver driver;
        static ExtentReports extent;
        static ExtentTest test;

        @BeforeClass
        public static void setUpReport() {
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/SuiteReport.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        @Parameters("browser")
        @BeforeMethod
        public void Setup(String browser) throws MalformedURLException {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
            }
            else if(browser.equalsIgnoreCase("Remote_Chrome")){
                    ChromeOptions browserOptions = new ChromeOptions();
                    browserOptions.setPlatformName("Windows 11");
                    browserOptions.setBrowserVersion("latest");
                    Map<String, Object> sauceOptions = new HashMap<>();
                    sauceOptions.put("username", "oauth-adityapawar180-d07bc");
                    sauceOptions.put("accessKey", "9fa283b2-0e5f-41f7-8dcb-d178f729608a");
                    sauceOptions.put("build", "selenium-build-O3A6O");
                    sauceOptions.put("name", "<Java Con>");
                    browserOptions.setCapability("sauce:options", sauceOptions);
                    URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                     driver = new RemoteWebDriver(url, browserOptions);

            }
            else if(browser.equalsIgnoreCase("Remote_Firefox")){
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", "oauth-adityapawar180-d07bc");
                sauceOptions.put("accessKey", "9fa283b2-0e5f-41f7-8dcb-d178f729608a");
                sauceOptions.put("build", "selenium-build-O3A6O");
                sauceOptions.put("name", "<Java Con>");
                browserOptions.setCapability("sauce:options", sauceOptions);
                URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                driver = new RemoteWebDriver(url, browserOptions);

            }
            else if(browser.equalsIgnoreCase("Remote_Edge")){
                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", "oauth-adityapawar180-d07bc");
                sauceOptions.put("accessKey", "9fa283b2-0e5f-41f7-8dcb-d178f729608a");
                sauceOptions.put("build", "selenium-build-O3A6O");
                sauceOptions.put("name", "<Java Con>");
                browserOptions.setCapability("sauce:options", sauceOptions);
                URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                driver = new RemoteWebDriver(url, browserOptions);

            }
            else if(browser.equalsIgnoreCase("Remote_Firefox")){
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", "oauth-adityapawar180-d07bc");
                sauceOptions.put("accessKey", "9fa283b2-0e5f-41f7-8dcb-d178f729608a");
                sauceOptions.put("build", "selenium-build-O3A6O");
                sauceOptions.put("name", "<Java Con>");
                browserOptions.setCapability("sauce:options", sauceOptions);
                URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                driver = new RemoteWebDriver(url, browserOptions);

            }
            else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                //options.addArguments("--headless");
                driver = new FirefoxDriver(options);
            } else if (browser.equalsIgnoreCase("IE")) {
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions options = new InternetExplorerOptions();
                options.ignoreZoomSettings();
                options.introduceFlakinessByIgnoringSecurityDomains();
                driver = new InternetExplorerDriver(options);
            } else if (browser.equalsIgnoreCase("webdrivermanager")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
            }
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/SuiteReport.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
        }

        @AfterMethod
        public void getResult(ITestResult result) throws Exception {
            if (result.getStatus() == ITestResult.FAILURE) {
                test.log(Status.FAIL, result.getName() + " - Test Case Failed");
                test.log(Status.FAIL, result.getThrowable() + " - Test Case Failed");
                test.fail(result.getThrowable());
                String screenshotPath = Selenium_other_methods.getScreenShot(driver, result.getName());
                System.out.println("Screenshot Path: " + screenshotPath);
                File screenshotFile = new File(screenshotPath);
                if (screenshotFile.exists()) {
                    test.fail("Test Case Failed Snapshot is below:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                } else {
                    test.fail("Screenshot not found at: " + screenshotPath);
                }
            } else if (result.getStatus() == ITestResult.SKIP) {
                test.log(Status.SKIP, result.getName() + " - Test Case Skipped");
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.log(Status.PASS, result.getName() + " - Test Case PASSED");
            }
            driver.quit();
        }

        @AfterClass
        public void endReport() {
            if (extent != null) {
                extent.flush();
            }
        }
        @Test(priority = 1, enabled = true, groups = {"Smoke", "Regression"})
        public void Scroll_using_javascript() throws InterruptedException {
            test = extent.createTest("This the javascript for scrolling");
            driver.get("https://demo.automationtesting.in/Register.html");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement element2 = driver.findElement(By.xpath("//button[@id='Button1']"));
            js.executeScript("arguments[0].scrollIntoView();", element2);
            Thread.sleep(10000);
            test.pass("Scrolled to the element");
        }

        @Test(priority = 2, enabled = true, groups = {"Regression"})
        public void Scroll_using_javascript_bottom_page() throws InterruptedException {
            test = extent.createTest("This the javascript to the bottom of page");
            driver.get("https://demo.automationtesting.in/Register.html");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
            test.pass("Scrolled javascript to the bottom of page");
        }

        @Test(priority = 3, enabled = true, groups = {"Regression"})
        public void Scroll_using_javascript_specific_pixels() throws InterruptedException {
            test = extent.createTest("This the javascript to the specific pixel");
            driver.get("https://demo.automationtesting.in/Register.html");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000);");
            test.pass("Scrolled javascript to the specific pixel");
        }

        @Test(priority = 4, enabled = true, groups = {"Smoke", "UI"},invocationCount = 2)
        public void DragAndDrop() throws InterruptedException {
            test = extent.createTest("Drag and drop image");
            driver.get("https://demo.automationtesting.in/Dynamic.html");
            WebElement from = driver.findElement(By.xpath("//img[@id='angular']"));
            WebElement to = driver.findElement(By.xpath("//div[@id='droparea']"));
            Actions actions = new Actions(driver);
            actions.dragAndDrop(from, to).perform();
            Thread.sleep(5000);
            test.pass("Image Drag");
        }

        @Test(priority = 5, enabled = true, groups = {"Regression"})
        public void Verify() {
            test = extent.createTest("Verify functions");
            SoftAssert softAssert = new SoftAssert();

            System.out.println("Failing first the execution");
            softAssert.fail("First fail");

            System.out.println("Failing second the execution");
            softAssert.fail("Second fail");

            try {
                softAssert.assertAll();
                test.pass("All soft assertions passed");
            } catch (AssertionError e) {
                test.fail("Soft assertion failures: " + e.getMessage());
                throw e; // Re-throw to mark test as failed in TestNG
            }
        }

        @Test(priority = 6, enabled = true, groups = {"Smoke"}, dependsOnMethods = {"DragAndDrop"})
        public void rightClick() throws InterruptedException {
            test = extent.createTest("Right click on the element");
            driver.get("https://practice.automationtesting.in/");
            Thread.sleep(6000);

            Actions actions = new Actions(driver);
            WebElement rightClickElement = driver.findElement(By.xpath("//img[@title='Automation Practice Site']"));
            actions.contextClick(rightClickElement).build().perform();

            Thread.sleep(1000);
            test.pass("Right click performed");
        }
    }
