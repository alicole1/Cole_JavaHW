// Ali Cole
// Lesson 25 - Creating and Using Classes
// Part A REAL

import java.util.Scanner;

public class Car {
    private double speed;

    public Car() {
        speed = 0.0;
    }

    public Car(double initSpeed) {
        if (initSpeed > 120) {
            speed = 120;
        } else if (initSpeed < 0) {
            speed = 0;
        } else {
            speed = initSpeed;
        }
    }

    public double getSpeed() {
        return speed;
    }

    public void accelerate() {
        if (speed < 120.0) {
            speed++;
        }
    }

    public void brake() {
        if (speed > 0.0) {
            speed = speed - 0.1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a double to start car at specific speed, otherwise start at 0. ");
        Car myCar;
        if (in.hasNextDouble()) {
            myCar = new Car(in.nextDouble());
        } else {
            myCar = new Car();
        }

        String input = "";

        while (true) {
            System.out.print("Use car: (a)ccelerate, (b)rake, or (q)uit: ");
            input = in.next().toLowerCase();
            if (input.equals("b")) {
                myCar.brake();
                System.out.printf("Speedometer reads: %.1f%n", myCar.getSpeed());
            } else if (input.equals("a")) {
                myCar.accelerate();
                System.out.printf("Speedometer reads: %.1f%n", myCar.getSpeed());
            } else if (input.equals("q")) {
                return;
            }
        }
    }

}