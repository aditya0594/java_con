package Collection;

import java.util.HashSet;

public class Practice {

    public static  String reverSentance(String str ) {
      //  String str = "Aditya Pawar";
        String[] words = str.split(" ");
        String result ="";
        for(int i=words.length-1;i>=0; i--){
            if(i==0){
                result =result+words[i];
            }
            else{
                result= result+words[i]+" ";
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String str = "Aditya Pawar";
        System.out.println(reverSentance(str));
    }
}