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
     */
    //Example  :
    public static void main(String[] args) {

        try{
        FileReader file = new FileReader("test.txt");// Might throw FileNotFoundException
        FileInputStream fis = new FileInputStream(" ");
            BufferedReader br = new BufferedReader(file);
            System.out.println(br.readLine());
            br.close();
            Thread.sleep(5000);
        }catch( Exception e ) {
            System.out.println("This is the exception " + e);
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


                int a = 10, b = 0;
                int result = a / b; // Throws ArithmeticException
                System.out.println(result);
            }
        }


