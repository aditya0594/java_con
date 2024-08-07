package SeleniumTopic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowActionSele4 {

        private WebDriver driver;

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

        }

        @Test
        public void testMultipleTabsAndWindows() throws InterruptedException {
            // Open the initial URL
            driver.get("https://chatgpt.com/");
            System.out.println("Title of the first tab: " + driver.getTitle());

            // Store the current window handle
            String originalWindow = driver.getWindowHandle();

            // Open a new tab
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://www.google.com");
            System.out.println("Title of the new tab: " + driver.getTitle());

            // Switch back to the original tab
          //  driver.switchTo().window(originalWindow);
            //System.out.println("Back to the first tab: " + driver.getTitle());

            // Open a new window
            driver.switchTo().newWindow(WindowType.WINDOW);
            driver.get("https://www.bing.com");
            System.out.println("Title of the new window: " + driver.getTitle());

            // Perform operations in the Google tab

            switchBytitle(driver,"Google");
            // Get all window handles
        /*    Set<String> allWindows = driver.getWindowHandles();

            // Switch to each window and print its title
            for (String windowHandle : allWindows) {
               if(driver.getTitle().equals("Google")){
                   driver.switchTo().window(windowHandle);
                   break;
               }*/
               Thread.sleep(5000);
        }
        public void switchBytitle(WebDriver driver,String title){

            Set<String> allWindows = driver.getWindowHandles();
            for(String windowhandle : allWindows){
                driver.switchTo().window(windowhandle);
                if(driver.getTitle().equals(title)){
                    break;
                }
            }
        }


        @AfterClass
        public void tearDown() {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
    }
