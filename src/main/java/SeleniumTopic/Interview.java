package SeleniumTopic;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

public class Interview extends Base_Driver_driver {

    public Interview() {
        super("chrome");  // Calling the parent class constructor to initialize Chrome browser
    }

    @Test(priority = 1,enabled = true)
    public void Window_Basic_Auth(){
        //driver.get("https://demo.automationtesting.in/Register.html");
        driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    }

    /***

     Selenium WebDriver is one of the most widely used tools for automated testing of web applications. Here are its key advantages:

     1. Cross-Browser Testing
     Selenium WebDriver supports testing on multiple browsers, including Chrome, Firefox, Safari, Edge, and Opera.
     This ensures that your web application works consistently across different browsers.

     2. Support for Multiple Programming Languages
     Selenium WebDriver supports a variety of programming languages, such as Java, Python, C#, Ruby, JavaScript, and Kotlin.
     This flexibility allows testers to write scripts in a language they are comfortable with.

     3. Platform Independence
     Selenium WebDriver can run tests on different operating systems, including Windows, macOS, and Linux.
     This cross-platform capability makes it suitable for diverse testing environments.

     4. Rich API for Complex Testing
     It provides APIs to handle various web elements, such as text boxes, checkboxes, radio buttons, dropdowns, alerts, and more.
     WebDriver also supports advanced features like mouse and keyboard events, file uploads, and screenshots.

     5. Integration with Test Frameworks
     Selenium integrates seamlessly with testing frameworks like TestNG, JUnit, PyTest, and Cucumber, allowing structured and maintainable test scripts.
     It also supports Continuous Integration (CI) tools like Jenkins, Bamboo, and GitHub Actions.

     6. Open Source and Free
     Selenium WebDriver is open source, making it cost-effective and widely supported by the community.
     Extensive documentation and community support ensure issues can be resolved quickly.

     7. Scalability with Grid
     Selenium Grid enables distributed execution of tests across multiple machines and browsers in parallel.
     This significantly reduces test execution time.

     8. Real-World Browser Interaction
     WebDriver interacts directly with the browser, replicating real user behavior more accurately than older tools like Selenium RC.

     9. Support for Dynamic Content
     It can handle modern, dynamic web applications with technologies like AJAX and JavaScript.

     10. Customizable and Extensible
     Users can extend WebDriver functionality with custom libraries or integrate it with third-party tools like Appium for mobile testing.
     11. Wide Adoption and Community Support

     Selenium WebDriver has a large user base, leading to numerous tutorials, forums, and plugins that simplify learning and problem-solving.
     ***/


    /***
     what is different between the findelement and findelements?

     findElement	WebElement	Returns the first matching element found on the page.
     findElements	List<WebElement>	Returns a list of all matching elements found on the page. If no elements are found, returns an empty list.
                        FindElement                             Findelements
     Single Match	  Finds the first matching element only. 	        Finds all matching elements.
     No Match Found	  Throws a NoSuchElementException.	                Returns an empty list (List<WebElement>).
     Performance	  Stops searching after finding the first match.	Searches the entire DOM for all matches.
     ***/


    /***
     How do you locate elements on a web page using Selenium WebDriver?

     In Selenium WebDriver, you can locate elements on a web page using various locator strategies.
     These locators allow WebDriver to find and interact with elements like buttons, text fields, links, and more.




     xpath method to inspect the element

     Absolute Path	/html/body/div/form/input
     Relative Path	//input[@name='password']
     Contains text	//button[contains(text(),'Login')]
     Text match	//a[text()='Click here']
     Using and/or conditions	//input[@type='text' and @name='email']




     How do you handle dynamic elements on a web page in Selenium?

     Handling dynamic elements in Selenium can be challenging because such elements might load asynchronously,
     have dynamic attributes, or take time to appear. Here are several effective strategies to handle dynamic elements:
     1. Use Explicit Waits (Recommended Approach)
     Explicit waits help Selenium wait for a specific condition (e.g., element visibility, clickability) before proceeding.

     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     WebElement dynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicElement")));
     dynamicElement.click();

     2. Implicit Waits (Global Timeout)
     Implicit waits tell Selenium to wait for a set amount of time before throwing an exception if an element isn't found.
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.findElement(By.id("dynamicElement")).click();

     3.Using Fluent Wait (Custom Wait Conditions)
     Fluent wait allows for more flexibility, such as polling intervals and custom conditions.

     Wait<WebDriver> fluentWait = new FluentWait<>(driver)
     .withTimeout(Duration.ofSeconds(20))
     .pollingEvery(Duration.ofSeconds(2))
     .ignoring(NoSuchElementException.class);
     WebElement dynamicElement = fluentWait.until(driver -> driver.findElement(By.id("dynamicElement")));
     dynamicElement.click();









     */
}
