package Java_Program.Calculation;

public class palindrom {
    public static void main(String[] args) {
        String str = "maam";
        String reverse ="";
        for(int i = str.length();i>=0;i-- ){
            reverse = reverse+str.charAt(i);
        }
        if(str.equalsIgnoreCase(reverse)){
            System.out.println("this is the palindrome ");
        }
        else {
            System.out.println("Not a palindrome");
        }
    }

   /* public static void main(String[] args) {
        int num = 1234421;
        String reversedStr="";
        String numstr = Integer.toString(num);
        for(int i=numstr.length()-1; i>=0;i--){
            reversedStr += numstr.charAt(i);
        }
        System.out.println("Reverse number" +reversedStr);
        if(numstr.equals(reversedStr)){
            System.out.println("This is palindrom");
        }
        else {
            System.out.println("Not a palindrom");
        }
    }*/


}
