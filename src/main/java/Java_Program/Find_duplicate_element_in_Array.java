package Java_Program;

import java.util.HashSet;

public class Find_duplicate_element_in_Array {
 /*   public static void main(String[] args) {
        String str = "Aditya this is a Aditya";
        String arr[] = str.split(" ");
        HashSet<String> langs = new HashSet<>();
        boolean flag = false;
        for (String l : arr) {

            if (langs.add(l) == false) {
                flag = true;
                System.out.println("found duplicate element : " + l);

            }
        }
        if (flag == false) {
            System.out.println("No duplicate element found");
        }
    }
*/

    public static void main(String[] args) {
        String str = "This is java program";
        String arr[] = str.split(" ");
        HashSet<String> lang = new HashSet<>();
        boolean flag = false;
        for(String s : arr){
            if(lang.add(s)==false){
                flag = true;
                System.out.println("Found the duplicate value : "+ s);
            }
        }
        if(flag ==false)




    }
}


