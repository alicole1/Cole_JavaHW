public class ExampleOutput {
    public static void main(String[] args) {
        Employee ed = new Employee("Ed", 50000.00);
        double edSalary = ed.getSalary();
        double edIncome = ed.getAnnualIncome();
        String edName = ed.getName();

        Manager deidra = new Manager("Deidra", 65000.00, 7500);
        double deidraSalary = deidra.getSalary();
        double deidraIncome = deidra.getAnnualIncome();
        String deidraName = deidra.getName();
        System.out.printf("%-10s: salary = $   %,.2f; annual income = $   %,.2f%n", edName, edSalary,
                edIncome);
        System.out.printf("%-10s: salary = $   %,.2f; annual income = $   %,.2f%n", deidraName, deidraSalary,
                deidraIncome);

    }
}
