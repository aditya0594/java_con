package Java_tutorial;

public class MotorBike {
    private int speed; // member variable

    MotorBike(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }
    public void increaseSpeed(int howmuch){
        this.speed = this.speed+100;
    }
    public void decreaseSpeed(int decrease){
        this.speed = this.speed-50;
    }

    public void start(){
        System.out.println("bike started");
    }
}
