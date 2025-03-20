package Java_Concept;

import java.util.Iterator;
import java.util.TreeSet;

public class Set_treeSet {

    public static void main(String[] args) {
        // TreeSet implements the Set interface in Java.
        // TreeSet does not allow duplicate values.
        // TreeSet maintains elements in sorted (ascending) order.
        // TreeSet does not allow null values.
        // TreeSet is completely object-based and does not provide a get() method.
        // TreeSet, HashSet, and LinkedHashSet implement the Set interface.
        // Common methods include .add(), .remove(), .size(), and .contains().

        System.out.println("-----------------TreeSet Example---------------------");

        // Creating a TreeSet
        TreeSet<String> treeSet = new TreeSet<>();

        // Adding elements to TreeSet
        treeSet.add("USA");
        treeSet.add("INDIA");
        treeSet.add("UK");
        treeSet.add("America");
        // treeSet.add(null); // Uncommenting this line will cause a NullPointerException
        treeSet.add("INDIA"); // Duplicate values are ignored

        // Printing the TreeSet
        System.out.println("TreeSet elements: " + treeSet);

        // Checking if the set is empty
        System.out.println("Is TreeSet empty? " + treeSet.isEmpty());

        // Iterating using Lambda Expression
        System.out.println("-----------------Lambda Expression---------------------");
        treeSet.forEach(value -> System.out.println(value));

        // Iterating using for-each loop
        System.out.println("-----------------For-each Loop---------------------");
        for (String value : treeSet) {
            System.out.println("This is the value: " + value);
        }

        // Printing size of TreeSet
        System.out.println("Size of TreeSet: " + treeSet.size());

        // Iterating using Iterator
        System.out.println("-----------------Iterator---------------------");
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); // Printing each element using Iterator
        }
    }
}
