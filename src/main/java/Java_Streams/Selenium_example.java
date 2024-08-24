package Java_Streams;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Selenium_example {
    WebDriver driver;
    @Test
    public void sort() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        Thread.sleep(3000);

        // to capture all the element of table

        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

        // to Capture all the element text form the table

        List<String> originalList =elementsList.stream().map(s-> s.getText()).collect(Collectors.toList());//.forEach(s-> System.out.println("Before filter list " + s));
        // sort the list of the element

        List<String> sortedlist = originalList.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(sortedlist,originalList);
        driver.quit();
    }
}
