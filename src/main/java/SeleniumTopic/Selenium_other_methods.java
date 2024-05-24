package SeleniumTopic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Listeners(ITestListener.class)
public class Selenium_other_methods {
    WebDriver driver;
    ExtentSparkReporter spark;
    ExtentReports extent;

    //https://the-internet.herokuapp.com/
    //https://demo.automationtesting.in/Register.html
    //https://googlechromelabs.github.io/chrome-for-testing/
    @BeforeMethod
    public void Setup(){

        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

      /*  WebDriverManager.chromedriver().driverVersion("121.0.6167.161").setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);*/

        //Implicitly wait
        //Implicitly wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //explicit wait
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));*/

        /*Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoAlertPresentException.class);
*/

    }
    @BeforeTest
    public void report(){

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
    @FindBy(xpath="user_login")WebElement userId;

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

    @FindBy(id = "searchBox")
    private WebElement searchBar;


    @Test(priority = 1,enabled = true)
    public void Window_Basic_Auth(){
        ExtentTest test = extent.createTest("To verify username and password in chrome base browser ");
        //driver.get("https://demo.automationtesting.in/Register.html");
        driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        test.pass("To verify username and password in chrome base browser ");

    }
    @Test(priority = 1,enabled = true)
    public void get_title(){
        ExtentTest test = extent.createTest("To verify Register Title");
        String ActualURL = ("https://demo.automationtesting.in/Register.html");
        driver.navigate().to("https://demo.automationtesting.in/Register.html");

        Assert.assertEquals(driver.getCurrentUrl(),ActualURL);

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

        js.executeScript("arguments[0].scrollIntoView(true);",element2 );

        Thread.sleep(10000);


        // scroll to the bottom of the page
        //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        // scroll by the specific pixels
        //js.executeScript("window.scrollBy(0,1000);");

        test.pass("Scroll using java script");
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
        softAssert.assertAll();

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
        driver.switchTo().frame(1);   // index ,frameelement , name or ID
        Thread.sleep(10000);


        driver.findElement(By.xpath("//div[@class=\"col-xs-6 col-xs-offset-5\"]//input")).sendKeys("aditya");
        test.pass("frames switching testcase ");
    }

    @Test(priority = 8, enabled = true)
    public void rightClick() throws InterruptedException {
        ExtentTest test = extent.createTest("Right click on the element");
        driver.get("https://practice.automationtesting.in/");
        driver.manage().window().maximize();
        Thread.sleep(6000);


        Actions actions = new Actions(driver);
        WebElement rightClickElemen = driver.findElement(By.xpath("//img[@title='Automation Practice Site']"));

        actions.contextClick(rightClickElemen).build().perform();

        //actions.doubleClick(element).perform();  // To perform a double click, use the doubleClick method:


        // actions.moveToElement(elementToHover).click().perform();    // Perform mouse hover and click



        Thread.sleep(1000);
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
        String filePath = "Utils/test_image.png";
       // Copy file path to clipboard
        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

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
        driver.get("https://practice.automationtesting.in/my-account/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

    }
    public static String excelreaddata(int datarow, int datacell) throws IOException{
        FileInputStream fis = new FileInputStream("src/main/resources/ExcelFile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(datarow);
        Cell cell = row.createCell(datacell);
        return cell.getStringCellValue();
    }

    @DataProvider(name = "loginDataProviderExcel")
    public Object[] [] excel_loginData() throws IOException {

        String userEmail  = excelreaddata(0,0);
        String userPassword  = excelreaddata(0,1);
        System.out.println("Details : " + userEmail +" "+userPassword);
        return new Object [] []

                {
                        {userEmail,userPassword}
                };

    }
    @Test(priority =10, enabled = true,dataProvider = "loginDataProviderExcel")
    public void Excel_Dataproviders(String username , String password){

        // DataProvider is like a container that passes
        //the data to our test methods so that our single test method can execute itself with multiple data sets.
        ExtentTest test = extent.createTest("Right click on the element");
        driver.get("https://practice.automationtesting.in/my-account/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

    }
    @Test(priority = 11, enabled = true)
    //@Given("^user is already on Login Page$")
    public void Windows_Switching() throws InterruptedException {

        driver.get("https://demo.automationtesting.in/Windows.html");
        // Get parent window handle // it will give to current window
        String parentWindowHandle = driver.getWindowHandle();
        // Click the link/button to open a new window or tab
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

        System.out.println("Parent window name :" + parentWindowHandle);
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
    @Test(priority = 11, enabled = true)
    public void FluentWait() throws InterruptedException {
        ExtentTest test = extent.createTest("Drag and drop element");
        driver.get("https://demo.automationtesting.in/Dynamic.html");
        driver.manage().window().maximize();

        //Fluent Wait

        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(45))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoAlertPresentException.class);

        WebDriverWait explicit=  new WebDriverWait(driver,Duration.ofSeconds(10));
        explicit.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='droparea']"))));


                WebElement from =driver.findElement(By.xpath("//img[@src='logo.png']"));
        WebElement to =driver.findElement(By.xpath("//div[@id='droparea']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(from,to).perform();
        Thread.sleep(5000);
        test.pass("Element draged properly");
    }
    @Test(priority = 11, enabled = true)
    public void ExcelFileRead() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Excel file to read");

        //I have placed an excel file 'Test.xlsx' in my D Driver
        FileInputStream fis = new FileInputStream("src/main/resources/ExcelFile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
        XSSFSheet Sheet = workbook.getSheetAt(0);
        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.

        Row row = Sheet.getRow(0);
        Cell cell = row.getCell(0);

        System.out.println(cell);
        System.out.println("-----------------------------------------------");
        System.out.println(Sheet.getRow(0).getCell(0));
        //String cellval = cell.getStringCellValue();
        //System.out.println(cellval);
        Thread.sleep(5000);
        test.pass("Excel file to read");
    }
    @Test(priority = 11, enabled = true)
    public void Write_ExcelFile() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Excel file to read");

        //I have placed an excel file 'Test.xlsx' in my D Driver
        FileInputStream fis = new FileInputStream("src/main/resources/ExcelFile.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
        XSSFSheet Sheet = workbook.getSheetAt(0);

        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.

        Row row = Sheet.createRow(1);
        Cell cell = row.createCell(0);

        //Entering the value in the cell
        cell.setCellValue("aditya");

        FileOutputStream fos = new FileOutputStream("src/main/resources/ExcelFile.xlsx");
        workbook.write(fos);
        fos.close();


    }
    @Test(priority = 12, enabled = true)
    public void NAVIGATE() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Excel file to read");
       // driver.get("www.google.com");
        driver.navigate().to("https://www.google.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();



    }
    @Test(priority = 13, enabled = true)
    public void ALERT() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Excel file to read");
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert.dismiss();
        alert.sendKeys("");


        Select select = new Select(driver.findElement(By.xpath("//*[@class='adb']")));
    }
    @Test(priority = 14, enabled = true)
    public void window_file() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Excel file to read");
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Click on the file upload input to open the file dialog
        driver.findElement(By.xpath("//input[@id='file-upload']")).click();
        Thread.sleep(2000);

        // Create and start the process using ProcessBuilder
        ProcessBuilder processBuilder = new ProcessBuilder("C:/GAED/src/resources/FileUpload.exe");
        Process process = processBuilder.start();
        process.waitFor(); // Ensure the process completes

        // Submit the file upload form
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        Thread.sleep(10000);
    }

    public void Find_all_links() {
        try {
            // Open the web page
            driver.get("https://example.com");

            // Find all link elements
            List<WebElement> links = driver.findElements(By.tagName("Link"));

            // Print each link's URL
            for (WebElement link : links) {
                System.out.println(link.getAttribute("href"));
            }

        }catch (ArithmeticException e){
            System.out.println("This is demo ");
        }
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

