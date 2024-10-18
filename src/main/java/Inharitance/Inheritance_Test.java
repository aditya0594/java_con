package Inharitance;

public class Inheritance_Test {
    public static void main(String arg[] ){

        Class_B obj = new Class_B();
        Class_C obj1 = new Class_C();

       // Class_A obj2 = new Class_C();

        obj.MethodClassA();
        obj1.MethodClassC();

    }
}

/**
  1. Logical Hierarchy and Design
 Natural Hierarchy: Inheritance represents an "is-a" relationship.
 A child class is a specialized version of a parent class. For example, a Dog "is a" Animal, but an Animal is not necessarily a Dog.
 Allowing parent classes to inherit from child classes would violate this logical hierarchy.
 Design Consistency: In OOP design, inheritance flows in one direction from a more general class to a more specific class.
 This maintains design consistency and makes the code easier to understand and maintain.

  2. Complexity and Ambiguity
  Increased Complexity: If parent classes could inherit from child classes, it would create a circular dependency.
 This would significantly increase the complexity of the code, making it harder to understand, debug, and maintain.
 Ambiguous Relationships: Allowing bidirectional inheritance would create ambiguity in the relationship between classes.
 It would be unclear which properties and methods belong to which class, leading to confusion.

  3. Violation of OOP Principles
  Encapsulation: One of the key principles of OOP is encapsulation,
 which ensures that a class's implementation details are hidden from other classes.
 Allowing parent classes to inherit from child classes would break encapsulation by exposing child class details to the parent class.
 Polymorphism: Polymorphism allow`s objects to be treated as instances of their parent class rather than their actual class.
 This principle relies on the unidirectional inheritance hierarchy, where the child class can be treated as the parent class,
 but not vice versa.
 **/