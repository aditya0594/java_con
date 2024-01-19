package Java_Program;

public class practices {

    public static void main(String[] args) {

// Reverse the each word in the sentence
        String str = "Aditya pawar";
        String[] words = str.split(" ");
        String revString = "";
        for(String w : words){
            String revwords = "";
            for( int i = w.length()-1; i>=0 ; i--){
                revwords = revwords+w.charAt(i);
            }

            revString = revString + revwords +" ";
        }
        System.out.println(revString);

    }



}
