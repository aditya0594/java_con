package polymorphism;

public class method_overriding_child extends method_overriding_parent{

    public void childMethod(){
        System.out.println("this the child class method");
    }

    public static void main(String[] args) {

        method_overriding_parent obj =  new method_overriding_child();
        ((method_overriding_child) obj).childMethod();


    }
}
