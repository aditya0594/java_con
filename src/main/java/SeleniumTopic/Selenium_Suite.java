package SeleniumTopic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
@Listeners(ITestListener.class)
public class Selenium_Suite {
        WebDriver driver;
    @Parameters("browser")
       @BeforeTest
        public void Setup(String browser){
            if(browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", "Driver/chromedriver_win.exe");
                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }
            else if(browser.equalsIgnoreCase("firefox")){
                driver = new FirefoxDriver();
            }
            else if (browser.equalsIgnoreCase("IE")){
                driver = new InternetExplorerDriver();
            }
            else if (browser.equalsIgnoreCase("webdrivermanager")){
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);

            }
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
                js.executeScript("arguments[0].scrolIntoView();",element2 );
                Thread.sleep(10000);

                // scroll to the bottom of the page
            //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

                // scroll by the specific pixels
            //js.executeScript("window.scrollBy(0,1000);");

        }
    @Test(priority = 2, enabled = true,invocationCount = 3)
    public void DragAndDrop() throws InterruptedException {

        driver.get("https://demo.automationtesting.in/Dynamic.html");
        driver.manage().window().maximize();
        WebElement from =driver.findElement(By.xpath("//img[@src='logo.png']"));
        WebElement to =driver.findElement(By.xpath("//div[@id='droparea']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(from,to).perform();
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


        @AfterTest
    public void tearDown() throws InterruptedException {
            Thread.sleep(3);
            driver.quit();
        }
}
