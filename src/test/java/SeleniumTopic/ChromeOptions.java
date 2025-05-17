package SeleniumTopic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Collections;

public class ChromeOptions {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver(); // Directly create ChromeDriver object
        driver.get("https://www.google.com");
        System.out.println("Title of the page is: " + driver.getTitle());
        driver.quit();
    }



}
