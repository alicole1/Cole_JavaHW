// Ali Cole
// Lawnmower Project
// Mower Class

import java.util.Random;

public class Mower {

    // Define variables.
    private int currRow;
    private int currColumn;
    private int currDirection; // 0 is up, 1 is right, 2 is down, 3 is left;
    private Yard yard;

    /**
     * Constructs lawnmower. Sets lawnmower by default in top left corner of lawn
     * going left.
     */
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

    public void turnRight() {
        setCurrDirection(getCurrDirection() + 1);
        if (getCurrDirection() > 3) {
            setCurrDirection(0);
        }
    }

    public void turnLeft() {
        setCurrDirection(getCurrDirection() - 1);
        if (getCurrDirection() < 0) {
            setCurrDirection(3);
        }
    }

    /** Move mower forward by one unit */
    public void moveNext() {
        switch (currDirection) {
            case 0:
                // if lawnmower is going up
                currRow = currRow - 1;
                break;
            case 1:
                // if lawnmower is going right
                currColumn = currColumn + 1;
                break;
            case 2:
                // if lawnmower is going down
                currRow = currRow + 1;
                break;
            case 3:
                // if lawnmower is going left
                currColumn = currColumn - 1;
                break;
            default:
                break;
        }
    }

    /** Returns the character value of the space the lawnmower will move to next */
    public char seeNext() {
        int seenRow = currRow;
        int seenColumn = currColumn;
        switch (currDirection) {
            case 0:
                // if lawnmower is going up
                seenRow = currRow - 1;
                break;
            case 1:
                // if lawnmower is going right
                seenColumn = currColumn + 1;
                break;
            case 2:
                // if lawnmower is going down
                seenRow = currRow + 1;
                break;
            case 3:
                // if lawnmower is going left
                seenColumn = currColumn - 1;
                break;
            default:
                break;
        }
        return yard.getValueAt(seenRow, seenColumn);
    }

    /**
     * Cuts the grass under the space the lawnmower is currently on
     * Note: removes lawnmower icon. Make sure you move the lawnmower before
     * displaying yard again.
     */
    public void cutGrass() {
        yard.changeValueAt(currRow, currColumn, ' ');
    }

    public void startPos(Yard workingYard) {
        int maxHeight = workingYard.getHeight() + 1;
        int maxWidth = workingYard.getWidth() - 1;
        Random r = new Random();
        int randPos = r.nextInt(4) - 1;
        if (randPos == 1) { // top left
            setCurrRow(1);
            setCurrColumn(1);
        } else if (randPos == 2) { // top right
            setCurrRow(1);
            setCurrColumn(maxHeight);
        } else if (randPos == 3) { // bottom left
            setCurrRow(maxWidth);
            setCurrColumn(1);
        } else if (randPos == 4) { // bottom right
            setCurrRow(maxWidth);
            setCurrColumn(maxHeight);
        }
        int randDirection = r.nextInt(3); // randomize direction
        setCurrDirection(randDirection);
    }

    public boolean updateMower(Yard workingYard) {
        for (int i = 0; i < 4; i++) {
            if (seeNext() == '+') {
                cutGrass();
                moveNext();
                return true;
            } else {
                turnRight();
            }
        }
        return false;
    }
}