package Java_Program;

import java.util.Scanner;

public class palindrome_or_not {
   /* public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String : " );
        String original = scanner.nextLine();
        String reverse = new StringBuilder(original).reverse().toString();
        if(original.equals(reverse)){
            System.out.println("this String is palindrome");
        }
        else{
            System.out.println("This string is not a palindrom");
        }
    scanner.close();

    }*/
   public static void main(String[] args) {
        int num = 1234421;
        String reversedStr="";
        String numstr = Integer.toString(num);
        for(int i=numstr.length()-1; i>=0;i--){
            reversedStr += numstr.charAt(i);
        }
       System.out.println("Reverse number" +reversedStr);
       if(numstr.equals(reversedStr)){
           System.out.println("This is palindrom");
       }
       else {
           System.out.println("Not a palindrom");
       }
       }

   }
