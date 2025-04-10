package SeleniumTopic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Base_Driver_driver {
    private static WebDriver driver;  // private static instance variable

    public Base_Driver_driver(String browser) throws MalformedURLException {   // private constructor
        openBrowser(browser);
    }

    public static WebDriver driverInstance(String browser) throws MalformedURLException {
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
    public void setup() throws MalformedURLException {
        driver = Base_Driver_driver.driverInstance("Chrome");
    }
    @AfterMethod
    public void teardown(){
        Base_Driver_driver.quit();
    }

    public void openBrowser(String browser) throws MalformedURLException {
        switch (browser.toLowerCase()) {
            case "Remote":
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
                RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
                break;
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
