package Java_Concept;

public class main_method_without_static {

    public void myMain(String arg[]) {
        System.out.println("This is main method");
    }

    public static void main(String[] args) {
        main_method_without_static instance = new main_method_without_static();
        instance.myMain(args);
    }
}







  /*  In Java, the main method is the entry point of any standalone Java application.
    It is defined with the static keyword to allow the Java Virtual Machine (JVM) to call it without creating an instance of the class.
   */
   /** public: This is an access modifier that means the method can be called from outside the class. It's necessary because the JVM needs to call this method to start the application.

    static: This means the method belongs to the class rather than an instance of the class. This is necessary because the JVM invokes the main method without creating an instance of the class.

    void: This means the method does not return any value.

    main: This is the name of the method. It's a special method name that the JVM looks for as the starting point of the program.

    String[] args: This is an array of String arguments. It allows the program to accept command-line arguments.

    Common Interview Questions and Answers
1. Why is the main method static?
    Question: Why do we use the static keyword in the main method?

    Answer: The main method is static because it needs to be called by the JVM without creating an instance of the class.
    If it were not static, the JVM would need to instantiate the class to invoke the method,
    which could lead to a circular dependency problem.

    2. Can we have multiple main methods in a class?
    Question: Can a class have more than one main method?

    Answer: Yes, a class can have multiple overloaded main methods,
    but only the one with the signature public static void main(String[] args) will be
    used as the entry point of the application by the JVM.

    3. What happens if the main method is not public?
    Question: What if the main method is not public?

    Answer: If the main method is not public, the JVM will not be able to access it and will throw a runtime error:
    Main method not found in class <ClassName>, please define the main method as: public static void main(String[] args).

    4. Can we change the parameter of the main method?
    Question: Can we change the parameter of the main method from String[] args to something else?

    Answer: No, the JVM requires the main method to have a specific signature: public static void main(String[] args).
    If you change the parameter type or remove it, the JVM will not recognize it as the entry point of the program.

    5. What is the significance of String[] args?
    Question: What is the significance of String[] args?

    Answer: String[] args allows the program to accept command-line arguments.
    These arguments can be used to pass information into the program at runtime.
    For example, if you run java MyClass arg1 arg2, args will be an array containing ["arg1", "arg2"].

    6. What happens if there is no main method in a Java class?
    Question: What happens if there is no main method in a Java class?

    Answer: If a Java class does not have a main method with the signature public static void main(String[] args),
    the JVM will throw a runtime error: Main method not found in class <ClassName>,
    please define the main method as: public static void main(String[] args).

    7. Can we override the main method?
    Question: Can we override the main method?

    Answer: No, the main method cannot be overridden because it is static.
    Static methods belong to the class, not instances of the class, and thus do not participate in polymorphism.

    8. What is the return type of the main method?
    Question: Why does the main method have a return type of void?

    Answer: The main method has a return type of void because it does not return any value.
    The primary purpose of the main method is to serve as the entry point for the JVM to start the application.
    Any termination status of the application is typically conveyed using System.exit().**/

