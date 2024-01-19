package Java_Concept;

public class Final_Finally_Finalize {
    public static void main(String[] args) {
        // Non final variable
        int a = 5;

        // final variable
        final int b = 6;

        // modifying the non final variable : Allowed
        a++;

        // modifying the final variable :
        // Immediately gives Compile Time error.
        //b++;
    }
}
