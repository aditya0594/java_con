package Abstraction;
//here is the abstract class
public abstract class Abstraction_parentMethod {
    //data member cant be abstract
    public int a = 10;

    // myMethod() is the abstract method
    public abstract void myMethod();


    // myMethod() is not a abstract method, It is the concrete method
   public void myMethod(int x){
        System.out.println("I am in Super class and I am not an abstract method. I am a concrete method");

    }

    /**
     We use abstraction when we know that our class should have some methods
     but we are not sure how exactly those methods should function.

     Assume, I am creating a class of Vehicle which should have a method called start().
     There will be some other subclass of this Vehicle class such as Car, Bike and these two subclasses use start() method.
     But the implementation of start() method in Car is different from Bike.
     So in this case I don’t implement the start() method in Vehicle class and implement those in subclasses.
     */
}
