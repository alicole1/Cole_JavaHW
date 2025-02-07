
import java.util.Scanner;

public class Yard {

    // MAIN METHOD: creates yard with user-specified height and width
    public static void main(String[] args) {
        clearScreen();

        // Collect user input.
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the height of the yard: ");
        int height = in.nextInt();
        System.out.print("Enter the width of the yard: ");
        int width = in.nextInt();
        System.out.println();

        // Using collected user input, create and display yard.
        Yard myYard = new Yard(height, width);
        // myYard.printYard();
        System.out.println();

        // TESTING: Only for troubleshooting. Checking to make sure all methods work.
        System.out.print("NOTE FOR ALI TESTING: Want to test methods? (y/n) ");
        String input = in.next().toLowerCase();
        if (input.equals("y")) {

            // Check to see if get value works.
            System.out.printf("%nDoes getValueAt() work? %n");
            System.out.printf("Value of grass at 0, 0: %s%n%n", myYard.getValueAt(0, 0));

            // Check to remove one block of grass.
            System.out.println("Does changeValueAt() work?");
            System.out.printf("Mow grass at 1,1...%n%n");
            myYard.changeValueAt(1, 1, ' ');
            System.out.printf("Newly mowed yard: %n");
            // myYard.printYard();

            // Check to see if get value updates correct.
            System.out.printf("%nDoes getValueAt() update?%n");
            System.out.println("New value of grass at 1, 1: " + myYard.getValueAt(1, 1));

            // Check if you can get height and width.
            System.out.printf("%nDo getHeight() and getWidth() work correctly? %n");
            System.out.println("Height of yard: " + myYard.getHeight());
            System.out.println("Width of yard: " + myYard.getWidth());

            // Check if change value at works at extremes.
            System.out.printf("%nWill changeValueAt() still work in bottom right?%n");
            myYard.changeValueAt(myYard.getHeight(), myYard.getWidth(), ' ');
            System.out.println("Newly mowed yard:");
            // myYard.printYard();

        }

    }

    // ALL OTHER YARD VARIABLES AND METHODS.

    // Define variables.
    private char[][] yard;
    private static int yardHeight;
    private static int yardWidth;

    /**
     * Constructor Method: input height and width of grass in yard.
     * Creates multidemensional array to represent the yard.
     * Surrounds yard with bricks ("R").
     */
    public Yard(int height, int width) {

        // Creates array. (Adds 2 for bricks)
        yardHeight = height + 2;
        yardWidth = width + 2;
        yard = new char[yardHeight][yardWidth];

        // Fills array with + and R, depending on position.
        for (int i = 0; i < yardHeight; i++) {
            for (int j = 0; j < yardWidth; j++) {
                char value;

                // If current position is on the edge, we will place an R.
                if (i == 0
                        || i == yardHeight - 1
                        || j == 0
                        || j == yardWidth - 1) {
                    value = 'R';

                    // If current position is anything else, we will place a +.
                } else {
                    value = '+';
                }

                // Add specified char value to position in array.
                yard[i][j] = value;
            }
        }
    }

    /**
     * Return the character value at a specified height and width within yard. (does
     * include bricks, ei (1,1) is top left of grass, (height,width) is bottom
     * right of grass).
     */
    public char getValueAt(int heightVal, int widthVal) {
        char currVal = yard[heightVal][widthVal];
        return currVal;
    }

    /**
     * Change the character value to a new specified value at a specified height and
     * width within yard. (does include bricks ei (1,1) is top left of grass,
     * (height,width) is bottom right of grass).
     */
    public void changeValueAt(int heightVal, int widthVal, char newVal) {
        yard[heightVal][widthVal] = newVal;
    }

    /** Return height of yard (does not include bricks). */
    public int getHeight() {
        return yardHeight - 2;
    }

    /** Return width of yard (does not include bricks). */
    public int getWidth() {
        return yardWidth - 2;
    }

    /** Prints current yard in terminal. */
    public void printYard(Mower lm) {
        for (int i = 0; i < yardHeight; i++) {
            for (int j = 0; j < yardWidth; j++) {
                System.out.print(yard[i][j]);
            }
            System.out.println();

            char arrow = ' ';
            switch (lm.getCurrDirection()) {
                case 0:
                    arrow = '^';
                    break;
                case 1:
                    arrow = '>';
                    break;
                case 2:
                    arrow = 'v';
                    break;
                case 3:
                    arrow = '<';
                    break;
                default:
                    throw new AssertionError();
            }

            changeValueAt(lm.getCurrRow(), lm.getCurrColumn(), arrow);

        }
    }

    /** Clears the screen. Static method. */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}