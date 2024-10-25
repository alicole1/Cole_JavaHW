// Ali Cole AT Java
// Lesson 08 - Intro to Loops
// Part A

public class PartA {
    public static void main(String[] args) {
        double materialPercent = 100;
        int years = 0;

        // Loop as long as the material percent lost is less than 99% (or percent left is > 1)
        while (materialPercent > 1) {
            materialPercent = materialPercent / 2;
            years = years + 30;
            // TESTING: System.out.println("years: " + years);
            // TESTING: System.out.println("material percent left: " + materialPercent);
        }

        // Return information to user
        System.out.println("It should take " + years + " years");
        System.out.printf("There should be %% %.2f left over %n", materialPercent);
    }
}
