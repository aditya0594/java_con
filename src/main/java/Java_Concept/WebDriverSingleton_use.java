package Java_Concept;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverSingleton_use{
    protected WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverSingleton.getInstance();
    }
    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.quit();
    }
    @Test()
    public void testExample(){
        driver.get("https://www.google.com");
    }

}
