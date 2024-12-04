// Ali Cole AT Java
// Unit 06 Lesson 14: Intro to Arrays
// Part B

public class PartB {
    public static void main(String[] args) {
        // create new array of doubles.
        double[] scores = { 2.2, 1.0, 3.7, 4.1, 88.0 };

        // initialize vars for average calculation.
        double total = 0.0;
        int length = 0;

        // loop through array.
        for (double element : scores) {
            System.out.println(element); // print current element.
            total = total + element; // add current element to total.
            length++; // add one to current number of elements that compose total.
        }

        // calculate and print avg.
        double avg = total / length;
        System.out.println("Avg = " + avg);
    }
}