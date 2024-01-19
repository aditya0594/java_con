package Java_Concept;

public class exception_Handing {
    public static void main(String[] args) {
        System.out.println( "before the exception");
        try {
            int a = 99 / 0;
        }
        catch (ArithmeticException e){
            System.out.println("You can not divide by number 0");
        }
        System.out.println("After the exception");

    }
}
