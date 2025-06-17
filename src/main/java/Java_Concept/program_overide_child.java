package Java_Concept;

public class program_overide_child extends program_overide{

    public void myMethod(){
        System.out.println("This is the method from the child class");

    }

    public static void main(String[] args) {
        program_overide obj = new program_overide_child();
        obj.myMethod();
        program_overide obj1 = new program_overide();
        obj1.myMethod();


    }
}
