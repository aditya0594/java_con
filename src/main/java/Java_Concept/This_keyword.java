package Java_Concept;

public class This_keyword {
    private String name;

    // Constructor
    public This_keyword(String name) {
        // Use "this" to refer to the instance variable "name"
        this.name = name;
    }

    // Method to print the name of the person
    public void printName() {
        // Use "this" to refer to the instance variable "name"
        System.out.println("My name is " + this.name);
    }

    // Main method
    public static void main(String[] args) {
        // Create a new Person object
        This_keyword person = new This_keyword("John");
        This_keyword personAge = new This_keyword(1);
        // Call the printName method
        person.printName();
        personAge.getAge();
    }

    private int age;

    private This_keyword(int age){
        this.age = age;
    }
    public void getAge(){
        System.out.println(this.age);
    }


}
