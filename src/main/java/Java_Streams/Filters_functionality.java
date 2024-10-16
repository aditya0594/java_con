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

public class Filters_functionality {
    WebDriver driver;

    @Test
    public void sort() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        Thread.sleep(3000);
        // Click on the search box
        driver.findElement(By.xpath("//input[@id='search-field']")).click();
        driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Tomato");

        // capture the all element  into the list

        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

        //scan the name column if the rice then print price
        List<WebElement> vegName = elementsList.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());

        Assert.assertEquals(vegName,elementsList);
                //.filter(s -> s.getText().contains("Rice")).collect(Collectors.toList());
        driver.close();
    }
}
