package Java_Concept;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Map_TreeMap {
    public static void main(String[] args) {
        // TreeMap implements the NavigableMap interface and extends AbstractMap.
        // It maintains a sorted order of keys in natural order (ascending).
        // It does not allow null keys but allows multiple null values.
        // It is not synchronized (not thread-safe).

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "Alice");
        treeMap.put(3, "Charlie");
        treeMap.put(2, "Bob");
        treeMap.put(5, "Eve");
        treeMap.put(4, "David");
        treeMap.put(6, null); // Allows null values
        // treeMap.put(null, "Frank"); // This will throw a NullPointerException

        System.out.println("-----------Using for-each loop----------------------");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println("---------------Replace-----------");
        treeMap.replace(2, "Bob", "Bobby");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println("---------------Remove-----------");
        treeMap.remove(3);
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println("-------------Using iterator--------------------");
        Set<Map.Entry<Integer, String>> set = treeMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println("-------------Using values() and keys()--------------------");
        System.out.println("Values:");
        for (String value : treeMap.values()) {
            System.out.println(value);
        }

        System.out.println("Keys:");
        for (Integer key : treeMap.keySet()) {
            System.out.println(key);
        }

        System.out.println("-------------Using entrySet with Iterator--------------------");
        Set<Map.Entry<Integer, String>> entrySet = treeMap.entrySet();
        Iterator<Map.Entry<Integer, String>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println("-------------First and Last Entry--------------------");
        System.out.println("First Entry: " + treeMap.firstEntry());
        System.out.println("Last Entry: " + treeMap.lastEntry());

        System.out.println("-------------Higher and Lower Key Example--------------------");
        System.out.println("Higher Key than 2: " + treeMap.higherKey(2));
        System.out.println("Lower Key than 4: " + treeMap.lowerKey(4));
    }
}
