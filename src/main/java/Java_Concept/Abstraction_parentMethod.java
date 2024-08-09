package Java_Concept;
//here is the abstract class
public abstract class Abstraction_parentMethod {
    //data member cant be abstract
    public int a = 10;

    // myMethod() is the abstract method
    public abstract void myMethod();

    // myMethod() is not a abstract method, It is the concrete method
    void myMethod(int x){
        System.out.println("I am in Super class and I am not an abstract method. I am a concrete method");
    }

    public static void main(String[] args) {

    }
}
