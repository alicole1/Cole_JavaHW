// Ali Cole
// Roman numeral generator

import java.util.Scanner;

public class PartD {
    public static void main(String[] args) {
        // COLLECT USER NUMBER
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number ranging from 1 to 3999: ");
        int num = in.nextInt();
        System.out.println("Your number is " + num);

        // TEST IF NUMBER IS IN RANGE
        if (num < 1 || num >= 4000) {
            System.err.println("Your number falls outside the range. Please try again with another number!");
            return; // Does not go back to normal code and instead stops program
        }

        // BUILD ROMAN NUMERAL
        StringBuilder romanNum = new StringBuilder("");

        // Add all possible M
        int m = num / 1000;
        num = num % 1000;
        for (int i = 0; i < m; i++) {
            romanNum.append("M");
        }
        /* 
        TROUBLESHOOTING: 
        System.out.println(romanNum);
        System.out.println(num); 
        */
        
        // Highest possible number right NOW is 999
        // Account for values over 900 OR add all possible D
        if (num >= 900) {
            romanNum.append("CM");
            num = num - 900;
        } else {
            int d = num / 500;
            for (int i = 0; i < d; i++) {
                romanNum.append("D");
            }
            num = num % 500;
        }
        /* 
        TROUBLESHOOTING: 
        System.out.println(romanNum);
        System.out.println(num); 
        */

        // Highest possible number right NOW is 399
        // Add all possible C
        int c = num / 100;
        num = num % 100;
        for (int i = 0; i < c; i++) {
            romanNum.append("C");
        }
        /* 
        TROUBLESHOOTING: 
        System.out.println(romanNum);
        System.out.println(num); 
        */

        // Highest possible right NOW is 99
        // Account for values over 90 OR add all possible L
        if (num >= 90) {
            romanNum.append("XC");
            num = num - 90;
        } else {
            int l = num / 50;
            num = num % 50;
            for (int i = 0; i < l; i++) {
                romanNum.append("L");
            }
        }
        /* 
        TROUBLESHOOTING: 
        System.out.println(romanNum);
        System.out.println(num); 
        */

        // Highest possible number right NOW is 39
         // Add all possible X
         int x = num / 10;
         num = num % 10;
         for (int i = 0; i < x; i++) {
             romanNum.append("X"); 
        }
        /* 
        TROUBLESHOOTING: 
        System.out.println(romanNum);
        System.out.println(num); 
        */

        // Highest possible right NOW is 9
        // Account for values = 9 OR add all possible V
        if (num == 9) {
            romanNum.append("IX");
            num = num - 9;
        } else {
            int v = num / 5;
            num = num % 5;
            for (int i = 0; i < v; i++) {
                romanNum.append("V");
            }
        }
        /* 
        TROUBLESHOOTING: 
        System.out.println(romanNum);
        System.out.println(num); 
        */

        // Highest possible right NOW is 3
        // Add all possible I
        for (int i = 0; i < num; i++) {
            romanNum.append("I");
        }

        //RETURN INFORMATION TO USER
        System.out.println(romanNum);
    }
}