package Collection;

public class Reverse_the_sentence {
        //string is given
    String str = "aditya pawar";

    // 1. Create method with the String
    // 2. We have convert string in the string array "words"
    // 3. then String result variable which is give the result
    // 4. then for loop for we have to start form the end
    //    so the i = words.length-1 becasue we have to travel from the last i>=0 then i--
    // 5. If (i==0) we eqaul to 0 then result = result+words[i];
    // 6. else having the space then resul = result+words[i]=" " ;
    // then use this method to reverse the sentence.
    public static String reverseString(String str){
     String[] words = str.split(" ");
     String result ="";

     for(int i = words.length-1; i>=0; i--){
         if(i==0){
             result = result+words[i];
         }else {
             result = result+words[i]+" ";
         }
     }
     return result;
    }

    public static void main(String[] args) {
        String str = "1 2 3 4 5 6";
        System.out.println(reverseString(str));
    }

}
