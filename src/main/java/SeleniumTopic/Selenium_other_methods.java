package SeleniumTopic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Data;
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

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;


@Listeners(ITestListener.class)
public class Selenium_other_methods {
    WebDriver driver;
    ExtentSparkReporter spark;
    ExtentReports extent;



    @BeforeMethod
    public void Setup(){

        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver_win.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

      /*  WebDriverManager.chromedriver().driverVersion("121.0.6167.161").setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);*/

        //Implicitly wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //explicit wait
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));*/

    }
    @BeforeTest
    public void report(){

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
        ExtentTest test = extent.createTest("To verify Register Title");
        driver.get("https://demo.automationtesting.in/Register.html");
        Assert.assertEquals(driver.getTitle(),"Register");
        test.pass("Title passed successfully.");

    }
    @Test(priority = 2,enabled = true)
        public void image_present(){
        ExtentTest test = extent.createTest("To verify Image on the Register page");
        driver.get("https://demo.automationtesting.in/Register.html");
            Boolean img = driver.findElement(By.xpath("//img[@alt='image not displaying']")).isDisplayed();
            Assert.assertTrue(img);
        test.pass("To verify Image passed successfully.");

        }

    @Test(priority = 3, enabled = true)
    public void Selection_Dropdown() throws InterruptedException {
        ExtentTest test = extent.createTest("Select the seletion in the dropdown ");
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
        test.log(Status.PASS,"The English language is selected in dropdown");

    }
    @Test(priority = 4, enabled = true)
    public void Scroll_using_javascript() throws InterruptedException {
        ExtentTest test = extent.createTest("Scroll using java script");
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
        test.pass("Scroll using java script");

        // scroll to the bottom of the page
        //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        // scroll by the specific pixels
        //js.executeScript("window.scrollBy(0,1000);");

    }
    @Test(priority = 5, enabled = true)
    public void DragAndDrop() throws InterruptedException {
        ExtentTest test = extent.createTest("Drag and drop element");
        driver.get("https://demo.automationtesting.in/Dynamic.html");
        driver.manage().window().maximize();
        WebElement from =driver.findElement(By.xpath("//img[@src='logo.png']"));
        WebElement to =driver.findElement(By.xpath("//div[@id='droparea']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(from,to).perform();
        Thread.sleep(5000);
        test.pass("Element draged properly");
    }
    @Test(priority = 6, enabled = true)
    public void Verify(){
        ExtentTest test = extent.createTest("Verify the soft assert");
        SoftAssert softAssert = new SoftAssert();
        softAssert.fail("First fail");
        System.out.println("Failing first the excution");
        softAssert.fail("Second fail");
        System.out.print("failing second the excution");
        test.pass("Verify the soft assert");


    }
    @Test(priority = 7, enabled = true)
    //@Given("^user is already on Login Page$")
    public void Frames_Switching() throws InterruptedException {
        ExtentTest test = extent.createTest("frames switching testcase ");
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='tabpane']/ul/li[2]")).click();
        Thread.sleep(10000);
        // String s = "iframe-container";
        driver.switchTo().frame(1);
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@class=\"col-xs-6 col-xs-offset-5\"]//input")).sendKeys("aditya");
        test.pass("frames switching testcase ");
    }

    @Test(priority = 8, enabled = true)
    public void rightClick(){
        ExtentTest test = extent.createTest("Right click on the element");
        driver.get("https://practice.automationtesting.in/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement rightClickElemen = driver.findElement(By.xpath("//img[@title='Automation Practice Site']"));
        actions.contextClick(rightClickElemen).build().perform();
        test.pass("Right click performed");
    }
    @Test(priority = 9, enabled = true)
    public void image_upload() throws AWTException, InterruptedException {
        driver.get("https://demo.automationtesting.in/FileUpload.html");
        driver.manage().window().maximize();
        //By upload = By.id("//*[@id='imagesrc']");
      //  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
      //  WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-4']")));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement uploadInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-4")));
        boolean element = driver.findElement(By.xpath("//*[@id='input-4']")).isDisplayed();
        if(element = true){
            System.out.println("visible");
            driver.findElement(By.xpath("//*[@id='input-4']")).click();
        }
        else {
            System.out.println("not visible");
        }
        Thread.sleep(5000);
       /* String filePath = "Utils/test_image.png";
        // Copy file path to clipboard
        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);*/

    }
    @DataProvider(name = "loginDataProvider")
    public Object[] [] loginData(){
        return new Object [] []
                {
                        {"aditya@gmail.com","Aditya@123"},
                        {"aditya1@gmail.com","Aditya@123"},
                        {"aditya1@gmail.com","Aditya@123"},
                };
    }
    @Test(priority =10, enabled = true,dataProvider = "loginDataProvider")
    public void Dataproviders(String username , String password){

       // DataProvider is like a container that passes
        //the data to our test methods so that our single test method can execute itself with multiple data sets.
        ExtentTest test = extent.createTest("Right click on the element");
        driver.get("https://practice.automationtesting.in/my-account/");notify();
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

    }
    @Test(priority = 11, enabled = true)
    //@Given("^user is already on Login Page$")
    public void Windows_Switching() throws InterruptedException {

        driver.get("https://demo.automationtesting.in/Windows.html");
// Get parent window handle
        String parentWindowHandle = driver.getWindowHandle();
// Click the link/button to open a new window or tab
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

// Switch to child window
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
// Perform actions in child window
        driver.findElement(By.xpath("//div[@class='collapse navbar-collapse justify-content-end']/ul/li[4]")).click();
        Thread.sleep(10000);
        // Switch back to parent window
        driver.switchTo().window(parentWindowHandle);
        Thread.sleep(10000);


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
            String screenshotPath = getScreenShot(driver, result.getName());
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

    @AfterTest
    public void endReport() {
        extent.flush();
    }

}

