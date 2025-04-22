package Java_Concept;

import static com.google.common.primitives.UnsignedInts.divide;

public class Final_Finally_Finalize {
    public static void main(String[] args) {
        // Non final variable
        int a = 5;
        a++;
        System.out.println("Print a value : "+ a);

        // final variable
        final int b = 6;
        //b++;  // Immediately gives Compile Time error.
        System.out.println("Print a value : "+ b);
        // modifying the non final variable : Allowed

        //b++;
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        }
        catch(Exception e){
            System.out.println("find inside the method");
            throw e;
        }

        finally {  // use of finally is in the try-catch block and we can use the finally
            // if we want to print run after the try-catch block
            System.out.println("this is finally block");
        }


    }
}


/**

 What is the difference between throw and throws? How do they relate to try-catch?
 ✅ Answer: throw is used to explicitly throw an exception.
 throws is used to declare that a method might throw an exception.
 If a method uses throws, you must handle that exception with a try-catch or propagate it further.
 


 1. What will happen if an exception is not caught in the catch block? Will the finally block still execute?
 ✅ Answer: Yes, the finally block will always execute, whether or not the exception is caught.
 Even if there's a return statement in the try or catch, the finally block still runs before the method exits.


 2. Can we have a try block without a catch, and only a finally? If yes, what's the use case?
 ✅ Answer: Yes, Java allows a try block with only a finally block.
 It's used when you want to ensure some cleanup (like closing resources) is always done, regardless of whether an exception occurs.

 3. What happens if both the try and finally blocks contain a return statement? Which one will be executed?
 ✅ Answer: The return in the finally block overrides the return from the try block.
 This can lead to unexpected behavior, so it’s generally advised not to return from a finally block.

 4. What is the purpose of the finally block when the exception is re-thrown in the catch block?
 ✅ Answer: Even when you re-throw the exception from the catch, the finally block still executes.
 It ensures that important cleanup operations (like releasing locks or closing files/drivers) happen before the exception propagates further.

 5. Can the finally block throw an exception? If yes, what happens to the original exception?
 ✅ Answer: Yes, the finally block can throw an exception.
 If it does, the original exception from try or catch is suppressed and the new exception from finally is thrown.
 This can make debugging harder.

 6. In Selenium automation, where would you typically use a try-catch-finally block? Give an example.
 ✅ Answer: A common use case is ensuring that the browser is closed even if a test fails:
 WebDriver driver = new ChromeDriver();
 try {
        driver.get("https://example.com");
        // test steps
    } catch (Exception e) {
         System.out.println("Exception caught: " + e.getMessage());
    } finally {
 driver.quit(); // Always close the browser
    }



 7. How would you ensure that your WebDriver session closes even if your test case fails due to an exception?
 ✅ Answer: Use the finally block to call driver.quit() so that the browser closes regardless of the test result.
 This prevents memory leaks and open browser instances.

8.How can we handle exceptions without failing the entire test suite? How does this relate to try-catch?
 ✅ Answer: Use try-catch to log exceptions, take screenshots, or mark specific steps as failed while allowing the rest of the tests to continue.
 Frameworks like TestNG or JUnit can also be used with custom listeners or retry analyzers to handle test failures gracefully.










 */