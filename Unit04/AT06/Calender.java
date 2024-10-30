import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.Month;


public class Calender {
    public static void main(String[] args) {
        // Set a variable to collect the month and date it is today.
        LocalDate today = LocalDate.now();


        /*
        * SETTING AND DISPLAYING UP HEADER (month and days of week).
        */
        // Use declared variable to get the current month.
        Month todayMonth = today.getMonth();

        // Center the month title on the page.
        String currentMonthString = todayMonth.toString(); // Needs to be a string to determine length.
        int monthLength = currentMonthString.length(); // Find how many characters make up the name of this month.
        int spaces = (28 - monthLength) / 2;
            // Whole row is 28 spaces across. x number of these spaces are taken up by month name. 
            // Left with x spaces padding name, divide by 2 to determine how many are on the right.
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        } // Loop through printing spaces unitl we've reached the number we want.
        System.out.println(todayMonth); // Print the month name after the spaces.

        // Print days of week.
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");


        /* 
        * SETTING UP START OF "ARRAY".
        */
        // Find information about first day of the month.
        LocalDate firstOfMonth = today.minusDays(today.getDayOfMonth() - 1); // Declare new variable for the first day of the month.
        DayOfWeek firstDayOfMonth = firstOfMonth.getDayOfWeek(); // Using declared variable, find what day of the week this date was on.

        int currentNumInRow = 0; // Create new counter variable for the future to track how many dates are in our row already.

        switch (firstDayOfMonth) {
            case MONDAY: // If first day of month is on monday...
                spaces = 0; // Start on first of row. 
                break; // First date will be first date in row, so no need to add one to counter.
            case TUESDAY: // If first date of month is on tuesday...
                spaces = 4; // Start further in to the "array"
                break; // Monday will be tracked at start of row; so no need to add one to counter.
            case WEDNESDAY:
                spaces = 8;
                currentNumInRow = 1; // Monday will NOT be tracked when we start on wednesday, so we need to add one to counter to account for it.
                break; 
            case THURSDAY:
                spaces = 12;
                currentNumInRow = 2; // Now Monday nor Tuesday will be tracked, so we now need to add two to counter.
                break;
            case FRIDAY:
                spaces = 16;
                currentNumInRow = 3;
                break;
            case SATURDAY:
                spaces = 20;
                currentNumInRow = 4;
                break;
            case SUNDAY:
                spaces = 24;
                currentNumInRow = 5;
                break;
        }
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        } // Add the number of spaces declared in switch statement above to properly position the first date.

        /*
         * DISPLAYING NUMBERS AND DATES.
         */

        // Find max number of days in this month.
        int maxDays = todayMonth.length(false);

        // Loop to add dates until we get to max days in the month.
        for (int i = 1; i < maxDays + 1; i++) {
            currentNumInRow = currentNumInRow + 1; // Add one more "tracked" number in the row.
            if (currentNumInRow == 7) { // If we have 7 numbers in our row... 
                System.out.println(""); // Start the next row.
                currentNumInRow = 0; // Reset counter.
            }
            
            System.out.printf(" %2d", i); // Print a space, then the number. if number is one digit, add a space before it.
            if (i == today.getDayOfMonth()) { // If the date is the day it is today...
                System.out.print("*"); // Add a star next to it.
            } else {
                System.out.print(" "); // Otherwise, add a space.
            }
            if (i == maxDays) {
                System.out.println(""); // If it's the last day of the month, create new line.
            }
            
        }

    }
}