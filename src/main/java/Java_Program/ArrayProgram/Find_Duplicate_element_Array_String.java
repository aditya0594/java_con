package Java_Program.ArrayProgram;

import java.util.HashSet;

public class Find_Duplicate_element_Array_String {

    public void main(String[] args) {
        int arr[] = {1,2,5,3,4,5};
        boolean flag = false;
        HashSet<Integer> hasint = new HashSet<Integer>();
        for(int l: arr) {
            if (hasint.add(l)==false)
            {
                System.out.print("Found duplicate integer :"+ l);
                flag= true;
            }
        }
        if(flag==false){

            System.out.println("Not content duplicate");
        }

    }
}