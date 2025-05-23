package SeleniumTopic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits {

   @Test
    public void NumberOfWaits(){

        WebDriver driver;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//buttn[@id='Button1']")).click();

        // Implicitly wait
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //Explicitly wait
       WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));

        wait1.until(ExpectedConditions.elementToBeClickable(By.id("Element locator")));
        //wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("Element locator")));
       // wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("Element locator")));

        // Fluent wait

    Wait wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(5))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(NoSuchElementException.class);



    }
}

/**
  IMPLICIT WAIT :
 An implicit wait is a global setting that tells the WebDriver to wait for a certain
 amount of time before throwing a NoSuchElementException if an element is not immediately available.
 Scope: It applies to all elements in the WebDriver instance.

 EXPLICIT WAIT :
 An explicit wait allows you to define a specific condition and wait for a particular element or condition
 to be true before proceeding.
 It is applied only to the specific element or condition it is defined for.
 Uses WebDriver’s WebDriverWait class in combination with ExpectedConditions to wait for a condition to be met.

 FLUENTWAIT :

 FluentWait in Selenium is a type of wait that allows you to specify the maximum amount of time to wait for a condition,
 as well as the frequency with which to check the condition.
 It also allows you to specify which types of exceptions to ignore while waiting.

 When to Use FluentWait
 FluentWait is useful when you need to:

 Wait for a condition with a custom time interval: If you want to check the condition at specific intervals instead of continuously,
 FluentWait allows you to set this interval.
 Handle specific exceptions: You can specify which exceptions to ignore during the wait period.
 This is helpful when certain exceptions are expected during the wait (e.g., NoSuchElementException).


 **/