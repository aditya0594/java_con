package Java_Program.StringProgram;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class pratices {

    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int c = 1;
        int count = 5;
        for(int i = 1; i<=count;i++){
            System.out.print(a + " ");
            a=b;
            b=c;
            c=a+b;
        }



    }
}

