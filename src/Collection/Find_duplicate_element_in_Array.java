package Collection;

import java.util.HashSet;

public class Find_duplicate_element_in_Array {
    public static void main(String[] args) {
        String arr[] = {"java","C", "java"};
        HashSet<String> langs = new HashSet<>();
        boolean flag =false;
        for(String l: arr){

            if(langs.add(l)==false){
                System.out.println("found duplicate element : " + l);
                flag =true;
            }
        }
            if(flag ==false){
                System.out.println("No duplicate element found");
            }


        }

    }
