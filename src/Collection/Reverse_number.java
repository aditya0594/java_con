package Collection;

public class Reverse_number {
    public static void main(String[] args) {
        int num = 1234;
        StringBuilder str = new StringBuilder(String.valueOf(num));
        str.reverse();
        System.out.println(str);
    }
}
