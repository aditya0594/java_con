package Collection;

public class Practice {

    public static void main(String[] args){

        //Method 1
        // using the charater array and for loop

        String inputString = "Aditya";
        char[] chars = inputString.toCharArray();
        //lenght of the array is
        System.out.println("Lenght is " + chars.length); //aditya 0 12345
        for( int i= chars.length -1; i>=0;  i --){
            System.out.print(chars[i]);
        }
        // using the Charat() method

        String inputString1 = "Aditya";
        String revstring =  "";
        for(int i=inputString1.length()-1;i>=0;i--){
            revstring = revstring+inputString1.charAt(i);

        }
        System.out.println(revstring);



    }


}
