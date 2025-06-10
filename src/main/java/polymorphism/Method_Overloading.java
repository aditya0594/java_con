package polymorphism;

public class Method_Overloading {
    //we have seen method signature. At compile time, Java knows which method to invoke by checking the method signatures.
    // So this is called compile time polymorphism or static binding.

    public void myMethod(int a , String b){
        System.out.println("This accept the two parameter of int and string  :" + a +" "+ b);
    }
    public void myMethod(String a, int b){
        System.out.println("This accpet the two parameter of String and int  :"+ a + " "+ b);
    }
    public static void main(String[] args){
        Method_Overloading obj = new Method_Overloading();
        obj.myMethod(12, "Aditya");
        obj.myMethod("Pawar",13);
    }

    /**
    Why would you use method overloading?
    Answer: Method overloading improves code readability and usability.
    It allows the creation of methods that perform similar tasks but accept different inputs,
    thus providing flexibility and reducing the need for multiple method names.

    Can overloaded methods be static? Can overridden methods be static?

    Answer: Yes, overloaded methods can be static or instance methods. However, overridden methods cannot be static. If a static
    method is defined in a subclass with the same signature as in the superclass, it is hiding the superclass method, not overriding it.
    In short, in the methodoverring if the method of parent class is static then it hiding the superclass methods. it will not override.


    Can you overload a method by changing only its return type?
    Answer: No, you cannot overload a method by changing only its return type. The parameter list must be different; otherwise,
    the compiler will not be able to distinguish between the methods.


    How is method overloading related to constructor overloading?

    Answer: Constructor overloading is a specific type of method overloading where multiple
    constructors with different parameter lists are defined within a class.
    This allows creating objects in different ways.


    Can you overload a constructor? If yes, how?
    Answer: Yes, you can overload constructors in the same way as methods. For example
    public class Person {
        private String name;
        private int age;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}





*/

}
