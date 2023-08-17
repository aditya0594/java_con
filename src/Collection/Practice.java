package Collection;

import java.util.HashSet;

public class Practice {

    public static void main(String[] args) {

        //duplicate value of array

        String arr[] = {"java","aditya","java"};

        HashSet<String> lang = new HashSet<>();
        for(String a : arr){
           if(lang.add(a)==false){
               System.out.println("arry consist of duplicate value : "+a);
           }
        }

    }
}
