package Java_Program.StringProgram;

public class remove_duplicate_characters_from_String {
    public static void main(String[] args) {
        String str = "Programming";
        StringBuilder result = new StringBuilder();
        for(char c : str.toCharArray()){
            if(result.indexOf(String.valueOf(c))==-1){
                result.append(c);
            }
        }
        System.out.println("This is the string " + result);
    }

}
