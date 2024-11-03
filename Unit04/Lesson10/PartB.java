import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        /*
        * Provided Code
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of cookies: ");
        int num = in.nextInt();
        Double discount;
        if (num > 6) {
            discount = 0.05;
        } else if (num > 12) {
            discount = 0.10;
        }
        System.out.println("Discount = " + discount);

        * What kind of error?
        Compile time; discount is referenced outside of if statement when it was only initialized inside (it is established outside but has no value)
        As there is no flat else statement, there is a possibility code reaches line 16 without an initialized value for discount

        Logic; if else ladder does not have most specific first. if user had 13 cookies, discount was still 0.05
        */

        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of cookies: ");
        int num = in.nextInt();
        Double discount = 0.0;
        if (num > 12) {
            discount = 0.10;
        } else if (num > 6) {
            discount = 0.05;
        }
        System.out.println("Discount = " + discount);  

    }
}
