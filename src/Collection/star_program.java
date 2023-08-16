package Collection;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class star_program {
    public static void main(String[] args) {

        for (int i =0; i<=4 ; i++){
            for(int j=0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("-----------------------------------");

        for (int i =0; i<=4 ; i++){
            for(int j=4; j>=i;j--){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("-----------------------------------");

        for (int i=0; i<=0; i++){
            for (int j =4; j>=i; j--){
                System.out.print(" ");
            }
            for(int k=1;k<=i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
