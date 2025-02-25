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
}
