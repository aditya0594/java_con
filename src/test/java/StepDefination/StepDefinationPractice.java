package StepDefination;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StepDefinationPractice {

    WebDriver driver = Hooks.driver;
    @Given("Open the url")
    public void open_the_url() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }
    By radiobtn = By.xpath("//input[@value='radio2']");
    @When("Click on the Radio Button Example first button")
    public void click_on_the_radio_button_example_first_button() {
        driver.findElement(radiobtn).click();
    }
    @Then("Verify the radio button is click")
    public void verify_the_radio_button_is_click() {
        Boolean selectedBtn =  driver.findElement(radiobtn).isSelected();
        Assert.assertTrue(selectedBtn,"Radio button is selected");
    }

    By DropdownText = By.id("autocomplete");
    @When("Click on the Suggession Class Example field and enter intiails of {string}")
    public void click_on_the_suggession_class_example_field_and_enter_intiails_of(String dropdownInitials) {
        driver.findElement(DropdownText).sendKeys(dropdownInitials);

    }
    By optionList = By.xpath("//div[@class='ui-menu-item-wrapper']");
    @Then("Verify that selected country is in dropdown {string}")
    public void verify_that_selected_country_is_in_dropdown(String options) {

        List<WebElement> list = driver.findElements(optionList);
        for(WebElement values : list ){
            if(values.getText().equals(options)){
                Assert.assertEquals(values.getText(),options);
                values.click();

            }
        }
    }
    By dropDownId = By.id("dropdown-class-example");
    Select select;

    @When("Select the {string} from the dropdown")
    public void select_the_from_the_dropdown(String optionToSelect) {
        WebElement dropdown = driver.findElement(dropDownId);
         select = new Select(dropdown);
        select.selectByVisibleText(optionToSelect);
    }
    @Then("Verify that selected value {string}")
    public void verify_that_selected_value(String option) {
        String dropvalue = select.getFirstSelectedOption().getText();
        Assert.assertEquals(dropvalue,option);
    }

    String parentWindow;
    @When("Click on the Open window button")
    public void click_on_the_open_window_button() {
        parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window title is : "+driver.getTitle());
      driver.findElement(By.id("openwindow")).click();
    }
    @When("Switch to the original window")
    public void switch_to_the_original_window() throws InterruptedException {
        Set<String> windows = driver.getWindowHandles();

        for(String win : windows){
            driver.switchTo().window(win);
            if(win.equals("Practice Page")){
                break;
            }
        }
        Thread.sleep(5000);
    }

    @When("Hover the mouse on the button")
    public void hover_the_mouse_on_the_button() {
        Actions action = new Actions(driver);
        WebElement MouseHover = driver.findElement(By.id("mousehover"));
        action.moveToElement(MouseHover).perform();
    }
    @When("Select the Top")
    public void select_the_top() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='#top']")).click();
        Thread.sleep(4000);
    }
    @Then("Verify the Home button visibility")
    public void verify_the_home_button_visibility() {
        WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Home')]"));
        Assert.assertEquals(element.getText(),"Home");
    }
    @When("go the table")
    public void go_the_table() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//legend[contains(text(),'Element Displayed Example')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(10000);
    }
    List<WebElement> listofCourse= driver.findElements(By.xpath("//*[@class='table-display'] //tr/td[2]"));
    @When("Get list of course")
    public void get_list_of_course() {
       for(WebElement courses : listofCourse){
           System.out.println("List of courses : " );
           System.out.println(courses.getText());
       }
    }
    @Then("Verify that list contains {string}")
    public void verify_that_list_contains(String coursetitle) {
        for(WebElement courses : listofCourse){
            String course = courses.getText();
            if(course.contains(coursetitle)){
                System.out.println("Found in the course list " + course);
                break;
            }
        }
    }

    String parentwin;

    @When("Click on the new tab")
    public void click_on_the_new_tab() throws InterruptedException {
        parentwin = driver.getWindowHandle(); // Store parent window
        driver.findElement(By.id("opentab")).click();
        Thread.sleep(5000);
    }

    @When("Switch back to the parent window")
    public void switch_back_to_the_parent_window() {
        driver.switchTo().window(parentwin); // Switch using handle
        System.out.println("Switched to parent window: " + driver.getTitle());
    }

    @When("Click on the new window")
    public void click_on_the_new_window() {
        driver.findElement(By.id("openwindow")).click();
    }

    @When("Switch on the parent Window")
    public void switch_on_the_parent_window() {
        driver.switchTo().window(parentwin);
        System.out.println("Switched back to parent window: " + driver.getTitle());
    }

    @Then("Verify we are on the parent window")
    public void verify_we_are_on_the_parent_window() {
        String parentTitle = driver.getTitle();
        Assert.assertEquals(parentTitle, "Practice Page");
    }

    @Given("Open the url {string}")
    public void open_the_url(String string) {
       driver.get(string);
    }
    Actions actions = new Actions(driver);
    @When("Hover to Enable")
    public void hover_to_enable() {
        WebElement enable = driver.findElement(By.xpath("//*[contains(text(),'Enabled')]"));
        actions.moveToElement(enable).perform();
    }
    @When("Hover to Download")
    public void hover_to_download() {
        By downl = By.xpath("//*[contains(text(),'Downloads')]");
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(downl));
        WebElement download = driver.findElement(downl);
        actions.moveToElement(download).perform();
    }
    @When("Click on Pdf")
    public void click_on_pdf() throws InterruptedException {
        WebElement pdf = driver.findElement(By.xpath("//*[contains(text(),'PDF')]"));
        actions.click(pdf);
        Thread.sleep(7000);
    }
    //--------------------------data table ----------------------------------------------


    @When("Select the option from the dropdown")
    public void select_the_option_from_the_dropdown(DataTable dataTable) {
        WebElement dropdown = driver.findElement(dropDownId);
        select = new Select(dropdown);
        Map<String, String> data = dataTable.asMaps().get(0);
        select.selectByVisibleText(data.get("option"));
    }
    @Then("Verify that selected value option")
    public void verify_that_selected_value_option(DataTable dataTable) {
        String dropvalue = select.getFirstSelectedOption().getText();
        Map<String, String> data = dataTable.asMaps().get(0);
        Assert.assertEquals(dropvalue,data.get("option"));
    }








}
