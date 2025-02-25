
public class Demo {
    public static void main(String[] args) {
        clearScreen();
        Yard thisYard = new Yard(4, 5);
        Mower myMow = new Mower(thisYard);

        myMow.startPos(thisYard);
        thisYard.printYard(myMow);
        myMow.startPos(thisYard);
        thisYard.printYard(myMow);
        myMow.startPos(thisYard);
        thisYard.printYard(myMow);

        return;

        // // Collect user input.
        // Scanner in = new Scanner(System.in);
        // System.out.print("Enter the height of the yard: ");
        // int height = in.nextInt();
        // System.out.print("Enter the width of the yard: ");
        // int width = in.nextInt();
        // clearScreen();

        // // Using collected user input, create and display yard.
        // Yard myYard = new Yard(height, width);

        // // Used to test if lawnmower still works in different directions.
        // // User specifies where to start lawnmower and the direction.
        // System.out.print("Enter the row you want the lawnmower to start with (1 being
        // top of the lawn) ");
        // int lmStartRow = in.nextInt();
        // System.out.print("Enter the column you want the lawnmower to start with (1
        // being left of the lawn) ");
        // int lmStartColumn = in.nextInt();
        // System.out.print("What direction do you want the lawnmower to go? (l)eft,
        // (r)ight, (u)p, or (d)own? ");
        // String lmStartDir = in.next().toLowerCase();
        // clearScreen();

        // // Creates the lawnmower and sets start position and dirrection to user
        // // specified vars
        // Mower lm = new Mower(myYard);
        // lm.setCurrRow(lmStartRow);
        // lm.setCurrColumn(lmStartColumn);
        // if (lmStartDir.equals("l")) {
        // lm.turnLeft();
        // } else if (lmStartDir.equals("r")) {
        // lm.turnRight();
        // } else if (lmStartDir.equals("d")) {
        // lm.turnDown();
        // } else if (lmStartDir.equals("u")) {
        // lm.turnUp();
        // }

        // // Print the yard.
        // myYard.printYard(lm);
        // System.out.println();
        // delay(1000);

        // // Loop through cutting grass until lawnmower gets to end of yard.
        // while (lm.seeNext() != ('R')) {
        // clearScreen();
        // lm.cutGrass();
        // lm.moveNext();
        // myYard.printYard(lm);
        // delay(400);
        // }

        // // Waits 5 seconds.
        // delay(5000);
    }

    /** Clears screen */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /** Waits for specified times */
    public static void delay(long mseconds) {
        try {
            Thread.sleep(mseconds);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException received!");
        }
    }

}