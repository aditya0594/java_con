package Java_Program.StringProgram;

import java.util.Arrays;

public class Split_String {
    public static void main(String[] args) {
        String s1 = "Java,Selenium,QA"; // i have to split this string
        String[] str = s1.split(",");  // Split method will return the Array of string // Split is a array type of variable
        for(int i =0; i<str.length;i++){
            System.out.println(str[i]);
        }
        Arrays.stream(str).forEach(value-> System.out.println(value));

        for(String s : str){
            System.out.println(s);
        }

    }
}
