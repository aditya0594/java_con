package Java_Program.ArrayProgram;

import java.util.ArrayList;

public class Replace_array_value {
    //  I have arrayList like [Test1, Test2, Test3, Test4, Test5] Write a Program to replace the "Test2" with string "ReplacedTest"

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Test1");
        arr.add("Test2");
        arr.add("Test3");
        arr.add("Test4");
        arr.add("Test5");
        arr.add("Test6");
        System.out.println("Array before the replace : " + arr);
        int findIndex = arr.indexOf("Test2");
        arr.set(findIndex,"ReplacedTest");
        System.out.println("Array After the replace : " + arr);

    }
}
