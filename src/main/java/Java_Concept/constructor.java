package Java_Concept;

public class constructor {

    // Constructor execute block of code whenever the object is created.
    // Constructor didn't return any values
    // Name of the constructor should be the class name.
    // Whenever we create an object constructor is called

    // default constructor does not have the parameters
    /// Compiler will call implicit constructor if you have not defined any contructor
    // if you have two constructor and paramaterized constructor and defined one constructor in main method then  it will call the defualt constructor because
    // compiler find the paramater are given or not


    public constructor(){  //default constructor
        String a = "default constructor";
        System.out.println(a);
    }



    public constructor(int a, int b){    // parameterized Constructor

        System.out.println("this is the parameterized constructor" + "And parameter value :" + a + ", "+b );
    }

    public static void main(String[] arg){
       constructor obj = new constructor();
       constructor obj1 = new constructor(5,5);

    }

}
