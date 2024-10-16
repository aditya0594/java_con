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

public class Custom_Method_map {
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
        driver.findElement(By.xpath("//span[normalize-space()='Veg/fruit name']")).click();
        // capture the all element  into the list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

        //scan the name column if the rice then print price
        List<String> prices= elementsList.stream().filter(s -> s.getText().contains("Beans"))
                .map(s -> getPriceveggies(s)).collect(Collectors.toList());
        prices.forEach(s-> System.out.println(s));

        driver.quit();
    }

    private static String getPriceveggies(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}

