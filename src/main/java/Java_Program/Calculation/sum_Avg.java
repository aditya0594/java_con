package Java_Program.Calculation;

public class sum_Avg {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int sum= 0;
        for(int i=0; i<arr.length;i++){
            sum += arr[i];
        }
        int avg = sum/arr.length;
        System.out.println(sum);
        System.out.println("Avg is "+ avg);
    }
}