package SeleniumTopic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class New_RelativeLocator_with {

        private WebDriver driver;

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

        }

        @Test
        public void testMultipleTabsAndWindows() {
            // Open the initial URL
            driver.get("https://chatgpt.com/");
            WebElement element = driver.findElement(By.xpath("//*[@id='input-4']"));
            driver.findElement(RelativeLocator.with(By.xpath("//*[@id='input-4']")).above(element));
            driver.findElement(RelativeLocator.with(By.xpath("//*[@id='input-4']")).below(element));
            driver.findElement(RelativeLocator.with(By.xpath("//*[@id='input-4']")).toLeftOf(element));
            driver.findElement(RelativeLocator.with(By.xpath("//*[@id='input-4']")).toRightOf(element));
            driver.findElement(RelativeLocator.with(By.xpath("//*[@id='input-4']")).near(element));

        }

        @AfterClass
        public void tearDown() {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
    }

