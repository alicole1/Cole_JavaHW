// Ali Cole
// Lesson 05 Part A
// Make a monogram

import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
    //Get input from user
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your first middle and last names: ");
        String name = in.nextLine();
    //Make the monogram
        String firstNameInit = name.substring(0,1);
        String middleNameInit = name.substring(name.indexOf(" ")+1, name.indexOf(" ")+2);
        String lastNameInit = name.substring(name.lastIndexOf(" ")+1, name.lastIndexOf(" ")+2);
        String mono = firstNameInit + middleNameInit + lastNameInit;
    //Print results to user
        System.out.println("Your monogram is " + mono.toUpperCase());

    //Troubleshooting tests :)
        //Check if name collected right
            //System.out.println(name);
        //Check if you have the location of spaces correct
            //System.out.println(name.indexOf(" "));
            //System.out.println(name.lastIndexOf(" "));
    }
}
