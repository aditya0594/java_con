package Java_Program;

public class Reverse_the_sentence {
        //string is given
    // 1. Create method with the String
    // 2. We have convert string in the string array "words"
    // 3. then String result variable which is give the result
    // 4. then for loop for we have to start form the end
    //    so the i = words.length-1 becasue we have to travel from the last i>=0 then i--
    // 5. If (i==0) we eqaul to 0 then result = result+words[i];
    // 6. else having the space then resul = result+words[i]=" " ;
    // then use this method to reverse the sentence.
// I am programmer

    public static String revers_sentance(String str){
        String[] words = str.split(" ");
       // System.out.print(words);

        String result = "";
        for(int i=words.length-1; i>=0;i--){
            if(i==0) {
                result = result + words[i];
            }
            else{
                result=result+words[i]+" ";
            }
        }
        return result;
    }
    public static void main(String[] args){
        String str = "I am Programmer";
        System.out.println(revers_sentance(str));
    }


}
