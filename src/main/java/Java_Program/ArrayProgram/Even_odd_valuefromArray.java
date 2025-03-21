package Java_Program.ArrayProgram;

import java.util.ArrayList;

public class Even_odd_valuefromArray {
    public static void main(String[] args) {

        int a[] = {1,2,3,5,8,10};
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                even.add(a[i]);
            }
            }
            for (int i= 0; i < a.length; i++) {
                if (a[i] % 2 != 0) {
                    odd.add(a[i]);

                }
            }
        System.out.println("This is the even numbers from the array " + even);
        System.out.println("This is the odd numbers from array : " + odd);
        }
    }
