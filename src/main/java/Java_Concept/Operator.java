package Java_Concept;

public class Operator {
    /**
     1. What is the difference between == and equals?

     == Operator
     Reference Comparison:
     For objects, the == operator compares the memory addresses (references) of the objects to determine
     if they refer to the same instance.
     For primitive data types (int, char, etc.), the == operator compares the actual values.

     equals() Method
     Content Comparison:

     The equals() method, which is defined in the Object class and can be overridden in other classes,
     compares the content or state of two objects.
     By default, equals() in the Object class behaves like == (compares references).
     However, many classes, such as String, Integer, etc., override this method to compare the actual content.
     **/
}
