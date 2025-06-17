package StepDefination;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.TestNGCucumberRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup(Scenario scenario) {
        String browserType = configReader.get("browser");
        ChromeOptions options = new ChromeOptions();
        FirefoxOptions options1 = new FirefoxOptions();
        if (browserType.equalsIgnoreCase("chrome")) {

            if (scenario.getSourceTagNames().contains("@dropdownWithDatatable")){
                options.addArguments("-headless"); // note: single dash
                // Firefox doesn't use --no-sandbox or --disable-dev-shm-usage by default

                driver = new FirefoxDriver(options1);
            } else {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                driver = new ChromeDriver(options);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

    }
//    @Parameters("browserType")
//    @Before
//    public void setup() {
//        String browserType = configReader.get("browser");
//        if (browserType.equalsIgnoreCase("chrome")) {
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        }
//    }



//    @Before("@dropdownWithDatatable")
//    public void setupFirefoxDriver(){
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//    }
    @After
    public void teardown(){
        driver.quit();
    }

}



