package Java_Program.ArrayProgram;

public class Array_palindrome {
    public static void main(String[] args) {

        int[] arr = {1, 2, 4,5, 2, 1};  // Input array

        boolean isPalindrome = true; // Assume it's a palindrome

        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) { // Compare first with last, second with second-last
                isPalindrome = false;
                break; // Stop if any mismatch is found
            }
        }

        System.out.println("Is palindrome: " + isPalindrome);
    }

}
