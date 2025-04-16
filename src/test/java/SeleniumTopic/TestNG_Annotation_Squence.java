package SeleniumTopic;

public class TestNG_Annotation_Squence {
    /**
     @BeforeSuite
     @BeforeTest
     @BeforeClass
     @BeforeMethod
     @Test
     @AfterMethod
     @AfterClass
     @AfterTest
     @AfterSuite


     Annotation	Description
     @BeforeSuite	 Runs once before the entire test suite starts (e.g., setup config, DB connection).
     @BeforeTest	 Runs before <test> tag in testng.xml (e.g., launch browser, test-level setup).
     @BeforeClass	 Runs before the first method in the current class is invoked.
     @BeforeMethod 	 Runs before each @Test method. Ideal for test preconditions.
     @Test	         The actual test method. You can have multiple in a class.
     @AfterMethod	 Runs after each @Test method. Useful for cleanup.
     @AfterClass	 Runs after all test methods in the current class are done.
     @AfterTest	     Runs after <test> tag in testng.xml.
     @AfterSuite	 Runs once after all tests in the suite have completed.

     */
}
