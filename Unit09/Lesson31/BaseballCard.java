// Ali Cole
// Lesson 31 - The Object Class

public class BaseballCard {
    String name; // the name of the player on the card.
    int year; // the year the card was issued.

    public BaseballCard(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return super.toString() + "[name = " + name + "]" + "[year = " + year + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        BaseballCard otherBaseballCard = (BaseballCard) obj;
        if (this.name.equals(otherBaseballCard.name) && this.year == otherBaseballCard.year) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {

        BaseballCard baseballCard1 = new BaseballCard("Dean Kamen", 2025);
        System.out.println(baseballCard1.toString());

        BaseballCard baseballCard2 = new BaseballCard("Dean Kamen", 2025);
        System.out.println(baseballCard2.toString());

        BaseballCard baseballCard3 = new BaseballCard("Mr Eng", 2025);
        System.out.println(baseballCard3.toString());

        if (baseballCard1.equals(baseballCard2)) {
            System.out.println("Baseball cards 1 and 2 are the same!");
        } else {
            System.out.println("Baseball cards 1 and 2 are different!");
        }

        if (baseballCard1.equals(baseballCard3)) {
            System.out.println("Baseball cards 1 and 3 are the same!");
        } else {
            System.out.println("Baseball cards 1 and 3 are different!");
        }

    }
}