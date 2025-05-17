package static_NonStatic;

public class static_and_nonStatic {
    // To share a single copy of a variable among all instances of a class
    // The static keyword in Java is used to share the same variable or method of a given class.
    // When you want all instances of a class to share the same data.
         static int StaticVariable = 20;
         int instance = 10;

         public static void method(){
             System.out.println("This is static method call in the nonstatic method");

         }
          public void nonStaticMethod() {
              method();
              int nonStaticVariable = 10;
              int sum = instance + nonStaticVariable;
              System.out.println("Add the variable " + instance + nonStaticVariable);
              System.out.println("This is the sum of the variable  " + sum);
              System.out.println("This is as non-static method with the static variable : " + StaticVariable);
        }

        public void display() {
            myMethod("Aditya");
        }
        public static void myMethod(String test){
            System.out.println("This is the static method");
           static_and_nonStatic obj1=new static_and_nonStatic();  // you can call the non-static method in static method
                                                                    // but by creating instance of it. not directly
            obj1.nonStaticMethod();
        }


        public static void main(String[] args) {
            myMethod("Aditya"); // this is the static method call in the nonstatic method
        }
    }

    /**
     Q1: What is a static variable and how is it used in your code?
     Answer:
     A static variable is shared by all objects of the class.
     In my code, StaticVariable = 20 is static, so every object will use the same value.
     It saves memory and is used when the value should be common.


     Q2: What is the difference between static and non-static variables?
     Answer:
     Static variable: Belongs to the class and shared by all objects.
     Non-static (instance) variable: Each object has its own copy.

     static int StaticVariable = 20;  // shared
     int instance = 10;     // unique to each object

     Q3: Can we call a static method from a non-static method?
     Answer:
     Yes, directly.
     In my code, inside nonStaticMethod(), I call method(), which is static.

     Q4: Can we call a non-static method from a static method?
     Answer:
     Yes, but only using an object.
     In myMethod(String test), I created an object obj1 to call obj1.nonStaticMethod();.

     Q5: Why is the main method static in Java?
     Answer:Because the JVM calls main() without creating an object. Static allows it to run first.

     Q6 :What happens if you try to access a non-static variable inside a static method directly?
     Answer:
     You will get a compile-time error.
     In a static method, you need an object to access non-static variables.

     Q7: Is it possible to override static methods?
     Answer:
     No. Static methods belong to the class, not objects, so they cannot be overridden,
     only hidden (if redefined in child class).

     Q8 :What is Method Hiding?
     When a child class defines a static method with the same name and signature as a static method in the parent class
     , it is called method hiding — not overriding.


     */
