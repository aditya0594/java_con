package Java_Concept;

import com.aventstack.extentreports.gherkin.model.ScenarioOutline;

import java.util.*;

public class Map_Hashmap {

    public static void main(String[] args) {

        //The Map is an interface, and HashMap is a class of the Java collection framework.
        //The HashMap class implements the Map interface.
        //The HashMap contains unique key-pair values.the HashMap can hold duplicate values.
        //The Map does not allow null values. But the HashMap can have one null key and multiple null values.
        //The Map has two implementations, which are HashMap, HashTable and TreeMap. Whereas HashMap implements Map interface and extends AbstractMap class.
        // It does not guarantee the order of iteration, meaning the order of keys and values is not predictable.
        //  HashMap is non-synchronized ---that means that the 5 five program access the hashmap concurrently simultaneously it will keep updating

        HashMap<Integer, String> value = new HashMap<>();
        value.put(1,"aditya");
        value.put(2,"12");
        value.put(null,null);
        value.put(null,"13");


        // To get the value of the Key
        System.out.println("-----------for each loop ----------------------");
        for(Map.Entry<Integer, String> original : value.entrySet()){
            System.out.println("Keys is : "+ original.getKey());
            System.out.println("Value is : "+ original.getValue());

        }

        System.out.println("---------------Replace-----------");
       // value.remove(1,"QA Consultant");
        value.replace(2,"12","QA");
        for(Map.Entry<Integer, String> original : value.entrySet()){
            System.out.println("Keys is : "+ original.getKey() +"Value is : "+ original.getValue());

        }
        System.out.println("---------------Remove-----------");
        value.remove(1);
        for(Map.Entry<Integer, String> original : value.entrySet()){
            System.out.println("Keys is : "+ original.getKey() +"Value is : "+ original.getValue());

        }
        System.out.println("-------------Using iterator--------------------");
        // Q extracting the hashMap and pass date in set collection key and value using the Iterator
        Set sn = value.entrySet();
        Iterator i = sn.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
            Map.Entry mp = (Map.Entry) i.next();    // this for the separated the key and value
            System.out.println("All the keys : " + mp.getKey());
            System.out.println("All the values : " + mp.getValue());
        }



        // hash table doesn't contain the null value
        // This is faster then the hashmap
        // HashTable is snychronized because if one program accessing it then other program have to wait to conplete first program 
        Map<Integer,String> ht = new Hashtable<>();
        ht.put(1,"first");
        ht.put(2,"second");
        ht.put(3,"Third");
        ht.put(4,"Fourth") ;

        for(Map.Entry<Integer,String> m : ht.entrySet()){
            System.out.println("Keys : " + m.getKey() + "Values : " +m.getValue());
        }
        // Using an Iterator
        System.out.println("Using Iterator:");
        Iterator<String> iterator = ht.values().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Using a for-each loop
        System.out.println("Using for-each loop values:");
        for (String htvalue : ht.values()) {
            System.out.println(htvalue);
        }
        // Using a for-each loop
        System.out.println("Using for-each loop Keys: ");
        for (Integer htvalue1 : ht.keySet()) {
            System.out.println(htvalue1);
        }

        System.out.println("Using Set map entry");
        Set sk = ht.entrySet();
        Iterator k = sk.iterator();
        while (k.hasNext()){
            System.out.println(k.next());
            Map.Entry m1 = (Map.Entry) k.next();
            System.out.println(m1.getKey() + " " + m1.getValue());
        }
    }
}
