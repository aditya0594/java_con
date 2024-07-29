package SeleniumTopic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager  {

    public static void main(String[] args) {
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().cachePath("C:\\Users\\Aditya Pawar\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Cache\\Cache_Data").setup();
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        // Use the WebDriver instance to interact with a website
        driver.get("https://www.google.com");
        // Perform actions and validations
        // Close the browser
        driver.quit();
    }
}
