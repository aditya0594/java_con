package SeleniumTopic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class openBrowser {
    WebDriver driver;
    @Test
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com");

    }
}
