// Ali Cole
// Lesson 29 - Overriding Methods
// Part A

public class OverrideDemo {
    public static void main(String[] args) {
        Bicycle b = new Bicycle();
        System.out.println("Typical bike:");
        b.display();

        // pedal the bike.
        b.pedal();
        b.display();

        // brake the bike.
        b.brake();
        b.display();

        GearedBicycle stevesBicycle = new GearedBicycle();
        System.out.printf("%nGeared bike:%n");
        // pedal with geared bike.
        stevesBicycle.shiftUp();
        stevesBicycle.pedal();
        stevesBicycle.pedal();
        stevesBicycle.display();

        // brake with geared bike.
        stevesBicycle.brake();
        stevesBicycle.display();

    }
}
