package Java_Program.ArrayProgram;

import groovy.json.JsonToken;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class practice {

    public static void main(String[] args) {
        String str = "Aditya pawar Aditya";
        char[] chars = str.toCharArray();
        String sentence ="";
        for(int i = 0;i<= chars.length; i++){
            if(chars[i]!= ' '){
               sentence = sentence+ chars[i];
            }
        }
        System.out.println("Removed space : " + sentence);


        }
    }
