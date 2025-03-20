package Java_Program.ArrayProgram;

public class Reverse_array_without_using_addition_array {
    public static void main(String[] args) {
        int[] input = {0,3, 9, 50, 15, 99, 7, 98, 65};
        // Reverse the array using two-pointer approach
        int left =0, right = input.length-1;
        while(left<right){
            //swap element
            int temp = input[left];
            input[left] = input[right];
            input[right] = temp;

            //move pointer
            left ++;
            right--;

        }
        System.out.println("Reverse array ");
        for(Integer arr : input){
            System.out.print(arr + " ");
        }

        }
    }
