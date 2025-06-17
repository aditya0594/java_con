package Java_Program.StringProgram;

import java.util.*;
import java.util.stream.Collectors;

public class pratices {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        String rev = " ";
        for(int i = arr.length-1;i>=0;i--){
            rev = rev + arr[i];
        }
        System.out.println(rev);
    }

    }