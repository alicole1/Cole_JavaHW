// Ali Cole AT Java
// AT HW 07: Writing a Class
// Part A

/* PRE-CODE ANALYSIS:
    There are two ways the user can interact with the die:
        1. roll the die - roll() method using Math.random().
        2. look at the die - inspect() method using return and System.out.

    6 states for the die to be in:
        1. one dot
        2. two dots
        3. three dots
        4. four dots
        5. five dots
        6. six dots
    As these are numerical values, let's represent them with ints. 
        (1 = one dot up, 6 = six dots up, etc)
*/ 
import java.util.Scanner;

class Die {
    Scanner scan = new Scanner(System.in);
    // MEMBER VARIABLES
    int dieVal; // integer for die value.

    // CONSTRUCTOR DECLARATIONS
    public Die() {
        dieVal = 1; // constructor for the class. sets default val to 1.
    }

    // METHOD DECLARATIONS
    // Getters And Setters.
    // getter.
    public int getVal() {
        return dieVal;
    }

    // setter.
    public void setVal() {
        System.out.print("Changing the die value... ");
        int input = scan.nextInt();
        if (input > 0 && input <= 6) {
            dieVal = input;
        } else {
            System.err.println("Oops! Die can only be set to values between 1 and 6.");
        }
    }

    // Other Methods.
    // roll the die.
    public void roll() {
        dieVal = (int) (Math.random() * 6) + 1;
    }

    // display the die value.
    public void display(int currentVal) {
        if (currentVal == 1) {
            System.out.println("+-------+");
            System.out.println("|       |");
            System.out.println("|   0   |");
            System.out.println("|       |");
            System.out.println("+-------+");
        } else if (currentVal == 2) {
            System.out.println("+-------+");
            System.out.println("| 0     |");
            System.out.println("|       |");
            System.out.println("|     0 |");
            System.out.println("+-------+");
        } else if (currentVal == 3) {
            System.out.println("+-------+");
            System.out.println("| 0     |");
            System.out.println("|   0   |");
            System.out.println("|     0 |");
            System.out.println("+-------+");
        } else if (currentVal == 4) {
            System.out.println("+-------+");
            System.out.println("| 0   0 |");
            System.out.println("|       |");
            System.out.println("| 0   0 |");
            System.out.println("+-------+");
        } else if (currentVal == 5) {
            System.out.println("+-------+");
            System.out.println("| 0   0 |");
            System.out.println("|   0   |");
            System.out.println("| 0   0 |");
            System.out.println("+-------+");
        } else if (currentVal == 6) {
            System.out.println("+-------+");
            System.out.println("| 0   0 |");
            System.out.println("| 0   0 |");
            System.out.println("| 0   0 |");
            System.out.println("+-------+");
        }
    }
}

public class PartA {
    public static void main(String[] args) {
        // Create new objects.
        Scanner scan = new Scanner(System.in);
        Scanner rollingScanner = new Scanner(System.in);
        Die die = new Die();

        // Declare and initialize new variables. 
        int dieVal = die.getVal();
        System.out.println("The initial value of the die is " + dieVal);
        String input = "";

        do {
            // Collect user information.
            System.out.print("Enter 'r' to roll, 's' to set value, 'd' to display, or 'q' to quit: ");
            input = scan.nextLine().toLowerCase();

            // Roll the die.
            if (input.equals("r")) {
                // Allows the user to roll the die multiple times.
                System.out.print("How many times would you like to roll the die? ");
                int intInput = rollingScanner.nextInt();
                System.out.println("Rolling the die " + intInput + " times...");
                // Roll the die until we've done it the number of times user specified.
                for (int i = 0; i < intInput; i++) {
                    die.roll();
                    System.out.println("The new value of the die is " + die.getVal());
                }
                // Sets dice value to last rolled value.
                dieVal = die.getVal();
            }

            // Set the die.
            if (input.equals("s")) {
                die.setVal();
                System.out.println("The new value of the die is " + die.getVal());
                dieVal = die.getVal();
            }

            // Display the die.
            if (input.equals("d")) {
                die.display(dieVal);
            }
        
        // If user inputs 'q' or "Q" loop is quit.
        } while (! input.equals("q"));
    scan.close();
    rollingScanner.close();
    }
}
