package Java_Concept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    //private static Instance Variable
    //Private Constructor
   // Public Static Method to Return Instance

    private static WebDriver driver;      // Private static variable of the single instance

   private WebDriverSingleton(){  // Private constructor to restrict instantiation from other classes
       System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");
       driver = new ChromeDriver(options);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.manage().window().maximize();
   }
    public static WebDriver getInstance() {   //Public Static Method to Return Instance
       // if (driver == null) {
           // synchronized (WebDriverSingleton.class) {
                if (driver == null) {
                    new WebDriverSingleton();
                }
          //  }
       // }
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    /*
    The Singleton pattern is a design pattern that restricts the instantiation of a class to one single instance.
    This is useful when exactly one object is needed to coordinate actions across the system.
    Here are the normal rules and steps to implement the Singleton pattern in Java:

Rules for Singleton Pattern :
Private Constructor: Ensure that the class cannot be instantiated from outside by making the constructor private.
private Static Instance: Use a private static variable to hold the single instance of the class.
Public Static Method: Provide a public static method that returns the single instance of the class,
creating it if it does not already exist.
Thread Safety (Optional): Ensure the class is thread-safe if it is to be used in a multithreaded environment.

Step-by-Step Implementation
Private Constructor
Static Instance Variable
Public Static Method to Return Instance
     */


}
