package SeleniumTopic;

import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Practice extends Selenium_other_methods{

   @DataProvider(name = "Login")
    public Object[][] Login(){
            return new Object[][]
            {
                    {"Adityapawar@gmail.com","Password@123"}

            };

       }
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
    File sc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(sc, new File("Path"));

    }

    }

