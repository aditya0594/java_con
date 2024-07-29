package SeleniumTopic;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class Waits {
    static WebDriver driver;

    @Test(priority =10, enabled = true,dataProvider = "Login")
    public void Dataproviders(String username , String password) {

        System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        WebDriver driver = new ChromeDriver();
        System.out.println(username);
        System.out.println(password);
    }
    @Test(priority =1)
    public void screenshot() throws IOException, InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

        FluentWait<WebDriver> FluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(45))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
    }


    }
/**

 Explicit Wait :

 WebDriverWait is used in Selenium WebDriver to make your automation scripts more reliable by waiting for certain conditions
 to be true before proceeding with the next steps. This is helpful because web pages can take time to load or elements
 might take a while to become visible or clickable.

 In simple terms, WebDriverWait allows your script to:
 1. Wait for a condition: Instead of instantly trying to interact with a web element (which might not be ready),
 the script waits until the element meets certain conditions, like becoming visible or clickable.
 2. Avoid failures: It reduces the chances of your script failing due to elements not being ready in time.
 3. Improve stability: It makes your tests more stable and reliable because
 it waits for the right conditions rather than guessing or using arbitrary sleep times.

 Fluent wait :

 FluentWait in Selenium WebDriver is a way to tell your test to wait for a certain condition to be true,
 but with more flexibility and control compared to WebDriverWait.
 Here's a simple explanation:

 1. PollingEvery: FluentWait checks for a condition at regular intervals (e.g., every second).
 If the condition isn't met, it waits and checks again.
 2. Timeout(withTimeout) : You set a maximum time to wait for the condition to be met.
 If the condition isn't met within this time, the wait stops, and an exception is thrown.
 3. Ignoring Exceptions: FluentWait can be configured to ignore specific types of exceptions
 (e.g., NoSuchElementException) while waiting. This means if an element isn't found initially,
 FluentWait will continue to look for it until the timeout is reached.
 */
