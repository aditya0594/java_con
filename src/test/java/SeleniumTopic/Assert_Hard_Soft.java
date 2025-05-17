package SeleniumTopic;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert_Hard_Soft extends Selenium_other_methods {
    @Test(priority = 1, enabled = true)
        public void testHardAssert() {
            System.out.println("Before Hard Assert");

            // This assertion will fail, and the next line will not be executed
            Assert.assertEquals(1, 2, "Numbers are not equal!");
          //  Assert.assertNotEquals();
          //  Assert.assertFalse();
          //  Assert.assertTrue();
            System.out.println("After Hard Assert"); // This line will not be executed
        }

    @Test(priority = 2, enabled = true)
    public void testSoftAssert() {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Before Soft Assert");

        // This assertion will fail, but the next lines will still be executed
        softAssert.assertEquals(1, 2, "Numbers are not equal!");

        System.out.println("Between Soft Asserts");

        // Another assertion, which will also fail
        softAssert.assertTrue(false, "Condition is not true!");

        System.out.println("After Soft Asserts");

        // Collects all the assertions results
        softAssert.assertAll(); // This will mark the test as failed if any of the assertions failed
    }

}
/**
 * Hard Assertions
 Hard assertions immediately halt the execution of the test if the assertion fails.
 If a hard assertion fails, the other steps in the test method will not be executed.

 * Soft Asseertions
 Soft assertions allow the test to continue execution even if an assertion fails.
 All soft assertions within a test method are collected and reported together.
 To use soft assertions, you need to create an instance of SoftAssert and use its methods.
 At the end of the test method, you need to call assertAll() to aggregate the results of all the soft assertions.
  **/

