package StepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.TestNGCucumberRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void setup(Scenario scenario) {
        String browserType = configReader.get("browser");
        if (browserType.equalsIgnoreCase("chrome")) {

            if (scenario.getSourceTagNames().contains("@dropdownWithDatatable")){
                driver = new FirefoxDriver();
            } else {
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

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
