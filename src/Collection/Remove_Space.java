package Collection;

public class Remove_Space {

    public static void main (String[] args){

     String str = "This the java language";
     String str2  = "";
     char[] chars = str.toCharArray();
     for(int i = 0; i<chars.length;i++) {
         if (chars[i] != ' ') {
             str2 = str2 + str.charAt(i);
         }
     }
        System.out.println(str2);
     }
}
