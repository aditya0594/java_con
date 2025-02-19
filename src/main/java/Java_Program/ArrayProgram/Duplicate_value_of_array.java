package Java_Program.ArrayProgram;

import java.util.HashSet;

public class Duplicate_value_of_array {
    public static void main(String[] args) {
/*        int[] value = {1,2,3,4,5,6,2};
        boolean flag = false;
        HashSet<Integer> integers = new HashSet<>();
        for (Integer integerseparate : value) {
            if (integers.add(integerseparate) == false) {
                flag = true;
                System.out.println("Duplicate found");
            }
        }
            if(flag == false){
                System.out.println("No Duplicate found");
            }*/


        int[] arr = {1,2,3,4,4};
//        boolean flag = false;
//        HashSet<Integer> hash = new HashSet<>();
//        for(Integer w : arr){
//            if(hash.add(w)==false){
//                flag = true;
//                System.out.println("This duplicate value " +w);
//            }
//            if(flag=false){
//                System.out.println("Duplicate value not found");
//            }

        HashSet<Integer> hash = new HashSet<>();
        boolean flag = false;
        for(Integer w : arr){
            if(hash.add(w)==false){
                flag=true;
                System.out.println("This is the duplicate value : "+ w);
            }
            if(flag==false){
                System.out.println("Duplicate value not found");
            }


        }

















        }
    }

