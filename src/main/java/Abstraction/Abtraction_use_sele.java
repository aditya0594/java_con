package Abstraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Abtraction_use_sele{
    /**
    Methods in Page Object Classes:
     Instead of directly interacting with Selenium WebDriver in test cases,
    methods are created in the Page Object classes to perform actions like clicking a button, entering text,
    or getting the text of a label. This hides the complexity of interacting with the WebDriver API from the test cases

     **/

    private WebDriver driver;

    // Web elements
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login");

    // Constructor
    public void LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Abstraction of entering username
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Abstraction of entering password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Abstraction of clicking login button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

/**
 Utility Classes as Abstractions:
 Common Utilities: Utility classes can be used to abstract commonly used helper
 methods such as reading data from files, handling waits, or performing assertions.
 This avoids repetition and makes the code more modular.
 */



}
