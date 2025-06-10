package Java_Concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Convert_arrayList_in_array {
    public static void main(String[] args){
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Aditya");
        arr.add("test");
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

        int[] arr1 = new int[2];
        arr1[0] = 2;
        arr1[1] =4;

        ArrayList<Integer> arraylist1 = new ArrayList<>();
        for (int num : arr1) {
            arraylist1.add(num); // add each element
        }
        System.out.println(arraylist1);



    }
}
