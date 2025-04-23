import java.util.Scanner;

public class PartB {
    public static boolean isPalin(String phrase) {
        int length = phrase.length();
        while (length != 0 && length != 1) {
            if (phrase.charAt(0) != phrase.charAt(length - 1)) {
                return false;
            } else {
                phrase = phrase.substring(1, length - 1);
                length = length - 2;
            }
        }
        return true;
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
