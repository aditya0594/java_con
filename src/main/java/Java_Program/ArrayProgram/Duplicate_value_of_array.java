package Java_Program.ArrayProgram;

import java.util.HashSet;

public class Duplicate_value_of_array {
    public static void main(String[] args) {
        int[] value = {1, 2, 3, 4, 5, 2};
        boolean flag = false;
        HashSet<Integer> integers = new HashSet<>();
        for (Integer integerseparate : integers) {
            if (integers.add(integerseparate)==false) {
                flag = true;
                System.out.println("Duplicate found");
            }
        }
    }
}


