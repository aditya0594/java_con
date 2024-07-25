package Java_Program.StringProgram;

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
        String[] word = str.split(" ");
        HashMap<String,Integer> hasword = new HashMap<>();
        for(String words : word){
            if(hasword.containsKey(words)){
                hasword.put(words,hasword.get(words)+1);
            }
            else {
                hasword.put(words,1);
            }
        }
        for(Map.Entry<String,Integer> m : hasword.entrySet()){
            System.out.println(m.getKey()+ " " + m.getValue());
        }
        String specificWord = "string";
        if (hasword.containsKey(specificWord)) {
            System.out.println("Count of '" + specificWord + "': " + hasword.get(specificWord));
        } else {
            System.out.println("The word '" + specificWord + "' is not found in the string.");
        }
    }
















}
