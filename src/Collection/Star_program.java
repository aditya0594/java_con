package Collection;

public class Star_program {
    public static void main(String[] args) {
       // left star
        for(int i=0; i<5; i++){
            for(int j=0; j<5-i-1;j++){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("-----------------------------");
        for(int a=0; a<=5; a++) {
            for(int b=0;b<=a;b++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
