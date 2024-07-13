package Java_Concept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    // Static Instance Variable
    //Private Constructor
   // Public Static Method to Return Instance

    private static WebDriver driver;      // Private static variable of the single instance

   private WebDriverSingleton(){  // Private constructor to restrict instantiation from other classes
       System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.manage().window().maximize();
   }
    public static WebDriver getInstance() {
        if (driver == null) {
            synchronized (WebDriverSingleton.class) {
                if (driver == null) {
                    new WebDriverSingleton();
                }
            }
        }
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
