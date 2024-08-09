package SeleniumTopic;

import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

public class Practice {
    static WebDriver driver;
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
    @Test(priority =1)
    public void Excelread() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream("src/main/resources/ExcelFile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(cell);
    }
    @Test(priority = 1)
    public void chrome(){
       System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");
       driver = new ChromeDriver(options);
       driver.get("https://www.softwaretestingmaterial.com/100-software-testing-interview-questions/");
       Actions action = new Actions(driver);
        By elementLink = By.linkText("https://www.softwaretestingmaterial.com/black-box-and-white-box-testing");
        WebElement ItemClick = driver.findElement(elementLink);
        action.moveToElement(ItemClick);

       driver.quit();

        }

    @Test(priority = 1)
    public void window() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.softwaretestingmaterial.com/");

        String parentWindow = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://help.blazemeter.com/");


        Set<String> childWindow = driver.getWindowHandles();
        for(String windows : childWindow){
            driver.switchTo().window(windows);
            if(driver.getTitle().equals("Google"));
            break;
        }

        Thread.sleep(10000);
        driver.quit();

    }
    }


