package SeleniumTopic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


@Listeners(ITestListener.class)
public class Selenium_other_methods {
    WebDriver driver;
    public static ExtentSparkReporter spark;
    public static ExtentReports extent;
    public static ExtentTest logger;

   @BeforeTest
   public void startReport() {
       ExtentReports extent = new ExtentReports();
       // Create an object of Extent Reports
       extent = new ExtentReports();

       spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
       extent.attachReporter(spark);
       extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
       extent.setSystemInfo("Environment", "Production");
       extent.setSystemInfo("User Name", "Rajkumar SM");
       spark.config().setDocumentTitle("Title of the Report Comes here ");
       // Name of the report
       spark.config().setReportName("Name of the Report Comes here ");
       // Dark Theme
       spark.config().setTheme(Theme.STANDARD);
   }
    @BeforeMethod
    public void Setup(){

        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver_win.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }
    public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }
    @Test(priority = 1,enabled = true)
    public void get_title(){
        driver.get("https://demo.automationtesting.in/Register.html");
        logger = extent.createTest("To verify Register Title");
        Assert.assertEquals(driver.getTitle(),"Register");

    }
    @Test(priority = 1,enabled = true)
        public void image_present(){
        driver.get("https://demo.automationtesting.in/Register.html");
            Boolean img = driver.findElement(By.xpath("//img[@alt='image not displaying']")).isDisplayed();
            logger.createNode("Image is present");
            Assert.assertTrue(img);
            logger.createNode("Image is not present");
            Assert.assertFalse(img);
        }

    @Test(priority = 1, enabled = true)
    public void Selection_Dropdown() throws InterruptedException {
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"msdd\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class ='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']")));
        //driver.findElement(By.xpath("//*[@class ='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']");
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]")).click();
        // scroll to the element on the page
        Thread.sleep(5000);

    }
    @Test(priority = 1, enabled = true)
    public void Scroll_using_javascript() throws InterruptedException {
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='secondpassword']")));
        Thread.sleep(10000);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        // scroll to the element on the page
        WebElement element2 = driver.findElement(By.xpath("//button[@id='submitbtn']"));
        js.executeScript("arguments[0].scrollIntoView();",element2 );
        Thread.sleep(10000);

        // scroll to the bottom of the page
        //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        // scroll by the specific pixels
        //js.executeScript("window.scrollBy(0,1000);");

    }
    @Test(priority = 2, enabled = true)
    public void DragAndDrop() throws InterruptedException {

        driver.get("https://demo.automationtesting.in/Dynamic.html");
        driver.manage().window().maximize();
        WebElement from =driver.findElement(By.xpath("//img[@src='logo.png']"));
        WebElement to =driver.findElement(By.xpath("//div[@id='droparea']"));
        Actions builder = new Actions(driver);
        builder.dragAndDrop(from,to).perform();
        Thread.sleep(5000);

    }
    @Test(priority = 3, enabled = true)
    public void Verify(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.fail("First fail");
        System.out.println("Failing first the excution");

        softAssert.fail("Second fail");
        System.out.print("failing second the excution");


    }
    @Test(priority = 3, enabled = false)
    //@Given("^user is already on Login Page$")
    public void Frames_Switching() throws InterruptedException {

        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.findElement(By.xpath("//div[@class='tabpane']/ul/li[2]")).click();
        Thread.sleep(10000);

        // String s = "iframe-container";
        driver.switchTo().frame(1);
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@class=\"col-xs-6 col-xs-offset-5\"]//input")).sendKeys("aditya");

    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception{
        if(result.getStatus() == ITestResult.FAILURE){
        //MarkupHelper is used to display the output in different colors
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
        //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
        //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.
        //String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
            String screenshotPath = getScreenShot(driver, result.getName());
        //To add it in the extent report
            logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
        }
        else if(result.getStatus() == ITestResult.SKIP){
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        driver.quit();
    }
    @AfterTest
    public void endReport() {
        extent.flush();
    }

}

