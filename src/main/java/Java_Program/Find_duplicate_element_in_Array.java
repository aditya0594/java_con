package Java_Program;

import java.util.HashSet;

public class Find_duplicate_element_in_Array {
    public static void main(String[] args) {
        String arr[] = {"java","C", "java"};
        HashSet<String> langs = new HashSet<>();
        boolean flag =false;
        for(String l: arr){

            if(langs.add(l)==false){
                flag =true;
                System.out.println("found duplicate element : " + l);

            }
        }
            if(flag ==false){
                System.out.println("No duplicate element found");
            }


        }

    }
