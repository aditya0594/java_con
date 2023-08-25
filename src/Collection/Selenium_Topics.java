package Collection;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

public class Selenium_Topics {
    public static void main(String[] args){

            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://demo.automationtesting.in/Alerts.html");
            driver.quit();




            // implicit wait

            // driver.manage().timeouts().implicitlyWait(10, SECONDS);

            //fluent wait
      /*Wait wait = new FluentWait(driver)
              .withTimeout(30, SECONDS)
              .pollingEvery(5, SECONDS)
              .ignoring(NoSuchElementException.class);*/

            //javascript executor

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("Alert('hello world');");


            //Screen shot
            File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File Destfile = new File("C:\\Users\\Aditya Pawar\\eclipse-workspace\\java_con\\src\\screen shot");
            try {
                // now copy the screenshot to desired location using copyFile //method
                FileUtils.copyFile(scr, Destfile);
            }
            catch (IOException e){
                e.printStackTrace();
                System.out.println("This the error"+ e);
            }


        }

    }