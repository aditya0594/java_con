package Java_Program;

public class Three_String_concat {

    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "XYZ";
        String s3 = "PQR";
        // we have to concatenate
        StringBuilder str = new StringBuilder();
        str.append(s1+s2+s3);
        System.out.println(str);

        // by using the concat method
        String str1 = s1.concat(s2+s3);
        System.out.println(str1);
    }
}
