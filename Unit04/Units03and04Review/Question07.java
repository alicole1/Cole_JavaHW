import java.util.Scanner;

public class Question07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String letterInput = "";
        Double numberInput;
        Double smallestNumber = Double.POSITIVE_INFINITY;
        Double largestNumber = Double.NEGATIVE_INFINITY;
        Double validEntries = 0.0;
        Double total = 0.0;
        do {
            System.out.print("Input:");
            try {
                numberInput = scan.nextDouble();
                if (numberInput > largestNumber) {
                    largestNumber = numberInput;
                }
                if (numberInput < smallestNumber) {
                    smallestNumber = numberInput;
                }
                total = total + numberInput;
                validEntries = validEntries + 1;
            } catch (Exception e) {
                letterInput = scan.nextLine().toUpperCase();
            }
            //input = scan.nextLine().toUpperCase();
        } while (! letterInput.equals("Q"));
        System.out.println("The smallest number you entered was " + smallestNumber);
        System.out.println("The largest number you entered was " + largestNumber);
        System.out.printf("You entered %.0f number(s) %n",validEntries);
        System.out.println("The average of all of your numbers was: " + (total / validEntries));
    }
}