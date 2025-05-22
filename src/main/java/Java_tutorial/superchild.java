package Java_tutorial;

public class superchild extends superparent {


    // Super keyword refer to the instantence variable of the parent class when the child and parent class having same name varible.
    // So to refer the variable from the parent class we use the "Super" variable.
    // To differentiation between the parent class and child class varible you could use the "Super" Keyword
     String  name = "Pawar";
    public void getData(){
        String name = "Aditya";

        // Here call the method from the parent class
        super.getData();

        System.out.println(name); //this is calling the local variable
        System.out.println(this.name); // This is calling the instance variable/class variable/global variable
        System.out.println(super.a); //this is calling from the parent class

    }

    public static void main(String[] args) {
        superchild obj = new superchild();
        obj.getData();
    }

}
