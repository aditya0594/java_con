package Java_Program.StringProgram;

public class reverse_Sentence_word {
    public static void main(String[] args) {
        String str = "Aditya is learning Java";

        String[] words = str.split(" "); // Split into words
        System.out.println("Original sentence: " + str);

        System.out.print("Reversed sentence: ");
        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }
    }
}
