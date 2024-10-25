// Ali Cole AT Java
// AT05: Intro to Object-Oriented Programming
// Part B

/*
 * Pre-programming questions:
 *  List the ways that an external object can interact with a DimmableLight
 *      - View the light (to see if it's on/off)
 *      - Turn on the light
 *      - Turn off the light
 *      - Turn brightness up
 *      - Turn brightness down
 *  Develop a data model that represents the state of a DimmableLight
 *      (What variable type would be suitable for representing the various states of our virtual light?)
 *      - For light on / light off: boolean
 *          boolean power = false: light is off
 *          boolean power = true: light is on
 *      - For brightness of light: int
 *          int brightness = 1: light is at lowest brightness
 *          int brightness = 10: light is at highest brightness
 */

// Import scanner class.
import java.util.Scanner;

class DimmableLight {
    // DECLARE OUR STATES

    // track the power (on/off).
    // true means light is on.
    // false means light is off.
    boolean state = false;

    // track the brightness (dim/bright).
    // 1 means light is dimmest.
    // 10 means light is brightest.
    int brightness = 1;
    
    // CREATE OUR METHODS

    // Methods relating to STATE
    // this method returns true if the light is on.
    public boolean viewState() {
        return state;
    }

    // turn on light.
    public void turnOn() {
        state = true;
    }

    // turn off light.
    public void turnOff() {
        state = false;
    }

    // Methods relating to BRIGHTNESS
    // this method returns corresponding ints for brightness (1 if dim, 10 if bright).
    public int viewBrightness() {
        return brightness;
    }

    // turn up light.
    public void turnUp() {
        // will not do anything if brightness already = 10
        if (brightness < 10) {
            brightness = brightness + 1;
        }
    }

    // turn down light.
    public void turnDown() {
        // will not do anything if brightness already = 1
        if (brightness > 1) {
            brightness = brightness - 1;
        }
    }
}

public class PartB {
    public static void main(String[] args) {        
        // create a new light object.
        DimmableLight light = new DimmableLight();

        // create a new scanner object.
        Scanner scan = new Scanner(System.in);

        // if user does not know commands already; this will help without intruding on users who already know.
        System.out.println("Type help below to see list of commands");

        // let user interact with light.
        while (true) {
            System.out.print("Interact with the lightbulb: ");
            String interact = scan.nextLine().toUpperCase();

            // turn on.
            if (interact.equals("ON")) {
                // calls on method turnOn defined above.
                light.turnOn();
            }

            // turn off.
            else if (interact.equals("OFF")) {
                // calls on method turnOff defined above.
                light.turnOff();
            }

            // view state and brightness.
            else if (interact.equals("VIEW")) {
                // return state to user.
                boolean state = light.viewState();
                if (state == true) {
                    System.out.println("State     : ON");
                } else {
                    System.out.println("State     : OFF");
                }

                // return brightness to user.
                int brightness = light.viewBrightness();
                System.out.println("Brightness: " + brightness);
            }

            // turn up.
            else if (interact.equals("UP")) {
                // calls of method turnUp defined above.
                light.turnUp();
            }

            // turn down.
            else if (interact.equals("DOWN")) {
                light.turnDown();
            }

            // communicate commands to user in standard output.
            else if (interact.equals("HELP")) {
                System.out.println("Commands for the lightbulb:");
                System.out.println("on   : turns on lightbulb");
                System.out.println("off  : turns off lightbulb");
                System.out.println("view : see current state and brightness of the light");
                System.out.println("up   : increase brightness by 1 (max of 10)");
                System.out.println("down : decreases brightness by 1 (min of 1)");
                System.out.println("help : see list of commands");
                System.out.println("q    : quit the program");
            }

            // quit the program.
            else if (interact.equals("Q")) {
                return;
            }

            // account for if they type something they shouldn't.
            else {
                System.err.println("That does not appear to be an approved command. Type help to see list of commandes");
            }
        }

    }
}