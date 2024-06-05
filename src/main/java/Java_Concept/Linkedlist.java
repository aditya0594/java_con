package Java_Concept;

import java.util.LinkedList;
import java.util.List;

public class Linkedlist {

    public static void main(String[] args) {

       // LinkedList class can hold duplicate elements in list.
       // LinkedList is used to create an empty linked list.
        // LinkedList class maintains insertion order.
        //LinkedList class is non synchronized.
        //In LinkedList class, manipulation is fast because shifting is not required when new element is inserted or deleted from the list.


        List<String> ref = new LinkedList<>();
        ref.add("selenium");
        ref.add("grid");
        ref.add("appium");


        System.out.println(ref.get(1));
        System.out.println("===-------------------==--------------------");

        // To print all the values

        for(int i =0;i< ref.size();i++){
            System.out.println(ref.get(i));
        }
        System.out.println("===-------------------==--------------------");

        for(String str : ref){
            System.out.println(str);
        }

        System.out.println("===------------------Lamda--------------------");
        ref.forEach(value -> System.out.println(value));

        System.out.println("===------------------Remove the Object--------------------");
        ref.remove("appium");
    }


}
