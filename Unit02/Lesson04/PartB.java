// Ali Cole
// Tile Alignment Homework "Part B"

import java.util.Scanner;

public class PartB {
    public static void main(String[] args) throws Exception {
    
        Scanner in = new Scanner(System.in); // Set up new scanner
        final int TILE_WIDTH = 5; // Define a constant
    
    // Get user input
        System.out.print("Desired wall width (as an integer): ");
        int wallWidth = in.nextInt();
    
    // Find number of tiles and gap (disregarding even vs odd for now)
        int numberOfTiles = wallWidth / TILE_WIDTH;
        // TESTING: System.out.println("TESTING: Before even vs odd " + numberOfTiles + " tiles");
        double gapTotal = wallWidth % TILE_WIDTH;
        // TESTING: System.out.println("TESTING: Before even vs odd gap is " + gapTotal);

    // Needs to meet black on both sides requirement, therefore needs to be odd
        if (numberOfTiles%2 == 0) {
            System.out.println("There are an even number of tiles!");
            numberOfTiles = numberOfTiles - 1;
            gapTotal = gapTotal + 5;
        }
    // Find and give info to user about size of gap
        double gapPerSide = gapTotal / 2;
        System.out.println("You should have a gap of " + gapPerSide + " inches per side");
    
    // Find and give info to user about number of tiles
        int whiteTiles = numberOfTiles / 2;
        int blackTiles = whiteTiles + 1;
        System.out.println("You should have " + whiteTiles + " white tiles");
        System.out.println("You should have " + blackTiles + " black tiles");
    }
}