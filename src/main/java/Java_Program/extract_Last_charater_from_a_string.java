package Java_Program;

public class extract_Last_charater_from_a_string{
    public static void main(String[] args) {
        String str = "This is aditya";
        int initial =str.length()-6;
        for(int i=initial;i<str.length();i++){
            System.out.print(str.charAt(i));
        }
    }
}
