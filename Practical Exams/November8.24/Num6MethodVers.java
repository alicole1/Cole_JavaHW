import java.util.Scanner;

class Swapper {
    int first = 0;
    int second = 0;

    public void swap(int inputFirst, int inputSecond) {
        second = inputSecond;
        first = inputFirst;
    }
    public int newFirst() {
        return first;
    }
    public int newSecond() {
        return second;
    }
}

public class Num6MethodVers {

    public static void main(String[] args) {
        // Declare scanner object.
        Scanner scan = new Scanner(System.in);
        Swapper swap = new Swapper();

        // Collect user info.
        System.out.print("First integer: ");
        int largestInt = scan.nextInt();
        System.out.print("Second integer: ");
        int middleInt = scan.nextInt();
        System.out.print("Third integer: ");
        int smallestInt = scan.nextInt();

        // Sort integers.
        // TROUBLESHOOTING System.out.println("Original order of numbers: " + largestInt + " " + middleInt + " " + smallestInt);

        if (largestInt < middleInt) {
            swap.swap(middleInt, largestInt);
            largestInt = swap.newFirst();
            middleInt = swap.newSecond();
        }

        if (largestInt < smallestInt) {
            swap.swap(smallestInt, largestInt);
            largestInt = swap.newFirst();
            smallestInt = swap.newSecond();
        }

        if (middleInt < smallestInt) {
            swap.swap(smallestInt, middleInt);
            middleInt = swap.newFirst();
            smallestInt = swap.newSecond();
        }

        // Give information to user.
        System.out.println("All should be in correct order: " + largestInt + " " + middleInt + " " + smallestInt);

        // Close scanner.
        scan.close();
    }
}
