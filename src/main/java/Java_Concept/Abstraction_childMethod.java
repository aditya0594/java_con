package Java_Concept;

class Abstraction_childMethod extends Abstraction_parentMethod{

    public static void main(String[] args) {
        Abstraction_parentMethod abj = new Abstraction_childMethod();
        abj.myMethod(10);

    }

    @Override
    public void myMethod() {

    }
}
