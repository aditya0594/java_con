package Java_Program.StringProgram;

import java.util.*;
import java.util.stream.Collectors;

public class pratices {

    public static void main(String[] args) {
        String str = "Aditya is a good boy";

        String reverse = "";
        for(int i=str.length()-1;i>=0;i--){
            reverse = reverse + str.charAt(i);
        }
        System.out.println(reverse);
    }

    }