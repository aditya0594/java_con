package Java_Program.StringProgram;

import com.google.protobuf.MapEntry;

import java.util.HashMap;
import java.util.Map;

public class Count_of_word_from_sentences_1 {
   /* public static void main(String[] args) {
        String str = "This the java language and java is good language";
        String[] words = str.split(" ");

        HashMap<String, Integer> hashWord = new HashMap<>();
        for(String word : words){
            if(hashWord.containsKey(word)) {
                hashWord.put(word, hashWord.get(word) + 1);
            }
            else{
                hashWord.put(word,1);
            }
        }
        for(Map.Entry<String, Integer>sn : hashWord.entrySet()){
            System.out.println(sn.getKey() + " " + sn.getValue());
        }
    }*/


    public static void main(String[] args) {
        String str = "this is the string and string is immutable";
        String[] words = str.split(" ");
        //count the words
        String target = "string";
        int count = 0;
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(String word : words){
            if(hashMap.containsKey(word)){
                hashMap.put(word,hashMap.get(word)+1);
            }
            else{
                hashMap.put(word,1);
            }
            if(word.equals(target)){
                count++;
            }

        }
        System.out.println("This is count of "+ target+ " : "+count);
        for(Map.Entry<String,Integer> m : hashMap.entrySet()){
            System.out.println("this is the words : "+m.getKey()+" count is :" + m.getValue());
        }
    }
















}
