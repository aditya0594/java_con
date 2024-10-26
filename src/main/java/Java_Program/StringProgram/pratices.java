package Java_Program.StringProgram;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class pratices {

    public static void main(String[] args) {

        String str = "this is aditya aditya";
        String[] word = str.split(" ");
        HashMap<String,Integer> hash = new HashMap<>();
        for(String w : word){
            if(hash.containsKey(w)){
                hash.put(w,hash.get(w)+1);
            }
            else {
                hash.put(w,1);
            }
            for(Map.Entry<String,Integer> m : hash.entrySet()){
                System.out.println(m.getKey() +" : " + m.getValue());
            }
        }
    }
}

