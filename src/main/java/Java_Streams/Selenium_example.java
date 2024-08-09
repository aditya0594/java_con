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

        List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> original =elements.stream().map(s-> s.getText()).collect(Collectors.toList());//.forEach(s-> System.out.println("Before filter list " + s));
        List<String> sortedlist = original.stream().sorted().collect(Collectors.toList());

        driver.findElement(By.xpath("//span[normalize-space()='Veg/fruit name']")).click();

        Thread.sleep(3000);
        List<WebElement> elements1 = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> original1 =elements.stream().map(s-> s.getText()).collect(Collectors.toList());//.forEach(s-> System.out.println("Before filter list " + s));

        Assert.assertEquals(sortedlist,original1);







        driver.quit();
    }
}
