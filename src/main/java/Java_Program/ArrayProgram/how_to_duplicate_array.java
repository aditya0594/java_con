package Java_Program.ArrayProgram;

public class how_to_duplicate_array {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Original is : " + arr1[i]);
        }
        int[] arr2 = new int[arr1.length];

      for(int i=0 ; i<arr1.length;i++){
          arr2[i]=arr1[i];
      }
      for(Integer n : arr2){
          System.out.println("This is the value of new array : "+ n);
      }
    }
}
