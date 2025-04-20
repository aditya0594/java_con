package Java_Concept;

public class String_call_mutable_immutable {
   public static void main( String[]args) {
        //Example of using String
        String str = "Hello";
        str += " World";
        str.concat("world"); // Concatenating strings // String in Java is an immutable (cannot grow)
                                // object that means it is constant and cannot be changed once it is created.
        System.out.println(str); // Output: Hello World


       StringBuffer sbf = new StringBuffer("Hello");
       sbf.append(" World");
       System.out.println(sbf); // Output: Hello World

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

/**

 1. What is the difference between String, StringBuffer, and StringBuilder?
 Answer:

 String: Immutable, meaning once a String object is created, it cannot be changed. Every modification creates a new String object.

 StringBuffer: Mutable and thread-safe, meaning it can be changed after creation and is synchronized,
 making it safe to use in a multi-threaded environment.

 StringBuilder: Mutable but not thread-safe. It is similar to StringBuffer but is not synchronized,
 making it faster for use in a single-threaded environment.

 2. Why is String immutable in Java?
 Answer:

 Security: Immutable objects are inherently thread-safe, reducing the chances of data corruption.
 Caching: Because String objects are immutable, they can be safely cached and reused, improving performance.
 String Pool: The immutability of String allows for the implementation of the string pool,
 where identical String literals are shared, saving memory.

 3. When should you use String, StringBuffer, or StringBuilder?
 Answer:

 String: Use when the string value will not change. For example, when working with string literals or when thread safety is not a concern.
 StringBuffer: Use when you need to modify the string value in a multi-threaded environment.
 StringBuilder: Use when you need to modify the string value in a single-threaded environment, as it is faster than StringBuffer.

 4. Can you show an example of how to append text using StringBuffer and StringBuilder?

 StringBuffer sbf = new StringBuffer("Hello");
 sbf.append(" World");
 System.out.println(sbf); // Output: Hello World

 // Using StringBuilder
 StringBuilder sbd = new StringBuilder("Hello");
 sbd.append(" World");
 System.out.println(sbd); // Output: Hello World

 5. Where do strings get stored, and where does reference get stored?

 In Java, memory management for strings and references involves both the heap and the stack.
 Here's a detailed explanation of where strings and their references are stored:

 Heap Memory
 Strings in the Heap:

 Strings in Java are objects and are stored in the heap memory.
 There are two primary areas in the heap where strings can be stored:
 A. String Pool (String Intern Pool): A special memory region for string literals.
 B. Heap (Non-Pool Area): General heap memory for string objects created using the new keyword.

 String Pool:

 When a string literal is created, it is stored in the string pool.
 If the same literal is encountered again, Java reuses the existing object from the string pool instead of creating a new one.
 This ensures efficient memory usage and performance for commonly used strings.

 Stack Memory

 References in the Stack:
 References to objects, including strings, are stored in the stack memory.
 Each reference variable in a method resides in the stack frame corresponding to that method.
 The stack frame is created when a method is invoked and destroyed when the method execution is complete.

 | Stack Frame for main() method |
 |-------------------------------|
 | s1 -> reference to "Hello"    |
 | s2 -> reference to "Hello"    |
 | s3 -> reference to new "Hello"|
 |-------------------------------|


 | Heap Memory                    |
 |--------------------------------|
 | String Pool                    |
 | "Hello"                        |
 |--------------------------------|
 | General Heap                   |
 | new String("Hello")            |
 |--------------------------------|




 6.  Can you please explain the memory location and how the string is
 immutable?

 When you attempt to modify a String object,
 Java creates a new String object rather than altering the existing one. This is achieved by the following:

 Private Final Fields: The String class has a private final field char[] value that stores the characters of the string.
 Being final means it cannot be reassigned.

 7. What can be used if you do not want to use the String class?

 If you do not want to use the String class in Java, there are several alternatives you can consider,
 depending on your requirements. Here are a few options:

 1. StringBuilder
 Use Case: StringBuilder is ideal for building and manipulating strings in a mutable way.
 It is not thread-safe but provides better performance for single-threaded operations.
 2. StringBuffer
 Use Case: StringBuffer is similar to StringBuilder but is thread-safe.
 It should be used when you need mutable strings in a multi-threaded environment.

 3.  Character Array
 Use Case: If you need more control over the individual characters and the memory usage, you can use a character array.
 char[] charArray = {'H', 'e', 'l', 'l', 'o'};
 String result = new String(charArray);
 System.out.println(result);// Outputs: Hello

 4. Byte Array
 Use Case: For handling raw binary data or encoding-specific text manipulation, you can use a byte array.
 byte[] byteArray = {72, 101, 108, 108, 111}; // ASCII values for 'H', 'e', 'l', 'l', 'o'
 String result = new String(byteArray);
 System.out.println(result);// Outputs: Hello
 */
