package Java_Concept;

import java.util.HashMap;
import java.util.Map;

public class aeiou {
    public static void main(String[] args) {
        // ["a","e","i","o","u"]

        String str = "a a a a aadsad";

        int a = 0;
        int e =0;
        int i =0;
        int o=0;
        int u=0;

        for (int j = 0; j < str.length(); j++) {
            char ch = Character.toLowerCase(str.charAt(j));
           switch (ch){
               case 'a':
                   a++;
                   break;
               case 'e':
                   e++;
                   break;
               case 'i':
                   i++;
                   break;
               case 'o':
                   o++;
                   break;
               case 'u':
                   u++;
                   break;

           }
        }
        System.out.println(a);
    }
}
        
        

//        HashMap<String, Integer> hashmap = new HashMap<>();
//
//        for (String w : ltr) {
//            if (hashmap.containsKey(w)) {
//                hashmap.put(w, hashmap.get(w) + 1);
//            } else {
//                hashmap.put(w, 1);
//            }
//        }
//        for(Map.Entry<String,Integer> m : hashmap.entrySet()){
//            System.out.println("This is the key " + m.getKey() + " : " +m.getValue()) ;
//
//        }


