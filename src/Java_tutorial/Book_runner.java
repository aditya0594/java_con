package Java_tutorial;

public class Book_runner {
    public static void main(String[] args) {
        Book art_of_computer_programming = new Book(10);
        Book effective_java = new Book(10);
        Book clean_code = new Book(10);


        System.out.println(art_of_computer_programming.getNoOfCopies());
        System.out.println(effective_java.getNoOfCopies());
        System.out.println(clean_code.getNoOfCopies());
    }

}
