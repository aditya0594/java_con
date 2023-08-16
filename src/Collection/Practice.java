package Collection;

public class Practice {

    public static void main(String[] args) {
        String inputstring = "aditya";
        char[] chars = inputstring.toCharArray(); //012345
        for (int i=chars.length -1; i>=0; i--){
            System.out.println(chars[i]);
        }

        String inputstring1 = "aditya";
        int lenght = inputstring1.length();
        String rev = "";
        for (int i = lenght-1; i>=0; i--){
            rev = rev+inputstring1.charAt(i);

        }
        System.out.print(rev);
    }

}
