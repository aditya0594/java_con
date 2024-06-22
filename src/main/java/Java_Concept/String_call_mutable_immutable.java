package Java_Concept;

public class String_call_mutable_immutable {
   public static void main( String[]args) {
        //Example of using String
        String str = "Hello";
        str += " World";
        str.concat("world");// Concatenating strings // String in Java is an immutable (cannot grow)
                               // object that means it is constant and cannot be changed once it is created.
        System.out.println(str); // Output: Hello World

    }
    /*public static void main( String[]args) {
       // Example of String builder class
        StringBuilder str = new StringBuilder();
        str.append("Hello");
        str.append("World"); // Appending strings
        String string = str.toString(); // Converting StringBuilder to String
        System.out.println(string); // Output: Hello World

    }*/
 /*   public static void main(String[] args) {
        // Example of using StringBuffer
        StringBuffer sb = new StringBuffer();
        sb.append("Hello");
        sb.append(" World"); // Appending strings
        String result = sb.toString(); // Converting StringBuffer to String
        System.out.println(result); // Output: Hello World
    }*/

}
