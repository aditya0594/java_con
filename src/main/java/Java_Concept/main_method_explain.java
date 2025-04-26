package Java_Concept;

public class main_method_explain {

    public  void main(String[] args) {
        System.out.println("without method");
    }

    /**
     public static void main(String[] args)
     This is the starting point of any Java program.
     Each word has a meaning:

     public: It means anyone (like JVM) can call this method from outside the class.
     static: It means you don't need to create an object of the class to run this method. JVM can directly call it.
     void: This method does not return anything.
     main: The name of the method. JVM looks for a method with this exact name to start the program.
     String[] args: It means the program can accept command line arguments (values passed while starting the program).


     Why is main method public?	 : So that JVM can access it from outside the class.
     Why is main method static?	 : So JVM doesn't need to create an object to run it.
     Why is the return type void?	Because main doesn't need to return anything to JVM.
     What is String[] args? : 	It is used to accept input from the command line.String[] args is a single-dimensional array — it means:
     It can hold multiple String values in a single line (one dimension).
     Example: ["apple", "banana", "cherry"]

     Each value can be accessed like args[0], args[1], etc.
     Can we change the name main?	No, JVM specifically looks for main.
     Can we remove String[] args?	No, it's part of the required method signature.
     Can we write String args[] instead?	Yes, both String[] args and String args[] are allowed.






















     */
}
