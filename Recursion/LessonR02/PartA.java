import java.util.Scanner;

public class PartA {
    public static boolean isPalin(String phrase) {
        if (phrase.length() == 1 || phrase.length() == 0) {
            return true;
        } else if (phrase.charAt(0) == phrase.charAt(phrase.length() - 1)) {
            String newPhrase = phrase.substring(1, phrase.length() - 1);
            return isPalin(newPhrase);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your phrase: ");
        String phrase = in.nextLine();
        String reducedPhrase = phrase.toLowerCase().replace(" ", "").replace(",", "").replace("'", "");
        boolean isPalin = isPalin(reducedPhrase);
        if (isPalin == true) {
            System.out.printf("Your phrase %s is a palindrome!%n", phrase);
        } else {
            System.out.printf("Your phrase %s is not a palindrome :(%n", phrase);
        }
    }
}