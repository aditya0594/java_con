package Java_Concept;

public class main_method_without_static {

    public void myMain(String arg[]){
        System.out.println("This is main method");
    }
    public static void main(String[] args) {
        main_method_without_static instance = new main_method_without_static();
        instance.myMain(args);
    }

  /*  In Java, the main method is the entry point of any standalone Java application.
    It is defined with the static keyword to allow the Java Virtual Machine (JVM) to call it without creating an instance of the class.
   */


}
