package SeleniumTopic;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_assert extends Base_Driver_driver{

    public Soft_assert() {
            super("chrome");  // Calling the parent class constructor to initialize Chrome browser
        }

        @Test
        public void softAssert(){
        //code to maximize chrome browser
        driver.manage().window().maximize();

        String baseURL = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(baseURL);

        SoftAssert softAssert = new SoftAssert();
        String getActualTitle = driver.getTitle();
        boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Practice Page");

        softAssert.assertEquals(getActualTitle, "Practice Page");
        softAssert.assertNotEquals(getActualTitle, "Practice Page");
        softAssert.assertNull(verifyTitle);
        softAssert.assertNotNull(verifyTitle);
        softAssert.assertAll();
        //code to close chrome driver
        driver.close();
    }

    public Soft_assert(String browser) {
        super(browser);
    }
}
