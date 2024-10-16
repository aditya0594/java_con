package Java_Program.ArrayProgram;

import java.util.HashSet;

public class remove_duplicate_value_array {
    public void removeDuplicate(int[] arr){
        HashSet<Integer> hashval = new HashSet<>();
        for(Integer w : arr){
            hashval.add(w);
        }
        System.out.println(hashval);
    }

    public static void main(String[] args) {
        int[] arr = {2,2,3,3,4,6,7,9,44,55};
        remove_duplicate_value_array obj = new remove_duplicate_value_array();
        obj.removeDuplicate(arr);
    }
}
