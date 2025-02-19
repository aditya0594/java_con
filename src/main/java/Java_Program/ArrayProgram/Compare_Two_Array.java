package Java_Program.ArrayProgram;

import java.util.Arrays;

public class Compare_Two_Array {
    public static void main(String[] args) {
//        int[] arr1 = {1,2,3,4,5};
//        int[] arr2 = {1,2,3,6,5};
//        //boolean status = Arrays.equals(arr1,arr2);
//        /*if(status == true){
//            System.out.println("This is the equal array");
//        }
//       else {
//            System.out.println("Not eqaul array");
//        }*/

        int[] arr1 = {1,2,8,4,5};
        int[] arr2 = {1,2,3,4,5};
        boolean status = true;

        if(arr1.length != arr2.length){
            status=false;
        }
        else{
            for(int i =0;i<arr1.length;i++){
                status=false;
                break;
            }
        }
        if(status==true){
            System.out.println("Array is equal");
        }
        else{
            System.out.println("Array is not equal");
        }

/*
        Boolean flag = false;
        int[] arr3 = {1,2,3,4,5};
        int[] arr4 = {1,2,4,5,5};
        if(arr3.length==arr4.length){
            for(int i=0;i<arr4.length;i++){
                flag = true;
                break;
            }
        }

*/

    }


}
