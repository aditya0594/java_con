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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;


@Listeners(ITestListener.class)
public class Selenium_other_methods {


    //https://rahulshettyacademy.com/AutomationPractice/
    //https://the-internet.herokuapp.com/
    //https://demo.automationtesting.in/Register.html
    //https://googlechromelabs.github.io/chrome-for-testing/
    ExtentSparkReporter spark;
    ExtentReports extent;
    protected WebDriver driver;
  @BeforeMethod
  public void setup() throws MalformedURLException {
      driver = Base_Driver_driver.driverInstance("chrome");
  }
    @AfterMethod
    public void teardown(){
        Base_Driver_driver.quit();
    }

    @BeforeTest
    public void report() {

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }


    @FindBy(xpath = "user_login")
    WebElement userId; // this is depricated

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

    @FindBy(id = "searchBox")
    private WebElement searchBar;
    By elementName = By.xpath("");

    @Test(priority = 1, enabled = true,retryAnalyzer = RetryAnalyzer_IRetryAnalyzer.class)
    public void Window_Basic_Auth() {
        ExtentTest test = extent.createTest("To verify username and password in chrome base browser ");
        //driver.get("https://demo.automationtesting.in/Register.html");
        driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        test.pass("To verify username and password in  base browser ");

    }

    @Test(priority = 2, enabled = true)   // How to get title of the page in the selenium
    public void get_title() {
        ExtentTest test = extent.createTest("To verify Register Title");
        String ActualURL = ("https://demo.automationtesting.in/Register.html");
        driver.get("https://demo.automationtesting.in/Register.html");
        Assert.assertEquals(driver.getCurrentUrl(), ActualURL);
        Assert.assertEquals(driver.getTitle(), "Register");
        test.pass("Title passed successfully.");

    }

    @Test(priority = 3, enabled = true)  // How to see that the image is present of not using the selenium
    public void image_present() throws IOException {
        ExtentTest test = extent.createTest("To verify Image on the Register page");
        driver.get("https://demo.automationtesting.in/Register.html");
        Boolean img = driver.findElement(By.xpath("//img[@alt='image not displaying']")).isDisplayed();
        Assert.assertTrue(img);

        WebElement element = driver.findElement(By.xpath("//img[@alt='image not displaying']"));
        File getelemetscreenshot = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(getelemetscreenshot, new File("Screenshots/imageelement.png"));

        test.pass("To verify Image passed successfully.");
    }

    @Test(priority = 4, enabled = true)  // How to select the value from the DROPDOWN ?
    public void Selection_Dropdown() throws InterruptedException {
        ExtentTest test = extent.createTest("Select the seletion in the dropdown.");
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();


        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select drop = new Select(dropdown);

        drop.selectByValue("1");
        //drop.selectByIndex(0);
        //drop.selectByVisibleText();
        List<WebElement> listOfOption = drop.getOptions();  // this is use for get all the options and it return the list
        listOfOption.forEach(values -> System.out.println(values.getText()));
        for(WebElement w : listOfOption){
            System.out.println("List of options : "+ w.getText());
        }
        Thread.sleep(5000);

    }
    @Test(enabled = true)
    public void datatablelist(){
        driver.get("https://the-internet.herokuapp.com/tables#delete");

        // Example 1
        String element = driver.findElement(By.xpath("(//table[@id='table1']/tbody/tr/td[3])[2]")).getText();
        System.out.println(" this is the element value " + element);

        // Example 2
        List<WebElement> dues = driver.findElements(By.xpath("//td[@class='dues']"));
//        for (WebElement due : dues) {
//            System.out.println(due.getText());
//        }

        for(int i=0;i<dues.size();i++){
            System.out.println(dues.get(i).getText());
        }
    }

    @Test(priority = 5, enabled = true) // scroll using the javascript executor

    public void Scroll_using_javascript() throws InterruptedException {
        ExtentTest test = extent.createTest("Scroll using java script");

        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='secondpassword']")));
        Thread.sleep(10000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element2 = driver.findElement(By.xpath("//button[@id='submitbtn']"));


        // to block the add
        js.executeScript("document.querySelectorAll('[id*=ad], [class*=ad]').forEach(el => el.remove());");



        // scroll to the element on the page
         js.executeScript("arguments[0].scrollIntoView(true);", element2);
       // Thread.sleep(10000);

        // scroll to the bottom of the page
        //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

         //scroll by the specific pixels
        //js.executeScript("window.scrollBy(0,1000)");

        //  js.executeScript("arguments[0].click();", element);
        Thread.sleep(10000);


        test.pass("Scroll using java script");
    }

    @Test(priority=1)
    public void addblock(){

    }


    @Test(priority = 6, enabled = true)  // Mouse action using the Actions class
    public void DragAndDrop() throws InterruptedException {
        ExtentTest test = extent.createTest("Drag and drop element");
        driver.get("https://demo.automationtesting.in/Dynamic.html");
        driver.manage().window().maximize();
        WebElement from = driver.findElement(By.xpath("//img[@src='logo.png']"));
        WebElement to = driver.findElement(By.xpath("//div[@id='droparea']"));
        WebElement element = driver.findElement(By.xpath("//a[@class='link linkedin']"));


        Actions actions = new Actions(driver);
        //actions.dragAndDrop(from, to).perform();
        // actions.click(from).build().perform();
        // actions.contextClick(from).build().perform(); //RightClick
        // actions.clickAndHold(from);
        // actions.doubleClick(from);
        //actions.moveToElement(from).click().perform();
        // actions.release(from).perform();
         actions.scrollToElement(element).perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;


        Thread.sleep(10000);


        test.pass("Element draged properly");
    }

    @Test(priority = 7, enabled = true)
    public void Verify() {
        ExtentTest test = extent.createTest("Verify the soft assert");

        // Verify
        SoftAssert softAssert = new SoftAssert();

        softAssert.fail("First fail");

        System.out.println("Failing first the excution");
        softAssert.fail("Second fail");
        System.out.print("failing second the excution");
        softAssert.assertAll();
        test.pass("Verify the soft assert");
    }

    @Test(priority = 8, enabled = true)
    //@Given("^user is already on Login Page$")
    public void Frames_Switching() throws InterruptedException {
        ExtentTest test = extent.createTest("frames switching testcase ");
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='tabpane']/ul/li[2]")).click();
        Thread.sleep(10000);

        // String s = "iframe-container";
        driver.switchTo().frame(1);   // index ,frameElement, name or ID
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

        Thread.sleep(5000);
        test.pass("Right click performed");
    }

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginData() {
        return new Object[][]
                {
                        {"aditya@gmail.com", "Aditya@123"},
                        {"aditya1@gmail.com", "Aditya@123"},
                        {"aditya1@gmail.com", "Aditya@123"},
                };

    }

    @Test(priority = 10, enabled = true, dataProvider = "loginDataProvider")
    public void Dataproviders(String username, String password) {

        // DataProvider is like a container that passes
        //the data to our test methods so that our single test method can execute itself with multiple data sets.
        ExtentTest test = extent.createTest("Right click on the element");
        driver.get("https://practice.automationtesting.in/my-account/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

    }

    @Test(priority = 14, enabled = true)
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
    @Test(priority = 1, enabled = true)
    public static String excelreaddata(int datarow, int datacell) throws IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/ExcelFile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(datarow);
        Cell cell = row.getCell(datacell);
        return cell.getStringCellValue();
    }
    @Test(priority= 2)
    public void excel_all_row() throws IOException{

        FileInputStream fis = new FileInputStream("src/main/resources/ExcelFile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        for(Row row : sheet){
            for(Cell cell : row){
                switch (cell.getCellType()){
                    case STRING :
                        System.out.println(cell.getStringCellValue()+ " ");
                        break;
                    case NUMERIC:
                        System.out.println(cell.getNumericCellValue()+ " ");
                        break;
                    case BOOLEAN:
                        System.out.println(cell.getBooleanCellValue()+" ");
                }
            }
            System.out.println();
        }
        workbook.close();
        fis.close();
    }

    @Test(priority= 2)
    public void excel_all_Column () throws IOException{

        FileInputStream fis = new FileInputStream("src/main/resources/ExcelFile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        for(Row row : sheet){
            Cell cell = row.getCell(0);//here we have to specify the index of the column
            if(cell!=null){
                switch (cell.getCellType()){
                    case STRING :
                        System.out.println(cell.getStringCellValue()+ " ");
                        break;
                    case NUMERIC:
                        System.out.println(cell.getNumericCellValue()+ " ");
                        break;
                    case BOOLEAN:
                        System.out.println(cell.getBooleanCellValue()+" ");
                }
            }
            System.out.println();
        }
        workbook.close();
        fis.close();
    }
    @DataProvider(name = "loginDataProviderExcel")
    public Object[][] excel_loginData() throws IOException {

        String userEmail = excelreaddata(0, 0);
        String userPassword = excelreaddata(0, 1);
        System.out.println("Details : " + userEmail + " " + userPassword);
        return new Object[][]

                {
                        {userEmail, userPassword}
                };

    }

    @Test(priority = 11, enabled = true, dataProvider = "loginDataProviderExcel")
    public void Excel_Dataproviders(String username, String password) {

        // DataProvider is like a container that passes
        //the data to our test methods so that our single test method can execute itself with multiple data sets.
        ExtentTest test = extent.createTest("Right click on the element");
        driver.get("https://practice.automationtesting.in/my-account/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @Test(priority = 12, enabled = true)
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

    @Test(priority = 13, enabled = true)  //Fluent wait
    public void FluentWait() throws InterruptedException {
        ExtentTest test = extent.createTest("Drag and drop element");
        driver.get("https://demo.automationtesting.in/Dynamic.html");
        driver.manage().window().maximize();

        /** Fluent Wait
        FluentWait can define the maximum amount of time to wait for a specific condition and frequency with which to check the condition before
        throwing an “ElementNotVisibleException” exception.


         Dynamic Waiting: It checks for the element at every pollingEvery interval instead of waiting the full timeout.
         Exception Handling: It ignores NoSuchElementException while waiting.
         Better than Implicit Waits: Works well with dynamically loaded elements.
         */

        Wait wait1 = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(45))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);



        /**Explicit wait
        //Utilize WebDriver’s `WebDriverWait` along with expected conditions to wait for an element to be present,
        // visible, or clickable. This allows the script to pause execution until the dynamic element is ready. */

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='droparea']"))));


        WebElement from = driver.findElement(By.xpath("//img[@src='logo.png']"));
        WebElement to = driver.findElement(By.xpath("//div[@id='droparea']"));

        Actions action = new Actions(driver);
        action.dragAndDrop(from, to).perform();
        Thread.sleep(5000);
        test.pass("Element draged properly");
    }



    @Test(priority = 15, enabled = true, groups = "excel")
    public void Write_ExcelFile() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Excel file to read");

        //I have placed an excel file 'Test.xlsx' in my D Driver
        FileInputStream fis = new FileInputStream("src/main/resources/ExcelFile.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
        Sheet Sheet = workbook.getSheetAt(0);

        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.

        Row row = Sheet.createRow(1);
        Cell cell = row.createCell(0);

        //Entering the value in the cell
        cell.setCellValue("aditya");

        FileOutputStream fos = new FileOutputStream("src/main/resources/ExcelFile.xlsx");
        workbook.write(fos);
        fos.close();


    }

    @Test(priority = 16, enabled = true)
    public void NAVIGATE() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Excel file to read");
        // driver.get("www.google.com");
        driver.navigate().to("https://www.google.com");//to launch a new web browser window and navigate to the specified URL
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }

    @Test(priority = 17, enabled = true)
    public void ALERT() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Excel file to read");
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        Thread.sleep(3000);
        // Alert is a class to handle webbased or javascript based popups
        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert.dismiss();
        alert.sendKeys("");

        Select select = new Select(driver.findElement(By.xpath("//*[@class='adb']")));
    }

    @Test(priority = 18, enabled = true)
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

    @Test(priority = 19, enabled = true)
    public void file_upload_linux() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Excel file to read");
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        WebElement fileInput = driver.findElement(By.xpath("//input[@name='file']"));
        fileInput.sendKeys("D:\\Projects\\eclipse-workspace\\java_con\\src\\main\\resources\\abstraction_Interface.png");
        Thread.sleep(3000);
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(10000);
    }

    @Test(priority = 20, enabled = true)
    public void Find_all_links() {
        try {
            // Open the web page
            driver.get("https://www.softwaretestingmaterial.com/explain-test-automation-framework/");
            // Find all link elements
            List<WebElement> links = driver.findElements(By.tagName("href"));
            // print each link's URL
            for (WebElement link : links) {
                System.out.println(link.getAttribute("href"));
            }
        } catch (ArithmeticException e) {
            System.out.println("This is demo ");
        }
    }

    @Test(priority = 20, enabled = true)
    public void Screen_shot() throws IOException {
        driver.get("https://www.softwaretestingmaterial.com/capture-screenshot-using-selenium-webdriver");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // stored file in the local storage
        FileUtils.copyFile(screenshotFile, new File("D:\\SoftwareTestingMaterial.png"));
    }

    @Test(priority = 21, enabled = true)
    public void Scroll_moving_mouse() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://www.softwaretestingmaterial.com/inheritance-in-java/");
        Actions action = new Actions(driver);
        WebElement ele = driver.findElement(By.xpath("//a[normalize-space()='Sitemap']"));
        //action.moveToElement(ele);
        //action.perform();
        // wheelAPI
        action.scrollToElement(ele).perform();

        //using send keys
        //action.sendKeys(Keys.PAGE_DOWN).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", ele);
    }

    @Test(priority = 22, enabled = true)
    public void flipkart() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        Actions action = new Actions(driver);
        WebElement ele = driver.findElement(By.xpath("//div[@class='_1wE2Px']"));
        action.moveToElement(ele).perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[normalize-space()='Slingbags']")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 23, enabled = true)
    public static void read_properties() throws IOException {

        FileInputStream file = new FileInputStream("src/main/resources/config.properties");
        Properties prop = new Properties();
        prop.load(file);
        String browser;
        browser = prop.get("browserName").toString();
        System.out.println(browser);
    }
    @Test(priority = 24, enabled = true)
    public void linkText_parcialLinkText() throws InterruptedException {

        // DataProvider is like a container that passes
        //the data to our test methods so that our single test method can execute itself with multiple data sets.
        ExtentTest test = extent.createTest("Right click on the element");
        driver.get("https://demo.automationtesting.in/Accordion.html");
        driver.manage().window().maximize();
        Thread.sleep(3000);
       WebElement elem =  driver.findElement(By.linkText("#collapse2"));
        elem.click();
        Thread.sleep(5000);
    }

    @Test(priority = 25, enabled = true)
    public void findAll_Link_text() throws InterruptedException {

        // DataProvider is like a container that passes
        //the data to our test methods so that our single test method can execute itself with multiple data sets.
        ExtentTest test = extent.createTest("Right click on the element");
        driver.get("https://www.softwaretestingmaterial.com/explain-test-automation-framework/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        List<WebElement> ls =  driver.findElements(By.xpath("//*[@href]"));
        for(WebElement w :ls ){
            if(w.getText().isBlank()){
                continue;
            }
            String listofname = w.getText();
            System.out.println("Link text : " + listofname);
        }
    }

    @Test(priority = 26, enabled = true)
    public void findBrokenLink() throws IOException {
        driver.get("https://www.softwaretestingmaterial.com/explain-test-automation-framework/");

        List<WebElement> links = driver.findElements(By.xpath("//*[@href]"));

        for(WebElement w : links) {
            String url = w.getAttribute("href");
            if (url == null || url.isEmpty()) {
                continue;
            }
           try {
               HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

               conn.setRequestMethod("HEAD");
               conn.connect();
               int response = conn.getResponseCode();
               if (response >= 400) {
                   System.out.println(url + "this is brokenlink" + "Response Code is : " + response);
               } else {
                   System.out.println(url + "This is the valid url");
               }
           }
           catch (Exception e){
               System.out.println(url + "This is the broken link " + "Exception : "+ e.getMessage());
           }

        }








//            try {
//                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
//                conn.setRequestMethod("HEAD");
//                conn.connect();
//                int responseCode = conn.getResponseCode();
//
//                if (responseCode >= 400) {
//                    System.out.println(url + " is a broken link. Response Code: " + responseCode);
//                } else {
//                    System.out.println(url + " is valid.");
//                }
//            } catch (Exception e) {
//                System.out.println(url + " is a broken link. Exception: " + e.getMessage());
//            }
/*

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("Head");
            conn.connect();
            int resonseCode = conn.getResponseCode();
            if(resonseCode>=400){
                System.out.println(url + " is a broken link  : "+" Response code is : " + resonseCode);
            }else{
                System.out.println("Url is broken ");
            }
*/
    }

  /*  @Test(priority = 23, enabled = true)
    public static void Slider_movetoElement() throws IOException, InterruptedException {

        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        // Locate the slider handle
        WebElement sliderHandle = driver.findElement(By.xpath("//input[@type='range']"));

        // Initialize the Actions class
        Actions actions = new Actions(driver);

        // Perform the drag-and-drop action
        // Here, 100 is the distance to move the slider handle; adjust as needed
        actions.clickAndHold(sliderHandle)
                .moveByOffset(25, 0) // Move right by 100 pixels (you can adjust this value)
                .release()
                .build()
                .perform();
        Thread.sleep(5000);

    }
*/


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

