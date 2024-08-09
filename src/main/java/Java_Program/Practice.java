package Java_Program;

import org.openqa.selenium.interactions.Interaction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5};
        boolean flag = false;
        HashSet<Integer> hashvalue = new HashSet<>();
        for(Integer value : arr){
            if(hashvalue.add(value)==false){
                System.out.println("This is duplicate value found "+ value);
                flag = true;
            }
        }
        if(flag==false){
            System.out.println("No duplicate value found");
        }
    }

}
