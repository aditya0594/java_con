package Java_Concept;

import org.openqa.selenium.Keys;

import java.util.HashMap;
import java.util.Map;

public class Hashmap {

    public static void main(String[] args) {

        //The Map is an interface, and HashMap is a class of the Java collection framework.
        //The Map interface can be implemented by using its implementing classes. In comparison, the HashMap class implements the Map interface.
        //The Map contains unique key-pair values. But, the HashMap can hold duplicate values.
        //The Map does not allow null values. But the HashMap can have one null key and multiple values.
        //The Map has two implementations, which are HashMap and TreeMap. Whereas HashMap implements Map interface and extends AbstractMap class.
        //There is no difference between the Map and HashMap objects.


        HashMap<String, String> value = new HashMap<>();
        value.put("Name","aditya");
        value.put("Age","12");
        value.put("Role","tester");

        // To get the value of the Key
        System.out.println(value.get("Name"));
        System.out.println("---------------------------------");

        value.put("Role","QA Consultant");


        System.out.println("---------------------------------");


        value.remove("Role","QA Consultant");


        System.out.println("---------------------------------");


        value.replace("Age","12","18");


        System.out.println("---------------------------------");

        //To get the all keys and value we have to user the EntrySet

        for(HashMap.Entry<String,String>en : value.entrySet() ){

            System.out.println("All the keys : " + en.getKey());
            System.out.println("All the values : "+ en.getValue());
        }



    }
}
