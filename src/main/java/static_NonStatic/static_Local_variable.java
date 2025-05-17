package static_NonStatic;

public class static_Local_variable {

    String name; //instance variable
    static String city = "Nagpur"; //static variable
    String address;



    public static_Local_variable(String name,String address ){ // this is local variable

        this.name = name;
        this.address = address;

    }
    public void getAddress(){

        System.out.println(address + " " + city);
    }

    public static void main(String[] args) {
        static_Local_variable obj = new static_Local_variable("aditya","Chatrapati");
        static_Local_variable obj1 = new static_Local_variable("Ram","khamal");

    }


    // Overloaded static method with two parameters
    public static void display(String a, int b) {
        System.out.println("String and Integer: " + a + ", " + b);
    }
    // Overloaded static method with one int parameter
    public static void display(int a) {
        System.out.println("Integer parameter: " + a);
    }

}

/**
 Why?
 Method overriding happens in inheritance, where a subclass provides a specific implementation of a method already defined in its superclass.
 For overriding to work, methods must be instance methods.
 Static methods belong to the class, not to instances (objects), so they are not polymorphic.


 1. Can we overload static methods in Java?
 ✅ Yes.
 Explanation: Overloading depends on the method signature (name + parameter list), not on whether the method is static or not.


 2. Can we override static methods in Java? Why or why not?
 ❌ No.
 Explanation: Static methods belong to the class, not instances. Overriding applies to instance methods that support runtime polymorphism.
 Defining a static method in a subclass with the same signature is called method hiding, not overriding.

 3. What happens if a subclass defines a static method with the same signature as a static method in the superclass?
 🟡 It hides the superclass method.
 Explanation: This is called method hiding. The method call is resolved using the reference type, not the object type.


4. If a static method is inherited by a subclass, can it be called without redefining it?
 ✅ Yes.
 Explanation: Static methods can be inherited (unless private), and they can be accessed using SubclassName.methodName() even if not overridden.

 5. Can you overload a method by only changing the return type?
 ❌ No.
 Explanation: Return type is not part of the method signature. Overloading must change parameter types or number of parameters.

 6. Why is method hiding not considered true polymorphism?
 Because it does not depend on the runtime object; it depends on the reference type and is resolved at compile time.

7. How does the JVM resolve method calls for static vs non-static methods at runtime?
 Static methods: Resolved at compile time (early binding).

 Instance methods: Resolved at runtime (late binding).

 8. How does the JVM resolve method calls for static vs non-static methods at runtime?
 Static methods: Resolved at compile time (early binding).
 Instance methods: Resolved at runtime (late binding).

 9.Can static methods be abstract? Why or why not?
 ❌ No.
 Explanation: Abstract methods require implementation in a subclass, but static methods cannot be overridden. So combining them is logically incorrect.















 */