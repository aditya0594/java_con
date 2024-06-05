package Java_Program;

import java.util.Scanner;

public class palindrome_or_not {
    public static void main(String[] args){
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

    }
}
