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
//        boolean status = true;
//        if(arr1.length == arr2.length){
//            for (int i=0; i< arr1.length; i++){
//                if(arr1[i]!=arr2[i]){
//                    status=false;
//                }
//            }
//        }
//        else {
//            status = false;
//        }
//        if(status==true){
//            System.out.println("Compared");
//        }
//        else {
//            System.out.println("not compare");
//        }
//
//    }
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5};
        boolean status =true;

        if(arr1.length==arr2.length){
            for(int i=0; i<arr1.length; i++){
                if(arr1[i]!=arr2[i]){
                    status = false;
                }
            }
        }
        else{
            status = false;
        }
        if(status == true){
            
        }
    }
}
