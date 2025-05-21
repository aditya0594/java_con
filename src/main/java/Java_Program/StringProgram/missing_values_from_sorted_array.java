package Java_Program.StringProgram;

public class missing_values_from_sorted_array {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7};
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i+1] - arr[i];
            for (int j = 1; j < diff; j++) {
                System.out.println("Missing: " + (arr[i] + j));
            }
        }
    }
}
