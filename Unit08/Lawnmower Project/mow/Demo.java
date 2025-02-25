// Ali Cole
// Lawnmower Project
// Demo

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        String ascii = "                                                 .--.%n" + //
                "                                                /-.  \\%n" + //
                "                                               < ^ `D/%n" + //
                "                                                \\_  (%n" + //
                "                                                  )_/;.%n" + //
                "                                              _ __|_, \\\\%n" + //
                "                                            ,(_I_______)\\%n" + //
                "                                           //`-----\\     \\%n" + //
                "                                          //        \\____/\\%n" + //
                "                                         //         /     /%n" + //
                "                                        // _____   /  /\\  \\%n" + //
                "                            .---n-.    //'`     `\\/  /  \\  \\%n" + //
                "                       _____|_\"_~_|___//         /\\  \\   \\  \\%n" + //
                "                      / /  \\      /  \\ `\\__...--' _\\__\\   \\_/\\%n" + //
                "          \\\\\\\\\\\\\\\\\\\\\\\\'-\\__/--===-\\__/-'`,,,,,,,,(____\\,,,(__/,,,,,,,,,,,,,,,%n" + //
                "          \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\%n";

        boolean isMowable = true;
        int speed = 1000;
        clearScreen();

        System.out.printf(ascii);

        Scanner in = new Scanner(System.in);
        System.out.printf("%nWelcome to lawnmower! Input any button to continue: ");
        in.nextLine();

        clearScreen();
        System.out.print("Enter the height of the yard: ");
        int height = in.nextInt();
        System.out.print("Enter the width of the yard: ");
        int width = in.nextInt();
        clearScreen();

        System.out.printf("On a scale of 1-5, how patient are you? %n1 (very patient) %n5 (very impatient): ");
        int patience = in.nextInt();

        if (patience == 1) {
            speed = 1000;
        } else if (patience == 2) {
            speed = 500;
        } else if (patience == 3) {
            speed = 100;
        } else if (patience == 4) {
            speed = 75;
        } else if (patience == 5) {
            speed = 25;
        }

        Yard thisYard = new Yard(height, width);
        Mower myMow = new Mower(thisYard);

        while (isMowable == true) {
            isMowable = myMow.updateMower(thisYard);
            thisYard.printYard(myMow);
            delay(speed);
            clearScreen();
        }

        System.out.print("Your lawn is mowed! ");
        delay(2500);
        System.out.println("");
        for (int i = 0; i < 3; i++) {
            System.out.print(". ");
            delay(150);
        }
        System.out.print("has been mown? ");
        delay(2500);
        System.out.println("");
        for (int i = 0; i < 3; i++) {
            System.out.print(". ");
            delay(150);
        }
        System.out.print("either way, your lawn looks good now :) ");
        delay(5000);
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