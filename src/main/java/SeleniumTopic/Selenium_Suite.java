package SeleniumTopic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;

import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
@Listeners(ITestListener.class)
public class Selenium_Suite {
        WebDriver driver;
        ExtentReports extent;
   @Parameters("browser")
       @BeforeMethod
        public void Setup(String browser){

           if(browser.equalsIgnoreCase("chrome")){
               System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
               ChromeOptions options = new ChromeOptions();
               options.addArguments("--remote-allow-origins=*");
               options.addArguments("--headless");  // Enable headless mode
               options.addArguments("--disable-gpu"); // Applicable to Windows environment
               options.addArguments("--window-size=1920,1080"); // Set the window size
               driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
               driver.manage().window().maximize();
            }
            else if(browser.equalsIgnoreCase("firefox")){
               System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
               FirefoxOptions options = new FirefoxOptions();
              options.addArguments("--headless");  // Enable headless mode
               options.addArguments("--window-size=1920,1080"); // Set the window size
               driver = new FirefoxDriver(options);
            }
            else if (browser.equalsIgnoreCase("IE")){
               System.setProperty("webdriver.ie.driver", "Driver/IEDriverServer.exe");
               InternetExplorerOptions options = new InternetExplorerOptions();
               options.ignoreZoomSettings(); // Ignore the Zoom level settings
               options.introduceFlakinessByIgnoringSecurityDomains(); // Ignore security domains settings
               driver = new InternetExplorerDriver(options);
            }
            else if (browser.equalsIgnoreCase("webdrivermanager")){
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);
            }

        }
        @BeforeTest
        public void report(){

            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/SuiteReport.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        @Test(priority = 1, enabled = true)
        public void Scroll_using_javascript() throws InterruptedException {
           ExtentTest test = extent.createTest("This the javascript for scrolling");
            driver.get("https://demo.automationtesting.in/Register.html");


            JavascriptExecutor js = (JavascriptExecutor)driver;
            // scroll to the element on the page
                WebElement element2 = driver.findElement(By.xpath("//button[@id='Button1']"));
                js.executeScript("arguments[0].scrollIntoView();",element2 );
                Thread.sleep(10000);
                test.pass("Scrolled to the element");
        }
        @Test(priority = 2, enabled = true)
    public void Scroll_using_javascript_bottom_page() throws InterruptedException {
           ExtentTest test = extent.createTest("This the javascript to the bottom of page ");
        driver.get("https://demo.automationtesting.in/Register.html");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        // scroll to the element on the page
        WebElement element2 = driver.findElement(By.xpath("//button[@id='Button1']"));

        // scroll to the bottom of the page
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        test.pass("Scrolled javascript to the bottom of page");
    }
    @Test(priority = 3, enabled = true)
    public void Scroll_using_javascript_specific_pixels() throws InterruptedException {
        ExtentTest test = extent.createTest("This the javascript to the specific pixel ");
        driver.get("https://demo.automationtesting.in/Register.html");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000);");
        test.pass("Scrolled javascript to the  to the specific pixel");
    }

    @Test(priority = 4, enabled = true,invocationCount = 1)
    public void DragAndDrop() throws InterruptedException {
        ExtentTest test = extent.createTest("Drag and drop image");
        driver.get("https://demo.automationtesting.in/Dynamic.html");
        WebElement from =driver.findElement(By.xpath("//img[@id='angular']"));
        WebElement to =driver.findElement(By.xpath("//div[@id='droparea']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(from,to).perform();
        //actions.contextClick(from);
        //actions.click();
        //actions.moveToElement(from);
        //actions.doubleClick(from);
        //actions.clickAndHold().perform();
        Thread.sleep(5000);
        test.pass("Image Drag");

    }
    @Test(priority = 5, enabled = true)
    public void Verify(){
        ExtentTest test = extent.createTest("Verify functions ");
        SoftAssert softAssert = new SoftAssert();
        softAssert.fail("First fail");
        System.out.println("Failing first the excution");
        softAssert.fail("Second fail");
        System.out.print("failing second the excution");
        test.pass("Verified");
    }
    @Test(priority = 6, enabled = true)
    //@Given("^user is already on Login Page$")
    public void rightClick() throws InterruptedException {
        ExtentTest test = extent.createTest("Right click on the element");
        driver.get("https://practice.automationtesting.in/");
        Thread.sleep(6000);


        Actions actions = new Actions(driver);
        WebElement rightClickElemen = driver.findElement(By.xpath("//img[@title='Automation Practice Site']"));

        actions.contextClick(rightClickElemen).build().perform();

        //actions.doubleClick(element).perform();  // To perform a double click, use the doubleClick method:
        // actions.moveToElement(elementToHover).click().perform();    // Perform mouse hover and click

        Thread.sleep(1000);
        test.pass("Right click performed");
    }
    @AfterTest
    public void endReport() {
           extent.flush();
    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception{
        ExtentTest test;
        if(result.getStatus() == ITestResult.FAILURE) {
            // Executed when a test method fails
            test = extent.createTest(result.getName() + " - Test Case Failed");
            test.log(Status.FAIL, result.getName() + " - Test Case Failed");
            test.log(Status.FAIL, result.getThrowable() + " - Test Case Failed");

            // Capture screenshot
            String screenshotPath = Selenium_other_methods.getScreenShot(driver, result.getName());
            test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));

        } else if(result.getStatus() == ITestResult.SKIP) {
            // Executed when a test method is skipped
            test = extent.createTest(result.getName() + " - Test Case Skipped");
            test.log(Status.SKIP, result.getName() + " - Test Case Skipped");
        } else if(result.getStatus() == ITestResult.SUCCESS) {
            // Executed when a test method passes
            test = extent.createTest(result.getName() + " - Test Case PASSED");
            test.log(Status.PASS, result.getName() + " - Test Case PASSED");
        }
        driver.quit();
    }


}
