package Java_Concept;

public class constructor {

    //constructor which didnt return any values
    // default constructor does not have the parameters
    /// Compiler will call implicit constructor if you have not defined any contructor
    // if you have two constructor and paramaterized constructor and defined one constructor in main method then  it will call the defualt constructor because
    // compiler find the paramater are given or not


    public constructor(){  //default constructor

        System.out.println("this is the first constructor");
    }

    // parameterized Constructor

    public constructor(int a, int b){
        System.out.println("this is the parameterized constructor");
    }

    public static void main(String[] arg){
        constructor obj = new constructor();
        constructor obj1 = new constructor(5,5);

    }

}
