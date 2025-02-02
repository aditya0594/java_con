package Java_Program;

import java.util.Arrays;

public class Find_prime_no {
    public void checkPrime(int input) {

        int mid = input / 2;
        boolean flag = false;
        if (input == 0 || input == 1) {
            System.out.println("it is not a prime number");
        } else {
            for (int i = 2; i <= mid; i++) {
                if (input % i == 0) {
                    flag = true;
                    System.out.println("this is not prime  number");
                    break;
                }
            }
        }
        if (flag == false) {
            System.out.println("It is a prime number");
        }
    }

    public void checkInArray(int[] arr) {
        for (Integer num : arr) {
            checkPrime(num);
            System.out.print(num);
        }
    }

//    public static void main(String[] args) {
//        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
//        Find_prime_no obj = new Find_prime_no();
//        obj.checkInArray(numbers);
//    }


    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int num : numbers) {
            boolean flag1=false;
            int mid = num/2;
            if(num ==1 || num ==0){
                System.out.println(num+ " This is not prime number");
            }
            else {
                for(int i=2; i<=mid; i++){
                    if(num%2 == 0)
                    System.out.println(num+ " This is not prime number");
                    flag1 = true;
                    break;
                }
            }
            if(flag1==false){
                System.out.println(num+ " This is prime number");
            }
        }
    }
}