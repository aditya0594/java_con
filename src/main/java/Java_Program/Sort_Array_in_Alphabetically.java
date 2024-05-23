package Java_Program;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sort_Array_in_Alphabetically {

    public static void main(String[] args) {
        String[] Strings = {"Zoo","Geeta","Pooja","Shanaya","Aditya"};
        // Print the original array
        System.out.println("Original array :");
        for(String str : Strings){
            System.out.println(str);
        }
        Arrays.sort(Strings);
        // rrint the sorted array
        System.out.println("\nSorted array :");
        for(String str1 : Strings){
            System.out.println(str1);
        }
    }

}
