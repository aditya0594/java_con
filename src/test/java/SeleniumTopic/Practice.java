package SeleniumTopic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class Practice {
    static WebDriver driver;
   @DataProvider(name = "test")
   public Object[][] data(){
       return new Object[][]{
           {"adityapawar","aditya@123"},

       };
   }
    @Test(priority =10, enabled = true,dataProvider = "test")
    public void Dataproviders(String username , String password) {
      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--remote-allow-origins=*");
      WebDriver driver = new ChromeDriver(options);
      driver.get("https://www.google.com");

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
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.softwaretestingmaterial.com/");

        String parentWindow = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://help.blazemeter.com/");


        Set<String> childWindow = driver.getWindowHandles();
        for(String windows : childWindow){
            if(driver.getTitle().equals("Google"));
            driver.switchTo().window(windows);
            break;
        }
        Thread.sleep(10000);
        driver.quit();

    }
    @Test
    public void practic(){
       String str=  "Aditya";
       
       String rev = "";
       for(int i = str.length()-1; i>=0;i--){
          rev = rev + str.charAt(i);
       }
        System.out.println(rev);
    }
    @Test
    public void chromeDriver(){
       WebDriver driver;
       WebDriverManager.chromedriver().setup();
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");
       options.addArguments("--disable-notifications");
       options.addArguments("--disable-popup-blocking");
        options.addExtensions(new File("D:\\Projects\\eclipse-workspace\\java_con\\src\\main\\resources\\GIGHMMPIOBKLFEPJOCNAMGKKBIGLIDOM_6_18_0_0.crx"));
       driver=new ChromeDriver(options);

       driver.get("https://demo.automationtesting.in/Dynamic.html");


    }
}


