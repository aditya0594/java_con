package Java_Program.StringProgram;

import java.util.HashMap;
import java.util.Map;

public class Count_of_word_from_sentences_1 {
    public static void main(String[] args) {
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
    }
}
