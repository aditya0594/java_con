package Java_Program.StringProgram;

import com.google.protobuf.MapEntry;

import java.util.HashMap;
import java.util.Map;

public class
 Count_of_word_from_sentences {
   public static void main(String[] args) {
        String str = "This the java language and java is good java java java language";
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


















   }