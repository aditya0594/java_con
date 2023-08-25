package Collection;

public class Stringtointeger {

    public static void main(String[] args) {
        String str = "100";
        // Integer.parseInt()
        System.out.println( Integer.parseInt( str ));


        int x = 123;
        int y = 456;
        String s1 = Integer.toString(x);
        String s2 = Integer.toString(y);
        System.out.println("String s1 = " + s1);
        System.out.println("String s2 = " + s2);
    }


}