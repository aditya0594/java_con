package Java_Concept;

public class Difference_between_String_StringBuffer {

    /**
     When to use String?
    When dealing with fixed values (e.g., test case names, expected results).
    For comparing values (equals(), contains(), etc.).
    When using immutable data to avoid unintended modifications.

     🔹 When to use StringBuffer?
    When working with large or dynamic test data (e.g., modifying API request payloads).
    When constructing test logs, error messages, or HTML reports dynamically.
    When concatenating multiple strings in loops (improves performance).**/

    public static void main(String[] args) {
        String str = "Hello";
        str = str +"World";
        System.out.println(str);

        StringBuffer strBuffer = new StringBuffer("Hello");
        strBuffer.append("World");
        System.out.println(strBuffer);
    }

}
