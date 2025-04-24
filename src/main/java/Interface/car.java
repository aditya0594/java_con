package Interface;

public class car implements Vehical{

    @Override
    public void start() {
        System.out.println("Car will be started");
    }

    @Override
    public String stop() {
        System.out.println("Car will be stoped ");
        return null;
    }

    @Override
    public void fualType() {
        Vehical.super.fualType();
    }

}
