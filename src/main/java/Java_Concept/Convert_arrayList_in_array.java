package Java_Concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Convert_arrayList_in_array {
    public static void main(String[] args){
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Aditya");
        arr.add("Amla");
        System.out.println("Value off Arr is : " + arr.toString());

        //Convert to array
        Object[] array = arr.toArray();
        System.out.println(array);

        String[] arrstr = {"one","two","three"};
        ArrayList<String> arrayList=new ArrayList<>();
        Collections.addAll(arrayList,arrstr);
        for(String a : arrayList){
            System.out.println(a);
        }


     }
}
