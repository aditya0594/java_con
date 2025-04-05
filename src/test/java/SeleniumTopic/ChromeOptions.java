package SeleniumTopic;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Collections;

public class ChromeOptions {

    public static void main(String[] args) {
       WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }



}
