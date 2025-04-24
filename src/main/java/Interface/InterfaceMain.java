package Interface;

public class InterfaceMain {
    public static void main(String[] args) {
        Vehical.generalMethod(); // calling the static method from the interface call
        Vehical car = new car();  //creating the object of the parent class reference to refer to the child class abject
        car.stop();
        car.start();
        car.fualType();
    }
}
