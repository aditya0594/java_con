package Java_tutorial;

public class MotorRunner {
    public static void main(String[] args){
        MotorBike dukati = new MotorBike(100);
        MotorBike honda = new MotorBike(100);

        System.out.println("Speed of the Bike : "+dukati.getSpeed());
        System.out.println("Speed of the Bike : "+honda.getSpeed());


        dukati.start();
        honda.start();

        //dukati.setSpeed(100);
        //honda.setSpeed(80);


        //dukati.setSpeed(110);
        //honda.setSpeed(100);

        dukati.increaseSpeed(100);
        honda.decreaseSpeed(50);

    }
}
