package Java_Program;


import org.apache.commons.collections4.map.HashedMap;

import java.util.HashMap;

public class Hashmap {
    public static void main(String[] args) {

        HashedMap<Integer,String> hm = new HashedMap<Integer, String>();

       hm.put(1, "Selenium");
       hm.put(2,"QTP");
       hm.put(3, "Testcomplete");
       hm.put(3,"Appium");

        System.out.println("---------------------------------");
        System.out.println("HashMap value with the key : " + hm.get(1));

        System.out.println("---------------------------------");

        //hm.remove(3,"appium");

        // To print all the value of HASHMAP 

        System.out.println("HashMap value with the key :" + hm.get(3));

        System.out.println("---------------------------------");
        // iterating through key/value mappings
        System.out.println("Entries through the for each : ");
        for(Object entry: hm.entrySet()) {
        }
        System.out.println("---------------------------------");
        // iterating through keys
        System.out.print("Only the Keys showing using the for each loop : ");
        for(Object key: hm.keySet()) {
            System.out.print(" "+ key);

        }
        System.out.println("---------------------------------");
        // iterating through values
        System.out.print("Only the Keys showing using the for each loop values: ");
        for(Object values: hm.values()) {
            System.out.print(" "+ values);
            System.out.print(", ");
        }
        //hm.entrySet() - returns the set view of all the entries
       // hm.keySet() - returns the set view of all the keys
       // hm.values() - returns the set view of all the values
    }
}
