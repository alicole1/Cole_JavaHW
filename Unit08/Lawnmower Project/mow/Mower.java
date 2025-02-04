import java.util.Scanner;

public class Mower {
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
        myYard.printYard();
        System.out.println();

        Mower lm = new Mower(myYard);
        for (int i = 0; i < width - 1; i++) {
            lm.mowNext();
            delay(400);
            clearScreen();
        }
        delay(5000);
    }

    private int currRow;
    private int currColumn;
    private int currDirection; // 0 is up, 1 is right, 2 is down, 3 is left;
    private Yard yard;

    public Mower(Yard workingYard) {
        yard = workingYard;
        currRow = 1;
        currColumn = 1;
        currDirection = 1;
    }

    public int getCurrRow() {
        return currRow;
    }

    public void setCurrRow(int newRow) {
        currRow = newRow;
    }

    public int getCurrColumn() {
        return currColumn;
    }

    public void setCurrColumn(int newColumn) {
        currColumn = newColumn;
    }

    public int getCurrDirection() {
        return currDirection;
    }

    public void setCurrDirection(int newDirection) {
        currDirection = newDirection;
    }

    /** Move mower forward by one unit */
    public void mowNext() {
        char arrow = ' ';
        switch (currDirection) {
            case 0:
                // if lawnmower is going up
                currRow = currRow - 1;
                arrow = '^';
                break;
            case 1:
                // if lawnmower is going right
                currColumn = currColumn + 1;
                arrow = '>';
                break;
            case 2:
                // if lawnmower is going down
                currRow = currRow + 1;
                arrow = 'v';
                break;
            case 3:
                // if lawnmower is going left
                currColumn = currColumn - 1;
                arrow = '<';
                break;
            default:
                break;
        }
        yard.changeValueAt(currRow, currColumn, arrow);
        yard.printYard();
    }

    public void cutGrass() {
        yard.changeValueAt(currRow, currColumn, ' ');
    }

    public void changeLRDirection() {

    }

    public void changeUDDirection() {

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void delay(long mseconds) {
        try {
            Thread.sleep(mseconds);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException received!");
        }
    }

}