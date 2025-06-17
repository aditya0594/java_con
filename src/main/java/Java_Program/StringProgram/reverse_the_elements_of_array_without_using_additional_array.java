package Java_Program.StringProgram;

import java.util.Arrays;

public class reverse_the_elements_of_array_without_using_additional_array {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        int start = 0;
        int end = arr.length - 1;

        // Swap elements from both ends moving toward the center
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        // Print reversed array
        System.out.println("Reversed array: " + Arrays.toString(arr));
    }
}
