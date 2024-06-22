package Java_Program.StringProgram;

public class Reverse_each_word_present_in_the_sentence {
    public static void main(String[] args) {
        String str = "Aditya Pawar this is Aditya";
        String[] words =str.split(" ");
        String reverseString ="";
        for(String w : words){
            String reversewords="";
            for(int i=w.length()-1; i>=0;i--){
                reversewords = reversewords + w.charAt(i);
            }
            reverseString = reverseString+reversewords+" ";
        }
        System.out.print(reverseString);
    }
}
