// Ali Cole
// Lesson 29 - Overriding Methods
// Part B

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public double getAnnualIncome() {
        double income = super.getAnnualIncome() + bonus;
        return income;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }
}
