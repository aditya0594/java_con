package SeleniumTopic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridTest {

    @Test(enabled = true)
        public void Test() throws MalformedURLException {    // Set the desired capabilities

        ChromeOptions options = new ChromeOptions();
        options.setBinary("Driver/chromedriver_binary.exe");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        // URL of the Hub
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.29.155:4444"), capabilities);

        // Your test code here
        driver.get("https://www.example.com");
        System.out.println(driver.getTitle());

        driver.quit();
    }
}
