package Java_Program;

public class Reverse_number {
    public static void main(String[] args) {
        int num = 1234;
        StringBuilder str = new StringBuilder(String.valueOf(num));
        str.reverse();
        System.out.println(str);


        System.out.print("-------------------------------------------");

        int num1 = 1234;
        char[] chars = String.valueOf(num1).toCharArray();
        System.out.println("This the lenght of array :" + chars.length); // 012345

        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }
}
