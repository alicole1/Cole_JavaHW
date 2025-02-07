// Ali Cole
// Lesson 29 - Overriding Methods
// Part A

public class GearedBicycle extends Bicycle {

    private final int MAX_GEARS = 6;
    private final int GEARED_MAX_SPEED = 50;
    private int gear = 1;

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        if (gear > 0 && gear <= MAX_GEARS) {
            this.gear = gear;
        }
    }

    public void shiftUp() {
        gear++;
        if (gear > MAX_GEARS) {
            gear = MAX_GEARS;
        }
    }

    public void shiftDown() {
        gear--;
        if (gear < 0) {
            gear = 0;
        }
    }

    public void pedal() {
        int newSpeed = getSpeed() + getGear();
        if (newSpeed > GEARED_MAX_SPEED) {
            newSpeed = GEARED_MAX_SPEED;
        }
        setSpeed(newSpeed);
    }

    public void display() {
        System.out.printf("Gear = %02d%n", getGear());
        super.display();
    }

    public void brake() {
        int newSpeed = getSpeed() - 2;
        if (newSpeed < 0) {
            newSpeed = 0;
        }
        setSpeed(newSpeed);
    }

    public static void main(String[] args) {
        GearedBicycle g = new GearedBicycle();
        System.out.println(g.getSpeed());
        g.pedal();
        System.out.println(g.getSpeed());
    }

}
