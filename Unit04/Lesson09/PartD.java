// Ali Cole AT Java
// Lesson 09: Using Loops
// Part D

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
    int dieVal = (int) (Math.random() * 6) + 1;   

    public void roll() {
        dieVal = (int) (Math.random() * 6) + 1;
    }

    public void display() {
        if (dieVal == 1) {
            System.out.println("+-------+");
            System.out.println("|       |");
            System.out.println("|   0   |");
            System.out.println("|       |");
            System.out.println("+-------+");
        } else if (dieVal == 2) {
            System.out.println("+-------+");
            System.out.println("| 0     |");
            System.out.println("|       |");
            System.out.println("|     0 |");
            System.out.println("+-------+");
        } else if (dieVal == 3) {
            System.out.println("+-------+");
            System.out.println("| 0     |");
            System.out.println("|   0   |");
            System.out.println("|     0 |");
            System.out.println("+-------+");
        } else if (dieVal == 4) {
            System.out.println("+-------+");
            System.out.println("| 0   0 |");
            System.out.println("|       |");
            System.out.println("| 0   0 |");
            System.out.println("+-------+");
        } else if (dieVal == 5) {
            System.out.println("+-------+");
            System.out.println("| 0   0 |");
            System.out.println("|   0   |");
            System.out.println("| 0   0 |");
            System.out.println("+-------+");
        } else if (dieVal == 6) {
            System.out.println("+-------+");
            System.out.println("| 0   0 |");
            System.out.println("| 0   0 |");
            System.out.println("| 0   0 |");
            System.out.println("+-------+");
        }
    }
}

public class PartD {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Die die = new Die();
        String input = "";

        do {
            System.out.print("Enter 'r' to roll, 'd' to display, or 'q' to quit: ");
            input = scan.nextLine().toLowerCase();

            if (input.equals("r")) {
                die.roll();
            }

            if (input.equals("d")) {
                die.display();
            }

        } while (! input.equals("q"));

        scan.close();
    }
}
