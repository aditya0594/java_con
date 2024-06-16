package Inharitance;

public class Class_B extends Class_A{

    //  Why we user the inheritance and what is the use of it
    // we use inheritance for the code Re usability
    // for the methodoveridding
    //


    String Lastname = "This methodClass  B ";
    public void MethodClassB(){
        System.out.println(Lastname);
        System.out.println(super.Name); // this calling the variable from the prarent class we have to user the super lkeyword

    }
    public void getdata(){
        super.getdata();
        System.out.println("I am in child class");
    }

    public static void main(String[] args){
        Class_B obj = new Class_B();
        obj.MethodClassB();
        obj.getdata();
    }
}
