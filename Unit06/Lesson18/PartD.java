// Ali Cole
// Lesson 18 - Array Lists
// Part D

import java.util.ArrayList;
import java.util.Scanner;

public class PartD {
    // METHOD: Collects and fills an array.
    public static void getNums(Scanner scanner, ArrayList<Integer> nums) {

    while (true) { 
        System.out.print("Enter an integer or 'q' to quit: ");
        if (scanner.hasNext("q") || scanner.hasNext("Q")) { // Quits if user enters q.
            scanner.nextLine(); // "uses up" input.
            break;

        } else if (scanner.hasNextInt()) { // Collects numbers.
            nums.add(scanner.nextInt());
        } else { // If user inputs something else, we don't want to accept.
            scanner.nextLine(); // "uses up" input.
            System.err.println("Invalid Input!");
        }
    }
    // We do not need to return the array, as it is passed by reference.
    }

    // METHOD: Removes every odd number.
    public static void dropOdds(ArrayList<Integer> nums) {
        int size = nums.size();
        int currNum;
        for (int i = 0; i < size;) {
            currNum = nums.get(i);
            if (currNum % 2 != 0) {
                nums.remove(i);
                size = size-1;
            } else {
                i++;
            }
        }
    }

    // METHOD: Prints an ArrayList.
    public static void printList(ArrayList<Integer> nums) {
        System.out.printf("%nNumbers: %n------------------ %n");
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
    
        getNums(scan, list);
        dropOdds(list);
        printList(list);

    }
}