package Java_Program.ArrayProgram;

public class search_element_in_Array_return_its_index {
    public static void main(String[] args) {
        //.Search an Element Write a program to search for an element in an array and return its, index.
        // If the element is not found, display a message.
        int[] input = {0,3, 9, 50, 15, 99, 7, 98, 65};
        int targetElement = 100;
        int index = -1;
        for(int i = 0; i<input.length;i++){
            if(input[i]==targetElement){
                index=i;
            }
        }
        if(index!=-1){
            System.out.println("target element :" + targetElement + "and index is : " + index);
        }
        else {
            System.out.println("Not element found ");
        }
    }
}
