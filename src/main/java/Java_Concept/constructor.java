package Java_Concept;

public class constructor {

    // Constructor execute block of code whenever the object is created.
    // Constructor didn't return any values
    // Name of the constructor should be the class name.
    // Whenever we create an object constructor is called

    // default constructor does not have the parameters
    /// Compiler will call implicit constructor if you have not defined any constructor
    // if you have two constructor and paramaterized constructor and defined one constructor in main method then
    // it will call the default constructor because compiler find the paramater are given or not


   private constructor(){  //default constructor
        String a = "default constructor";
        System.out.println(a);
    }


    private int a ;
    private int b ;
    private constructor(int a, int b){    // parameterized Constructor
        this.a = a;
        this.b = b;
        System.out.println("this is the parameterized constructor" + "And parameter value :" + a + ", "+b );
    }

    public static constructor getConstructor(int a, int b)
    {
      return new constructor(a, b);
    }



    public static void main(String[] arg){
       constructor obj = new constructor();
       constructor obj1 = new constructor(5,5);
    }


}

/**
 Question: Why does the MyClass obj1 = new MyClass(5, 5); line cause a compilation error?
 Answer: The MyClass(int a, int b) constructor is private, meaning it cannot be accessed from outside the MyClass class.
 This line will cause a compilation error because the constructor is not visible.

 Question: What is the purpose of a private constructor in Java?
 Answer: A private constructor is used to restrict the instantiation of a class.
 It is often used in singleton design patterns to ensure that only one instance of the class is created.
 It can also be used in utility classes that contain only static methods.

 Question: Can a class have both a default and parameterized constructor?
 Answer: Yes, a class can have both a default constructor and one or more parameterized constructors.
 This is an example of constructor overloading, where multiple constructors are defined with different parameter lists.

 Question: What is constructor overloading?
 Answer: Constructor overloading is the process of defining multiple constructors in a class with different parameter lists.
 This allows the creation of objects in different ways, providing flexibility in object creation.

 Question: How can you call a private constructor from outside the class?
 Answer: You cannot directly call a private constructor from outside the class.
 However, you can use a static method within the class to call the private constructor and return an instance of the class.
 This is often used in design patterns like the Singleton pattern.

 Question: What happens if you don't define any constructor in your class?
 Answer: If you don't define any constructor in your class,
 the Java compiler automatically provides a default no-argument constructor.
 This default constructor is public and does nothing (has an empty body).

 Question: Can a constructor be synchronized in Java?
 Answer: No, constructors cannot be synchronized in Java.
 Synchronization is used for methods, not constructors.
 However, you can synchronize the code inside the constructor.

 Question: What is the role of the "this" keyword in constructors?
 Answer: The "this" keyword in constructors is used to refer to the current object.
 It can be used to call another constructor in the same class (constructor chaining)
 or to distinguish between instance variables and parameters with the same name.

 Question: Why can't you use a return type in a constructor?
 Answer: Constructors are not methods and are used solely for initializing objects.
 They do not return any value, not even void.
 Including a return type in a constructor would make it a method, not a constructor.
-------------------------------------------------------------------------------------------
 1. Can you declare a top-level class as private in Java? Why or why not?
 Answer: No, you cannot declare a top-level class as private in Java.
 Top-level classes can only have public or package-private (default) visibility.
 A private modifier is not allowed because a private top-level class would not be accessible from anywhere outside its own file,
 rendering it effectively useless.

 2. What is the purpose of a private nested class in Java?
 Answer: A private nested class is used to encapsulate the functionality that is intended to be used only within
 the enclosing (outer) class. It helps in hiding the implementation details and enhances encapsulation,
 making the code more maintainable and modular.

 3. How can you access a private nested class from the outer class?
 Answer: You can access a private nested class from within the outer class by creating an instance of the private nested class
 inside a method or constructor of the outer class.

 4. What are the different types of nested classes in Java?
 Answer: In Java, there are four types of nested classes:

 Static nested class: Declared with the static keyword.
 Inner class: Non-static nested class.
 Local inner class: Defined within a method.
 Anonymous inner class: Defined and instantiated in a single statement, without a class name.

 **/