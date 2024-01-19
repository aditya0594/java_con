package Java_Program;

public class Reverse_String {
    public static void main(String[] args) {
        // Method 1
        // Convert String into charater Array and for loop

        String inputstring = "Aditya";
        char[] chars = inputstring.toCharArray();
        System.out.println("This the lenght of array :" + chars.length); // 012345

        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }

        // Method 2
        // Using theFor lopp and Charat() method

        String inputString1 = "aditya";
        String revString = "";
        int lenght = inputstring.length();
        for (int i = lenght - 1; i >= 0; i--) {
            revString = revString + inputString1.charAt(i);
        }
        System.out.println("By using the CharAt : " + revString);

        System.out.println("----------------------------------------------");

        //Method 3
        // By using the stringBuffer() class
        StringBuffer StrBuffer = new StringBuffer(inputString1);
        System.out.println(StrBuffer.reverse());

        System.out.println("----------------------------------------------");

        //Method 3
        // By using the stringBuilder() class

        StringBuilder StrBuilder = new StringBuilder(inputString1);
        System.out.println(StrBuffer.reverse());
    }
}





