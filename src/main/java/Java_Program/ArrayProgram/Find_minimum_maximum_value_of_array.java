package Java_Program.ArrayProgram;

import java.util.Arrays;

public class Find_minimum_maximum_value_of_array {
    public static void main(String[] args) {
        int[] input = {3, 9, 50, 15, 99, 7, 98, 65};

        // Initialize min and max with the first element
        int min = input[0];
        int max = input[0];
        for(int i = 0; i<input.length;i++){
            if(input[i]<min){
                min = input[i];
            }
            if(input[i]>max){
                max=input[i];
            }
        }
        System.out.println("Minimum value : "+ min);
        System.out.println("Maximum value : "+ max);



        // without using the loop
        Arrays.sort(input);
        int maximum_value = input[input.length-1];
        int minimum_value = input[0];
        System.out.println("The maximum value is : " + maximum_value);
        System.out.println("The minimum value is : " + minimum_value);


    }


}