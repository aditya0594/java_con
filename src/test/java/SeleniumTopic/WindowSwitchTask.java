package SeleniumTopic;

import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class WindowSwitchTask {
    private WebDriver driver;
    @BeforeClass

        public void setUp() {
            WebDriverManager.chromedriver().setup();
            org.openqa.selenium.chrome.ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
    }
    @Test
    public void testMultipleTabsAndWindows() throws InterruptedException {
        // Open url
        driver.get("https://www.google.com/");
        System.out.println("Title of the first tab: " + driver.getTitle()); //Google

        String originalWindow = driver.getWindowHandle();

        // Open a new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.selenium.dev/");
        System.out.println("Title of the new tab: " + driver.getTitle());  //Selenium

        // the original tab
        driver.switchTo().window(originalWindow);
        System.out.println("Back to the first tab: " + driver.getTitle());

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bing.com");
        System.out.println("Title of the new window: " + driver.getTitle());


        //all window handles
        Set<String> allWindows = driver.getWindowHandles();
        // Switch to each window and print its title
        for (String windowHandle : allWindows) {
            driver.switchTo().window(windowHandle); // Switch first
            if (driver.getTitle().equals("Selenium")) {
                System.out.println("Switched to Selenium tab/window.");
                break;
            }
        }
    }
    @Test(enabled = true)
    public void datatablelist(){
        driver.get("https://the-internet.herokuapp.com/tables#delete");

        // Example 1
        String element = driver.findElement(By.xpath("(//table[@id='table1']/tbody/tr/td[3])[2]")).getText();
        System.out.println(" this is the element value " + element);

        // Example 2
        List<WebElement> dues = driver.findElements(By.xpath("//td[@class='dues']"));
//        for (WebElement due : dues) {
//            System.out.println(due.getText());
//        }

       /* for(int i=0;i<dues.size();i++){
            System.out.println(dues.get(i).getText());
        }*/

        double totalDue = 0.0;
        for (int i = 0; i < dues.size(); i++) {
            String dueText = dues.get(i).getText();
            String cleanDue = dueText.replace("$", "");
            double dueValue = Double.parseDouble(cleanDue);
            totalDue += dueValue;

            System.out.println("Due " + (i + 1) + ": $" + dueValue);
        }

        System.out.println("Total Due: $" + totalDue);
    }
    @Test(priority = 4, enabled = true)  // How to select the value from the DROPDOWN ?
    public void Selection_Dropdown() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select drop = new Select(dropdown);

        drop.selectByValue("1");
        //drop.selectByIndex(0);
        //drop.selectByVisibleText();
        List<WebElement> listOfOption = drop.getOptions();  // this is use for get all the options and it return the list
        listOfOption.forEach(values -> System.out.println(values.getText()));
        for(WebElement w : listOfOption){
            System.out.println("List of options : "+ w.getText());
        }
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
