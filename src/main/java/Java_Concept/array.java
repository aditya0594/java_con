package Java_Concept;

import java.util.Arrays;

public class array {


    //Collection of similar type of elements is known as Array.
    // Array in Java is an Object that holds fixed number of values of a similar data types
    // which means an array of int will contain only integers, an array of string will contain only strings etc..
    // The length of an array is define when the array is created.
    // Array is a index based and its index starts from 0 which means the first element of an array is stored at 0 index.
    public static void main(String[] args) {
        String[] arr = new String[2];
        arr[0]="aditya";
        arr[1]="aditya1";

        String[] arr1 = new String[1];
        try{
        arr1[0] = "one";
        arr1[1] ="two";
        arr1[2] ="three";
        }catch (Exception e){
            System.out.println("This is the error: " + e);
        }

        System.out.println("---------String----------");
        for(String m : arr1){
            System.out.println(m);
        }
        System.out.println("-------------Reverse the array--------------");
        try {
            for (int i =arr.length-1;i>=0 ;i--) {
                System.out.println(arr[i]);
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("out of bound occured");
        }
        System.out.println("--------------lamba----------------");
        Arrays.stream(arr).forEach(value->System.out.println(value));

    }






}
