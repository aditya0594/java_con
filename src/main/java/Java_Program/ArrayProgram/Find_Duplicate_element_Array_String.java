package Java_Program.ArrayProgram;

import java.util.HashSet;

public class Find_Duplicate_element_Array_String {

   public static void main(String[] args) {
        String str = "Aditya pawar Aditya";
        String[] arr = str.split(" ");
       // int arr[] = {1,2,5,3,4,5};
        boolean flag = false;
        HashSet<String> hasint = new HashSet<String>();
        for(String l: arr) {
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


/*
    public static void main(String[] args) {
        String str = "this java java";
        String[] word =str.split(" ");
        boolean flag= false;
        HashSet<String> hashSet = new HashSet<>();
        for(String w : word){
            if(hashSet.add(w)==false){
                flag = true;
                System.out.println("Found duplicate");
            }
        }
        if(flag == false){
            System.out.println("No duplicate found");
        }

    }
*/






}
