package Java_Program.ArrayProgram;

import io.cucumber.java.sl.In;

import java.util.*;
import java.util.stream.Collectors;

public class Find_Duplicate_element_Array_String {

   public static void main(String[] args) {
      //  String str = "Aditya pawar Aditya";
      //  String[] arr = str.split(" ");
        int arr[] = {1,2,5,3,4,5};
        boolean flag = false;
        HashSet<Integer> hashSet = new HashSet<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(Integer w : arr){
            if(hashMap.containsKey(w)){
                hashMap.put(w,hashMap.get(w)+1);
            }
            else {
                hashMap.put(w,1);
            }
            if(hashSet.add(w)==false){
                System.out.println("Duplicate value found :  " + w);
                break;
            }
        }
        if(flag){
            System.out.println("Duplicate value not found");
        }
        for(Map.Entry<Integer,Integer> val : hashMap.entrySet()){
            System.out.println(val.getKey() + " :: " + val.getValue());
        }


       System.out.println("--------------------using the stream function to remove the duplicate element --------------");
      //  List list = Arrays.stream(arr).distinct().collect(Collectors.toList());
      // System.out.println(list);

    }


/*
    public static void main(String[] args) {
        String str = "this java java";
        String[] word =str.split(" ");
        boolean flag= false;
        HashSet<String> hashSet = new HashSet<>();
        for(String w : word){
            if(hashSet.add(w)==false){
                flag = true;
                System.out.println("Found duplicate");
            }
        }
        if(flag == false){
            System.out.println("No duplicate found");
        }

    }
*/






}
