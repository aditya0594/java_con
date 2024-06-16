package Java_Concept;

import static com.google.common.primitives.UnsignedInts.divide;

public class exception_Handing {

    public  void fun(){

        // What if we don't know what kind of exception thrown so what we use -- we use the Exception class
        // Q. Why we use the excetion handling :
        // when we run the code and if the exception occured it will disrupts it normal flow.
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        }
        catch(Exception e){
            System.out.println("find inside the method");
            throw e;
        }

        finally {
        System.out.println("this is finally block");
         }
    }
    public static void main(String[] args) {
        exception_Handing obj = new exception_Handing();
        obj.fun();
    }
}
