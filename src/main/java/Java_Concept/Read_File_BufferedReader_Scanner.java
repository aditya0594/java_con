package Java_Concept;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Read_File_BufferedReader_Scanner {
    public static void main(String[] args) {


        try {
            BufferedReader reader = new BufferedReader(new FileReader(""));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line); // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
