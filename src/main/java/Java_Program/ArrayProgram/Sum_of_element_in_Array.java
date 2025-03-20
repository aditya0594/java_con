package Java_Program.ArrayProgram;

public class Sum_of_element_in_Array {
    public static void main(String[] args) {

        int a[] = {2, 2, 2};
        int sum = 0;
        // enhanced forloop
        for (int value : a) {
            sum = sum + value;
        }
        System.out.println(sum);
    }

}
