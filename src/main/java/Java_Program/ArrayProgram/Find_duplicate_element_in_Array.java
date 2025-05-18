package Java_Program.ArrayProgram;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
        String str = "This is java java javajava java program";
        String arr[] = str.split(" ");
        HashSet<String> lang = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        boolean flag = false;
        for(String s : arr){
            if(hashMap.containsKey(s)){
                hashMap.put(s,hashMap.get(s)+1);
            }
            else{
                hashMap.put(s,1);
            }
            if(lang.add(s)==false){
                flag = true;
                System.out.println("Found the duplicate value : "+ s);
            }
        }

      for(Map.Entry<String,Integer> values : hashMap.entrySet()){
          System.out.println("This is the count of words : " + values.getKey() +" : "+ values.getValue());
      }
        if(flag ==false){
            System.out.println("No duplicate found");
        }
    }
}


