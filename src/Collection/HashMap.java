package Collection;


import java.awt.image.ImageProducer;
import java.util.Iterator;
import java.util.Map;

public class HashMap {
    public static void main(String[] args) {
       java.util.HashMap hm = new java.util.HashMap();
       hm.put(1, "Selenium");
       hm.put(2,"QTP");
       hm.put(3, "Testcomplete");

        System.out.println("---------------------------------");
        System.out.println("HashMap vale with the key " + hm.get(1));

        System.out.println("---------------------------------");
        // To print all the value of HASHMAP 

        System.out.println("HashMap vale with the key " + hm);

        // iterating through key/value mappings
        System.out.print("Entries: ");
        for(Object entry: hm.entrySet()) {
            System.out.print(" " +entry);
        }
        // iterating through keys
        System.out.print("\nKeys: ");
        for(Object key: hm.keySet()) {
            System.out.print(" "+ key);
            System.out.print(", ");
        }
        // iterating through values
        System.out.print("\nKeys: ");
        for(Object values: hm.values()) {
            System.out.print(" "+ values);
            System.out.print(", ");
        }
        //hm.entrySet() - returns the set view of all the entries
       // hm.keySet() - returns the set view of all the keys
       // hm.values() - returns the set view of all the values
    }
}
