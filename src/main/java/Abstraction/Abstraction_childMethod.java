package Abstraction;

class Abstraction_childMethod extends Abstraction_parentMethod{
    @Override
    public void myMethod() {
        System.out.println("this the abstracted method in child class overriding from the parent class");
    }

    public static void main(String[] args) {
        Abstraction_parentMethod obj = new Abstraction_childMethod();
        obj.myMethod(30);
    }

}
