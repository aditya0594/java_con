package SeleniumTopic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Collections;

public class Base_Driver_driver {
    private static WebDriver driver;  // private static instance variable

    public Base_Driver_driver(String browser){   // private constructor
        openBrowser(browser);
    }

    public static WebDriver driverInstance(String browser){
         if(driver==null){
             new Base_Driver_driver(browser);
         }
         return driver;
    }
    public static void quit(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
    @BeforeMethod
    public void setup(){
        driver = Base_Driver_driver.driverInstance("Chrome");
    }
    @AfterMethod
    public void teardown(){
        Base_Driver_driver.quit();
    }

    public void openBrowser(String browser){
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }
    }


    public void tearDown() {
            driver.close();
    }
}
