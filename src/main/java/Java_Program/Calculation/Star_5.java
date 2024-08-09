package Java_Program.Calculation;

public class Star_5 {
    public static void main(String[] args) {
        /**
         *
         * *
         * * *
         * * * *
         **/
        int row = 5;
        for (int i = 0; i <= row; i++) {
            // inner loop for space
            for (int j = row - i - 1; j >= 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

}