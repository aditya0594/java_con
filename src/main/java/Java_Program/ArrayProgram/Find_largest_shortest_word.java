package Java_Program.ArrayProgram;

public class Find_largest_shortest_word {
    public static void main(String[] args) {
        String string = "This is the worrddd and l m word";
        String[] words = string.trim().replaceAll("//s+"," ").split(" ");
        String shortest = words[0];
        String longest = words[0];
        for(String word : words){
            if(word.length()<shortest.length()){
                shortest=word;
            }
            if(word.length()>longest.length()){
                longest=word;
            }
        }
        System.out.println("The Shortest Word = "+shortest);

        System.out.println("The Longest Word = "+ longest);

    }
}
