// Ali Cole AT Java
// Lesson 12: Variable Scope
// Part B

import java.util.Scanner;

public class PartC { 
    public static boolean isVowel(char currLetter) {
        
        boolean returns = false;
        if ( currLetter == 'a' || 
            currLetter == 'e' ||
            currLetter == 'i' ||
            currLetter == 'o' ||
            currLetter == 'u') {
                returns = true;
            }
        return returns;
    }

    public static int countVowels(String phrase) {
        int vowelCount = 0;
        for (int i = 0; i < phrase.length(); i++) {
            boolean currIsVowel = isVowel(phrase.toLowerCase().charAt(i));
            if (currIsVowel == true) {
                vowelCount++;
            }
        }
        return vowelCount;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your phrase: ");
        String phrase = scan.nextLine();
        scan.close();

        int numOfVars = countVowels(phrase);
        System.out.println(numOfVars);
    }

}
