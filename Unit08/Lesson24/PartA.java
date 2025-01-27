// Ali Cole
// Lesson 24 - Intro to Classes & Objects
// Part A

import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Hey! Say anything. ");
        String input = in.nextLine();
        System.out.println("Input is " + input);
        System.out.print("Enter your name. ");
        System.out.println("Your name is " + in.nextLine());
        System.out.print("Enter your age: ");
        System.out.println("Your age is " + in.nextInt());
    }
}