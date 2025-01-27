// Ali Cole
// Lesson 24 - Intro to Classes & Objects
// Part B

import java.util.Scanner;

class Counter {
    private int count = 0;

    public int getValue() {
        return count;
    }

    public void count() {
        count = count + 1;
    }

    public void reset() {
        count = 0;
    }
}

public class PartB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = "";
        Counter cakeCount = new Counter();
        Counter pieCount = new Counter();
        while (!input.toLowerCase().equals("q")) {
            System.out.print("Do you prefer (c)ake or (p)ie for dessert? Press (q) to quit. ");
            input = in.nextLine();
            if (input.toLowerCase().equals("c")) {
                cakeCount.count();
            } else if (input.toLowerCase().equals("p")) {
                pieCount.count();
            }
        }
        int cakeCountNum = cakeCount.getValue();
        int pieCountNum = pieCount.getValue();
        System.out.println("Votes for cake: " + cakeCountNum);
        System.out.println("Votes for pie: " + pieCountNum);
    }
}