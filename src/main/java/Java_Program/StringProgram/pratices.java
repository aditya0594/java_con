package Java_Program.StringProgram;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class pratices {

    public static void main(String[] args) {
//            String str = "This is the sentences to be is is  reverse ";
//            String[] word = str.split(" ");
//            String revsentence ="";
//            for(String w : word){
//                String revwords="";
//                for(int i=w.length()-1;i>=0;i--){
//                    revwords = revwords+w.charAt(i);
//                }
//                revsentence = revsentence + revwords + " ";
//            }
//        System.out.println(revsentence);
//            String targetword = "is";
//            int count = 0;
//            for(String c : word){
//                if(targetword.equals(c)){
//                    count++;
//                }
//            }
//        System.out.println("The count of "+ targetword + " : "+count);
//        String str = "this is aditya aditya";
//        String[] word = str.split(" ");
//        HashMap<String,Integer> hash = new HashMap<>();
//        for(String w : word){
//            if(hash.containsKey(w)){
//                hash.put(w,hash.get(w)+1);
//            }
//            else {
//                hash.put(w,1);
//            }
//            for(Map.Entry<String,Integer> m : hash.entrySet()){
//                System.out.println(m.getKey() +" : " + m.getValue());
//            }
//        }


        String str = "Aditya this is is ";
        String[] word = str.split(" ");
        boolean flag = true;
        HashSet<String> hashset = new HashSet<>();
        for(String w : word){
            if(hashset.add(w)==false){
                flag = true;
                System.out.println("This is the duplicate value :" + w);
            }
        }

    }


}

