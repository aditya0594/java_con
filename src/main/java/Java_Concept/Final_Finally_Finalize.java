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

        finally {  // use of finally is in the try-catch block and we can use the finally if we want to print run after the try-catch block
            System.out.println("this is finally block");
        }


    }
}
