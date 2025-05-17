package SeleniumTopic;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sf.cglib.util.StringSwitcher;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.oer.Switch;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.apache.groovy.json.internal.Type.STRING;
import static org.apache.poi.ss.usermodel.CellType.BOOLEAN;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;

public class Practice {
    static WebDriver driver;
   @DataProvider(name = "test")
   public Object[][] data(){
       return new Object[][]{
           {"adityapawar","aditya@123"},

       };
   }
    @Test(priority =10, enabled = true)
    public void Dataproviders() throws IOException {

       FileInputStream fis = new FileInputStream("src/main/resources/ExcelFile.xlsx");
       XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(1);
        System.out.println("This is the cell value : "+ cell);

        }

    @Test(priority =1)
    public void screenshot() throws IOException, InterruptedException {
    File sc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(sc, new File("Path"));

    }

    @Test(priority =1)
    public void seleniumdriverwithout() throws IOException, InterruptedException {
        // No need to set system property for chromedriver
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
        Thread.sleep(5000);
        driver.quit();
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

    @Test(priority= 2)
    public void excel_all_row() throws IOException{

       FileInputStream fis = new FileInputStream("src/main/resources/ExcelFile.xlsx");
       XSSFWorkbook workbook = new XSSFWorkbook(fis);
       Sheet sheet = workbook.getSheetAt(0);
       for(Row row : sheet){
           for(Cell cell : row){
             switch (cell.getCellType()){
                 case STRING :
                     System.out.println(cell.getStringCellValue()+ " ");
                     break;
                 case NUMERIC:
                     System.out.println(cell.getNumericCellValue()+ " ");
                     break;
                 case BOOLEAN:
                     System.out.println(cell.getBooleanCellValue()+" ");
             }
           }
           System.out.println();
       }
       workbook.close();
       fis.close();
    }

    @Test(priority= 2)
    public void excel_all_Column () throws IOException{

        FileInputStream fis = new FileInputStream("src/main/resources/ExcelFile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        for(Row row : sheet){
            Cell cell = row.getCell(0);//here we have to specify the index of the column
            if(cell!=null){
                switch (cell.getCellType()){
                    case STRING :
                        System.out.println(cell.getStringCellValue()+ " ");
                        break;
                    case NUMERIC:
                        System.out.println(cell.getNumericCellValue()+ " ");
                        break;
                    case BOOLEAN:
                        System.out.println(cell.getBooleanCellValue()+" ");
                }
            }
            System.out.println();
        }
        workbook.close();
        fis.close();
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
        System.out.println("This is the title of google : " + driver.getTitle() );
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://help.blazemeter.com/");
        System.out.println("This is the title of blazemeter : " + driver.getTitle());


        Set<String> childWindow = driver.getWindowHandles();
        for(String windows : childWindow) {
            driver.switchTo().window(windows);
            if (driver.getTitle().equals("Google")) {
                driver.switchTo().window(windows);
                System.out.println("This is the driver title :" + driver.getTitle());
                break;
            }
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
    public void chromeDriver() throws InterruptedException {
       WebDriver driver;
       WebDriverManager.chromedriver().setup();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.managed_default_content_settings.images", 2);
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");
       options.setExperimentalOption("prefs",prefs);
       driver = new ChromeDriver(options);
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        Thread.sleep(10000);


    }
}


