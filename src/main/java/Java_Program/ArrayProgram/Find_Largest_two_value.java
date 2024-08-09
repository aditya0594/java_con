package Java_Program.ArrayProgram;

import java.util.Arrays;

public class Find_Largest_two_value {
    public static void main(String[] args) {

                int[] input = {3, 9, 50, 15, 99, 7, 98, 65};
                // Sort the array in ascending order
                Arrays.sort(input);
                // Get the two largest numbers
                int largest = input[input.length - 1];
                int secondLargest = input[input.length - 2];
                // Print the output
                System.out.println("Output: [" + secondLargest + ", " + largest + "]");
    }
}
