package Java_Concept;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read_File_Scanner {


    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/STM.txt"));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
