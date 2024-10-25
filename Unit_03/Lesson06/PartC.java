// Ali Cole
// Lesson 06 Part C
// Fixing code section

/*
* The original code does not produce the expected output 
* as you cannot compare two floating point values like this.

* This is because as you get further down the decimal places, 
* the information may be a little spotty

* We may not care about the difference between 12.0000000 and 12.0000001, 
* but the computer does
*/

public class PartC {
    public static void main(String[] args) {
        double a = 1.2; 
        final double THRESHOLD = 1e-14;
        double b= 3.0;
        double c = a * b; 
        if(Math.abs(c-3.6) < THRESHOLD) {
            System.out.println("c is 3.6");
        } else {
            System.out.println("c is not 3.6");
        }
    }
}
