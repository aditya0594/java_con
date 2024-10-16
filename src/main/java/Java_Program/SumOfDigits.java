package Java_Program;

import java.util.Scanner;

public class SumOfDigits {

        public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number : " );
          int s= sc.nextInt();
          int sum = 0;
          while(s!=0){
            sum = sum + s%10;
            s = s/10;
            }
            System.out.println(sum);
        }
    }

