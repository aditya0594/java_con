package Java_Program.ArrayProgram;

import java.util.ArrayList;
import java.util.LinkedList;

public class Insert_value_at_end_of_array {

    public static void main(String[] args) {
        LinkedList<String> arr = new LinkedList<>();
        arr.add("Test1");
        arr.add("Test2");
        arr.add("Test3");
        arr.add("Test4");
        arr.add("Test5");
        arr.add("Test6");
        System.out.println("Array before the replace : " + arr);

        arr.offerLast("LastInsertedElement");
    }
}
