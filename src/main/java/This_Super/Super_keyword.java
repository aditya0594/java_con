package This_Super;


//You can use super() to call the constructor of the parent class. This must be the first line in the subclass constructor.
// 1. Calling the Parent Class Constructor
//You can use super() to call the constructor of the parent class. This must be the first line in the subclass constructor.
public class Super_keyword {
    Super_keyword() {
        System.out.println("Parent constructor");
    }
}

class Child extends Super_keyword {
    Child() {
        super(); // calls Parent's constructor
        System.out.println("Child constructor");
    }
}

//2. Calling the Parent Class Method
//If the child class overrides a method from the parent class, you can still call the parent version using super.methodName().

class Parent {
    void display() {
        System.out.println("Parent display");
    }
}

class Child1 extends Parent {
    void display() {
        super.display(); // calls Parent's display method
        System.out.println("Child display");
    }
}


