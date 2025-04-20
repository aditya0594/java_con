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

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        boolean status = true;

        if (arr1.length != arr2.length) {
            status = false;
        } else {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    status = false;
                    break;
                }
            }
        }

        if (status) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }



        int[] a1 = {1,2,3,4,5};
        int[] a2 = {1,2,8,4,5};
        boolean flag =true;
        if(a1.length!=a2.length){
            flag = false;
        }else{
            for(int i=0; i<a1.length;i++){
                if(a1[i]!=a2[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("Array is compared");
            }else{
                System.out.println("Array is not same");
            }

        }
    }
}
