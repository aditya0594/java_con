package Java_Program;

public class Even_odd_valuefromArray {
    public static void main(String[] args) {
        int a[] = {1,2,3,5,8,10};
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                System.out.println(a[i]);
            }
            }
            for (int i= 0; i <= a.length; i++) {
                if (a[i] % 2 != 0) {
                    System.out.println(a[i]);
                }
            }

        }
    }
