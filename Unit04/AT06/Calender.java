import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.Month;


public class Calender {
    public static void main(String[] args) {
        // Collect Month
        LocalDate today = LocalDate.now();
        Month currentMonth = today.getMonth();
        String currentMonthString = currentMonth.toString();
        int monthLength = currentMonthString.length();

        int spaces = (28 - monthLength) / 2;

        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }

        System.out.println(currentMonth);
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        LocalDate firstOfMonth = today.minusDays(today.getDayOfMonth() - 1);
        // System.out.println(firstOfMonth);

        DayOfWeek firstDayOfMonth = firstOfMonth.getDayOfWeek();
        // System.out.println(firstDayOfMonth);

        int currentNumInRow = 0;

        switch (firstDayOfMonth) {
            case MONDAY:
                spaces = 0;
                break;
            case TUESDAY:
                spaces = 4;
                currentNumInRow = 1;
                break;
            case WEDNESDAY:
                spaces = 8;
                currentNumInRow = 2;
                break;
            case THURSDAY:
                spaces = 12;
                currentNumInRow = 3;
                break;
            case FRIDAY:
                spaces = 16;
                currentNumInRow = 4;
                break;
            case SATURDAY:
                spaces = 20;
                currentNumInRow = 5;
                break;
            case SUNDAY:
                spaces = 24;
                currentNumInRow = 6;
                break;
        }

        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }

        int maxDays = currentMonth.length(false);
        int date = 1;

        for (int i = 0; i < maxDays; i++) {
            System.out.printf(" %2d", date);
            if (date == today.getDayOfMonth()) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            if (date == maxDays) {
                System.out.println("");
            }
            date = date + 1;
            currentNumInRow = currentNumInRow + 1;
            if (currentNumInRow == 7) {
                System.out.println("");
                currentNumInRow = 0;
            } else {
              //  System.out.print(" ");
            }
        }




        

        

    }
}