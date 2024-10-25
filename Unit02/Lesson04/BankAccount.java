// Ali Cole
// Bank Account Homework "Part A"

import java.util.Scanner;

public class BankAccount {
	public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello user! I am MACS, your personal bank ai companion.");
        System.out.println("This is not a scam.");
// Info for account A
        System.out.print("Enter the first account ID: ");
        int idA = in.nextInt();
        System.out.printf("Enter the account balence for ID = %06d ($): ", idA);
        double balanceA = in.nextDouble();
// Info for account B
        System.out.print("Enter the second account ID: ");
        int idB = in.nextInt();
        System.out.printf("Enter the account balence for ID = %06d ($): ", idB);
        double balanceB = in.nextDouble();
// Info for account C
        System.out.print("Enter the third account ID: ");
        int idC = in.nextInt();
        System.out.printf("Enter the account balence for ID = %06d ($): ", idC);
        double balanceC = in.nextDouble();
// Printing and formatting
        System.out.printf("Account #%06d has a balance of $%12.2f%n",idA, balanceA);
        System.out.printf("Account #%06d has a balance of $%12.2f%n",idB, balanceB);
        System.out.printf("Account #%06d has a balance of $%12.2f%n",idC, balanceC);
	}
}