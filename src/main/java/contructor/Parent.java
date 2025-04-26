package contructor;

public class Parent {
    Parent(String message) {
        System.out.println("Parent constructor: " + message);
    }
}

class Child extends Parent {
    Child(String message) {
        super(message);
    }
    // No constructor defined here
}

