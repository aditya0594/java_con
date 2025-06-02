package Java_Program.ArrayProgram;

import java.util.Arrays;

public class Merge_two_array_in_one {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 4, 6, 8};
        int[] mergeArray = new int[array1.length + array2.length];

        // Copy elements of array1
        for(int i = 0; i<array1.length;i++){
            mergeArray[i] = array1[i];
        }
        // copy elements of array2
        for(int i=0;i<array2.length;i++){
            mergeArray[array1.length+i]= array2[i];
        }
        Arrays.sort(mergeArray);
        System.out.println("This is the mergeArray : ");
        for(Integer finalArray : mergeArray){
            System.out.println( finalArray);
        }



    }
}
