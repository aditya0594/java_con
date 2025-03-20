package Java_Concept;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class Set_LinkedHashSet {

    public static void main(String[] args) {
        // LinkedHashSet implements Set interface in Java.
        // LinkedHashSet doesn’t allow duplicate values.
        // LinkedHashSet maintains insertion order.
        // LinkedHashSet is completely object-based and does not provide get() method.
        // LinkedHashSet allows one null value but no duplicates.
        // LinkedHashSet, HashSet, and TreeSet implement the Set interface.
        // Common methods include .add(), .remove(), .size(), and .contains().

        System.out.println("-----------------LinkedHashSet Example---------------------");

        // Creating a LinkedHashSet
        LinkedHashSet<String> linkedSet = new LinkedHashSet<>();

        // Adding elements to LinkedHashSet
        linkedSet.add("USA");
        linkedSet.add("INDIA");
        linkedSet.add("UK");
        linkedSet.add(null); // Adding a null value
        linkedSet.add(null); // Duplicate null values are not allowed
        linkedSet.add("INDIA"); // Duplicate values are ignored

        // Printing the LinkedHashSet
        System.out.println("LinkedHashSet elements: " + linkedSet);

        // Checking if the set is empty
        System.out.println("Is LinkedHashSet empty? " + linkedSet.isEmpty());

        // Iterating using Lambda Expression
        System.out.println("-----------------Lambda Expression---------------------");
        linkedSet.forEach(value -> System.out.println(value));

        // Iterating using for-each loop
        System.out.println("-----------------For-each Loop---------------------");
        for (String value : linkedSet) {
            System.out.println("This is the value: " + value);
        }

        // Printing size of LinkedHashSet
        System.out.println("Size of LinkedHashSet: " + linkedSet.size());

        // Iterating using Iterator
        System.out.println("-----------------Iterator---------------------");
        Iterator<String> iterator = linkedSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); // Printing each element using Iterator
        }
    }
}
