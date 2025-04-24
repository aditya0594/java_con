package Java_Program.Calculation;

import java.util.Scanner;

public class practices {
    public static void main(String[] args) {
        //Find the prime number

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please Enter Number : ");
//      int num = sc.nextInt();

        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (Integer num : number) {
            boolean flag = false;

            int mid = num / 2;
            if (num == 0 || num == 1) {
                flag = false;
            } else {
                for (int i = 2; i <= mid; i++) {
                    if (num % 2 == 0) {
                        System.out.println(num + " : this is not prime number");
                        flag = true;
                        break;
                    }
                }
            }
            if (flag == false) {
                System.out.println(num + ": This is the prime number");
            }
        }
    }

}
