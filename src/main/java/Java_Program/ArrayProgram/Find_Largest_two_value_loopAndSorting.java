package Java_Program.ArrayProgram;

import java.util.Arrays;

public class Find_Largest_two_value_loopAndSorting {

        // Find the largest two value of the array
    public static void main(String[] args) {

                int[] input = {3, 9, 50, 15, 99, 7, 98, 65};
                // Sort the array in ascending order
                Arrays.sort(input);
                // Get the two largest numbers
                int largest = input[input.length - 1];
                int secondLargest = input[input.length - 2];
                // Print the output
                System.out.println("Output: [" + secondLargest + ", " + largest + "]");


        int[] numbers = {3, 9, 50, 15, 99, 7, 98, 65};

        int largest1 = numbers[0];   // Assume first number is the largest   //first take the empty array
        int secondLargest1 = numbers[0]; // Assume first number is second largest too

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > largest1) {
                secondLargest1 = largest1;  // Move the largest to second largest
                largest1 = numbers[i];  // Update largest number
            } else if (numbers[i] > secondLargest1) {
                secondLargest1 = numbers[i];  // Update second largest if it's greater
            }
        }
        System.out.println("Largest: " + largest1);
        System.out.println("Second Largest: " + secondLargest1);


    }
}
