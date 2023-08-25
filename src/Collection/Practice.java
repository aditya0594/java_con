package Collection;

import java.util.HashSet;

public class Practice {

    public static void main(String[] args) {

        String str = "this is the man";
        char[] chars  = str.toCharArray();
        String result= "";
        for(int i=0; i<chars.length; i++){
            if(chars[i]!=' '){
                result = result+chars[i];
            }

        }
        System.out.println(result);




    }
}
