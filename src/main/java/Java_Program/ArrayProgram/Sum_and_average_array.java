package Java_Program.ArrayProgram;

public class Sum_and_average_array {

   // Sum of Elements Write a program to take an array of integers as input and calculate the sum of all elements in the array.

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        int sum=0;
        for(Integer num : numbers){
            sum= sum + num;
        }
        System.out.println(sum);
        int length = numbers.length;
        double average = sum/length;
        System.out.println("Average " + average);

    }

}
