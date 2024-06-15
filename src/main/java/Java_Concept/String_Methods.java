package Java_Concept;

public class String_Methods {
    public static void main(String[] args) {

        System.out.println("-----------charAt()----------");
        String string = "Academy";
        char ch = string.charAt(1);
        System.out.println(ch);// Returns c

        System.out.println("-----------.concat()----------");
        String string1 = "Aditya";
        String string2 = "Pawar";
        String str = string1.concat(string2);
        System.out.println("Concat String : "+ str);

        System.out.println("-----------.contains()----------");
        String string3 = "Aditya";
        Boolean value = string3.contains("Ad");
        System.out.println("Boolean value is : " +value);


        System.out.println("-----------.equals()----------");
        String string11 = "Tiger";
        String string22 = "Tiger";
        boolean bool = string11.equals(string22);//Returns true


    }




}
