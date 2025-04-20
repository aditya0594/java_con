package Java_Concept;

import java.util.HashMap;
import java.util.Map;

public class aeiou {
    public static void main(String[] args) {
        // ["a","e","i","o","u"]

        String str = "Users complete payment through Apple Pay, with funds being deposited into the company’s accoun";
        char[] ltr = str.toLowerCase().toCharArray();

        HashMap<String, Integer> hashmap = new HashMap<>();

        for (char w : ltr) {
            if (hashmap.containsKey(w)) {
                hashmap.put(String.valueOf(w), hashmap.get(w) + 1);
            } else {
                hashmap.put(String.valueOf(w), 1);
            }
        }
        for(Map.Entry<String,Integer> m : hashmap.entrySet()){
            System.out.println("This is the key " + m.getKey() + " : " +m.getValue()) ;

        }



    }
}
