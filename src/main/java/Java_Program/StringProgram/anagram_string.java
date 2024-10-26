package Java_Program.StringProgram;

import java.util.Arrays;

public class anagram_string {
    public static void main(String[] args) {
        String string1 = "race";
        String string2 = "care";
        boolean isAnagram = false;
        if (string1.length() != string2.length()) {
            isAnagram = false;
        }

        else{
            char[] char1 = string1.toCharArray();
            char[] char2 = string2.toCharArray();

            Arrays.sort(char1);
            Arrays.sort(char2);
            for (int i = 0; i < char1.length; i++) {
                if (char1[i] != char2[i]) {
                    isAnagram = false;
                    break;
                }
                isAnagram = true;
            }
        }
        if (isAnagram)
            System.out.println(string1 + " and "+string2+ " are Anagram");
        else
            System.out.println(string1 + " and "+string2+ " are Not Anagram");

    }


}
