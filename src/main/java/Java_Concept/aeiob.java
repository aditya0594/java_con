package Java_Concept;

import java.util.HashMap;
import java.util.Locale;

public class aeiob {
    public static void main(String[] args) {
       // ["a","e","i","o","u"]

        String str =  "Users complete payment through Apple Pay, with funds being deposited into the company’s accoun";
        String[] ltr = str.toLowerCase().split("");

       // HashMap<Integer, String> hashmap = new HashMap<>();
        //int count = 0;
        int a =0;
        int e =0; int i =0; int o =0; int u=0;
        for(String word : ltr){
           if(word.equals("a")){
               a++;
            }
            if(word.equals("e")){
                e++;
            }
            if(word.equals("i")){
                i++;
            }
            if(word.equals("o")){
                o++;
            }
            if(word.equals("u")){
                u++;
            }
        }
        System.out.println("a :  "+ a);
        System.out.println("e :  "+ e);
        System.out.println("i :  "+ i);
        System.out.println("o :  "+ o);
        System.out.println("u :  "+ u);

    }
}
