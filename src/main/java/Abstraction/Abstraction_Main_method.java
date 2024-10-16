package Abstraction;

public class Abstraction_Main_method extends Abstraction_childMethod{
    public static void main(String[] args) {
        Abstraction_childMethod obj = new Abstraction_childMethod();
        obj.myMethod();
        obj.myMethod(10);

    }
}

/** In a Selenium framework, abstract classes are typically used to define common behaviors and attributes
 * that can be shared across multiple test classes or components. Here are some common uses of abstract classes in a Selenium framework:

 1. Base Page Class
 An abstract base page class is often created to define common methods and properties for all page objects.
 This class can include methods for common actions like clicking, sending keys, and other interactions with web elements.


 public abstract class BasePage {
 protected WebDriver driver;

 public BasePage(WebDriver driver) {
 this.driver = driver;
 }

 public void click(WebElement element) {
 element.click();
 }

 public void enterText(WebElement element, String text) {
 element.sendKeys(text);
 }

 // Abstract method to be implemented by subclasses
 public abstract void waitForPageToLoad();
 }





 public class LoginPage extends BasePage {

 public LoginPage(WebDriver driver) {
 super(driver);
 }

 @Override
 public void waitForPageToLoad() {
 // Implement the wait logic specific to the login page
 }

 public void login(String username, String password) {
 // Login logic
 }
 }

 public class LoginTest extends BaseTest {

 @Test
 public void testLogin() {
 driver.get("https://example.com/login");
 LoginPage loginPage = new LoginPage(driver);
 loginPage.login("user", "pass");
 }

 @Override
 public void runTest() {
 // Implement the test logic
 }
 }
**/