package Java_Concept;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Map_Hashmap {

    public static void main(String[] args) {

        //The Map is an interface, and HashMap is a class of the Java collection framework.
        //The HashMap class implements the Map interface.
        //The Map interface can be implemented by using its implementing classes.
        //The Map contains unique key-pair values.the HashMap can hold duplicate values.
        //The Map does not allow null values. But the HashMap can have one null key and multiple null values.
        //The Map has two implementations, which are HashMap and TreeMap. Whereas HashMap implements Map interface and extends AbstractMap class.
        //There is no difference between the Map and HashMap objects.



        HashMap<Integer, String> value = new HashMap<>();
        value.put(1,"aditya");
        value.put(2,"12");
        value.put(3,"tester");

        value.remove(1);
        // To get the value of the Key
        for(HashMap.Entry<Integer,String> en : value.entrySet() ){

            System.out.println("All the keys : " + en.getKey());
            System.out.println("All the values : "+ en.getValue());
        }
        System.out.println("---------------------------------");



        //System.out.println("---------------------------------");
       // value.remove(1,"QA Consultant");

        //System.out.println("---------------------------------");
       // value.replace(2,"12","QA");

        //System.out.println("---------------------------------");

        //To get the all keys and value we have to user the EntrySet


        // Q extracting the hashMap and pass date in set collection key and value using the Iterator
/*

        for(HashMap.Entry<Integer,String> en : value.entrySet() ){

            System.out.println("All the keys : " + en.getKey());
            System.out.println("All the values : "+ en.getValue());
        }
        System.out.println("---------------------------------");

        Set sn = value.entrySet();
        Iterator i = sn.iterator();
        while (i.hasNext()){
*/

          //  System.out.println(i.next());
         //   Map.Entry mp = (Map.Entry) i.next();    // this for the separated the key and value
           // System.out.println("All the keys : " + mp.getKey());
           // System.out.println("All the values : "+ mp.getValue());

       /* System.out.println("---------------------------------");

        for(HashMap.Entry<Integer,String> nm : value.entrySet()){
            System.out.println(nm.getKey());
            System.out.println(nm.getValue());
        }
*/
        HashMap<Integer, String> map1 = new HashMap<>();
        value.put(1,"This is first value");
        value.put(2,"This is second value");
        value.put(3,"This is third value");

        for(Map.Entry<Integer,String> en : map1.entrySet()){
            System.out.println(en.getValue() + " " + en.getKey());

        }
    }
}
