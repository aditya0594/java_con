package Java_Program.StringProgram;

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
      String str = "this is the string and  string is immutable";
      String[] words = str.split(" ");
      int count = 0;
      String tragetWord = "string";
      for(String word : words){
         if(word.equals(tragetWord)){
            count++;
         }
      }
      System.out.println(tragetWord + " "+ count);


   }
}