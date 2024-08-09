package Java_Program;

public class Maximum_Value_of_element_in_Array {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,9};
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println(max);
    }
}

