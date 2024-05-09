package Java_Concept;

public class array {


    //Collection of similar type of elements is known as Array.
    //Array in Java is an Object that holds fixed number of values of a similar data types
    // which means an array of int will contain only integers, an array of string will contain only strings etc..
    // The length of an array is define when the array is created.
    //Array is a index based and its index starts from 0 which means the first element of an array is stored at 0 index.
    public static void main(String[] args) {
        String[] arr = new String[5];
        arr[0]="aditya";
        arr[1]="aditya1";


        System.out.println(arr[0]);
        for(int i=0; i<=5;i++){
            System.out.println(arr[i]);
        }
    }





}
