package Java_Concept;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Map_LinkedHashMap {
    // The LinkedHashMap is a class in the Java Collection Framework that implements the Map interface and extends the HashMap class.
// It maintains a **doubly-linked list** running through its entries, which preserves the **insertion order** of keys.
// That means, when iterating through a LinkedHashMap, the elements are returned in the order they were inserted.
// Like HashMap, it allows:
//     - One null key,
//     - Multiple null values,
//     - Unique keys (duplicate keys overwrite existing values).
// LinkedHashMap is **non-synchronized**, meaning it is **not thread-safe**. External synchronization is needed for concurrent access.
// It provides better performance than HashMap when iteration order is important, but slightly slower than HashMap for insertions
// and deletions due to the linked list overhead.
// LinkedHashMap has a special constructor that allows it to operate in **access-order** mode instead of insertion order —
// useful for implementing **LRU (Least Recently Used) caches**.


    public static void main(String[] args) {

        // LinkedHashMap maintains insertion order
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();

        // Adding key-value pairs
        lhm.put(10, "Java");
        lhm.put(20, "Selenium");
        lhm.put(30, null);      // null value is allowed
        lhm.put(null, "Python"); // one null key is allowed
        lhm.put(40, "API");
        lhm.put(50, null);      // another null value

        System.out.println("------------ LinkedHashMap (Insertion Order) ------------------");
        for (Map.Entry<Integer, String> entry : lhm.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " | Value: " + entry.getValue());
        }

        // Replace a value
        System.out.println("------------ Replace Example ------------------");
        lhm.replace(20, "Selenium", "Test Automation");
        System.out.println("After replacing key 20:");
        for (Map.Entry<Integer, String> entry : lhm.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " | Value: " + entry.getValue());
        }

        // Remove a key
        System.out.println("------------ Remove Example ------------------");
        lhm.remove(30);
        for (Map.Entry<Integer, String> entry : lhm.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " | Value: " + entry.getValue());
        }

        // Using Iterator
        System.out.println("------------ Using Iterator ------------------");
        Set<Map.Entry<Integer, String>> entrySet = lhm.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + " | Value: " + entry.getValue());
        }

        // Using values()
        System.out.println("------------ Using values() ------------------");
        for (String val : lhm.values()) {
            System.out.println("Value: " + val);
        }

        // Using keySet()
        System.out.println("------------ Using keySet() ------------------");
        for (Integer key : lhm.keySet()) {
            System.out.println("Key: " + key);
        }
    }
}
