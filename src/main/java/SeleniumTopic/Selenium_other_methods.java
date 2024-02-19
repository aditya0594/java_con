package SeleniumTopic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
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


    @BeforeMethod
    public void Setup(){

        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver_win.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

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
        logger = extent.createTest("To verify Register Title");
        driver.get("https://demo.automationtesting.in/Register.html");
        Assert.assertEquals(driver.getTitle(),"Register");
        logger.log(Status.PASS, "Title passed successfully.");

    }
    @Test(priority = 2,enabled = true)
        public void image_present(){
        logger = extent.createTest("To verify Image on the Register page");
        driver.get("https://demo.automationtesting.in/Register.html");
            Boolean img = driver.findElement(By.xpath("//img[@alt='image not displaying']")).isDisplayed();
            Assert.assertTrue(img);
            logger.log(Status.PASS,"Image is displayed");

        }

    @Test(priority = 3, enabled = true)
    public void Selection_Dropdown() throws InterruptedException {
        logger = extent.createTest("Select the seletion in the dropdown ");
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"msdd\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class ='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']")));
        //driver.findElement(By.xpath("//*[@class ='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']");
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]")).click();
        // scroll to the element on the page
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // scroll to the element on the page
        WebElement element2 = driver.findElement(By.xpath("//input[@id='secondpassword']"));
        js.executeScript("arguments[0].scrollIntoView();", element2);
        Thread.sleep(5000);
        Boolean Englishlang =driver.findElement(By.xpath("//div[@class='ui-autocomplete-multiselect-item']")).isDisplayed();
        //div[@class='ui-autocomplete-multiselect-item']
        Assert.assertTrue(Englishlang);
        driver.findElement(By.xpath("//div[6]")).click();
        logger.log(Status.PASS,"The English language is selected in dropdown");

    }
    @Test(priority = 4, enabled = true)
    public void Scroll_using_javascript() throws InterruptedException {
        logger = extent.createTest("Scroll using the javascript");
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
        boolean element_visible  = driver.findElement(By.xpath("//button[@id='submitbtn']")).isDisplayed();
        Assert.assertTrue(element_visible);
        logger.log(Status.PASS,"Scrolled on the element");

        // scroll to the bottom of the page
        //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        // scroll by the specific pixels
        //js.executeScript("window.scrollBy(0,1000);");

    }
    @Test(priority = 5, enabled = true)
    public void DragAndDrop() throws InterruptedException {
        logger = extent.createTest("Drag and drop the element");
        driver.get("https://demo.automationtesting.in/Dynamic.html");
        driver.manage().window().maximize();
        WebElement from =driver.findElement(By.xpath("//img[@src='logo.png']"));
        WebElement to =driver.findElement(By.xpath("//div[@id='droparea']"));
        Actions builder = new Actions(driver);
        builder.dragAndDrop(from,to).perform();
        Thread.sleep(5000);
        boolean draaganddrop_element_visib  = driver.findElement(By.xpath("//div[@id='droparea']")).isDisplayed();
        Assert.assertTrue(draaganddrop_element_visib);
        logger.log(Status.PASS,"Element dragged");


    }
    @Test(priority = 6, enabled = true)
    public void Verify(){
        logger = extent.createTest("Verify the SOFT ASSERT");
        SoftAssert softAssert = new SoftAssert();
        softAssert.fail("First fail");
        System.out.println("Failing first the excution");

        softAssert.fail("Second fail");
        System.out.print("failing second the excution");
        logger.log(Status.PASS,"Verify soft assert");

    }
    @Test(priority = 7, enabled = false)
    //@Given("^user is already on Login Page$")
    public void Frames_Switching() throws InterruptedException {
        logger = extent.createTest("Frame Switching verify");
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.findElement(By.xpath("//div[@class='tabpane']/ul/li[2]")).click();
        Thread.sleep(10000);

        // String s = "iframe-container";
        driver.switchTo().frame(1);
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@class=\"col-xs-6 col-xs-offset-5\"]//input")).sendKeys("aditya");

    }

    @AfterTest
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

        } else if(result.getStatus() == ITestResult.SKIP){
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        } else if(result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        }
    extent.flush();

    }
    @AfterMethod
    public void endReport() {
        driver.quit();
        //extent.flush();
    }

}

