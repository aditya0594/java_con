package SeleniumTopic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class New_RelativeLocator_with {

        private WebDriver driver;

        @BeforeClass
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

        }
    @Test
    public void Relative_Above() {
        // Open the initial URL
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox = driver.findElement(By.name("name"));
        String getname = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
    }
    @Test
    public void Relative_below() {
        // Open the initial URL
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox = driver.findElement(By.name("name"));
        String getname = driver.findElement(with(By.tagName("label")).below(nameEditBox)).getText();
        System.out.println("This is the text of print" + getname);
    }
    @Test
    public void Relative_toLeftof()throws InterruptedException{
        // Open the initial URL
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement checkLebal = driver.findElement(By.xpath("//label[@class='form-check-label']"));
        WebElement element = driver.findElement(with(By.xpath("//input[@id='exampleCheck1']")).toLeftOf(checkLebal));
        element.click();
        Thread.sleep(5000);

    }
    @Test
    public void Relative_toRigthof()throws InterruptedException{
        // Open the initial URL
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement clickCheck = driver.findElement(By.xpath("//label[@for='inlineRadio1']"));
        WebElement element1 = driver.findElement(with(By.xpath("//input[@id='inlineRadio2']")).toRightOf(clickCheck));
        element1.click();
        Thread.sleep(5000);

    }



        @AfterClass
        public void tearDown() {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
    }

