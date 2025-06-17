package Java_Concept;

import java.io.*;

public class Check_unchecked_exception {

    /***
     1. Checked Exceptions
     Checked exceptions are checked at compile time.
     If a method throws a checked exception, it must be either handled using a try-catch block
     or declared using throws in the method signature.
     These exceptions usually occur due to external factors (e.g., file I/O, network issues).

     Examples of Checked Exceptions:
     IOException (e.g., when reading a file)
     SQLException (e.g., database access errors)
     FileNotFoundException
     InterruptedException


     what is difference between throw and throws
     Feature	throw	                              throws
     Purpose	Used to actually throw an exception	  Declares that a method may throw an exception
     Location	Used inside a method	              Used in method signature
     Usage	    Followed by an exception object	      Followed by exception class name(s)
     Count	    Can throw one exception at a time	  Can declare multiple exceptions
     Example	throw new IOException();	          public void read() throws IOException

     */


    // Example of Throws keyword
    public void myMethod1() throws InterruptedException {
        Thread.sleep(1000);
    }

    //Example of Throw keyword

    /**
     * What is throw in Java?
     * The throw keyword is used to manually throw an exception in Java.
     */
    public static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Access denied - You must be at least 18 years old.");
        } else {
            System.out.println("Access granted - You are old enough!");
        }
    }


    public static void main(String[] args) throws InterruptedIOException, InterruptedException {

        //checkAge(1);

        try {
            FileReader file = new FileReader("test.txt");// Might throw FileNotFoundException
            FileInputStream fis = new FileInputStream(" ");
            BufferedReader br = new BufferedReader(file);
            System.out.println(br.readLine());
            br.close();
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("This is the error we found " + e);
        }


        /***
         Unchecked Exceptions (Runtime Exceptions)
         Unchecked exceptions occur at runtime and are not checked at compile time.
         These usually result from logical errors or programming mistakes
         (e.g., dividing by zero, accessing an invalid index in an array).
         They extend RuntimeException and do not require explicit handling.
         Examples of Unchecked Exceptions:
         NullPointerException
         ArithmeticException (e.g., division by zero)
         ArrayIndexOutOfBoundsException
         IllegalArgumentException
         ClassCastException
         */

        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // Will throw ArrayIndexOutOfBoundsException
            throw new ArrayIndexOutOfBoundsException("This is message from the throw ");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        try {
            int result = 10 / 0; // Will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }

    }
}


