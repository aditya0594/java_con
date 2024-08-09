package Java_Program.StringProgram;

import com.google.protobuf.MapEntry;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Count_of_word_from_sentences {
   /* public static void main(String[] args) {
        String str = "This the java language and java is good language";
        String[] words = str.split(" ");

        String targetword = "java";
        int targetWordCount = 0;

        for (String word: words){
            if(word.equals(targetword)){
                targetWordCount++;
            }
        }
        System.out.println("Count : " + targetWordCount );
    }
*/


   public static void main(String[] args) {

      String str = "This the java language and java is good language";
      char[] words = str.toCharArray();
      String sentence = "";
      for(int i = 0;i<words.length;i++){
         if(words[i]!=' '){
            sentence = sentence +words[i];
         }
      }
      System.out.println(sentence);


















   }
}