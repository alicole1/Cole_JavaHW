package PartA;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeWrite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<Employee>();

        String addEmployee = "y";
        while (addEmployee.equals("y")) {
            System.out.print("Employee first name: ");
            String firstName = scanner.nextLine();

            System.out.print("Employee last name: ");
            String lastName = scanner.nextLine();

            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            Employee employee = new Employee(firstName, lastName, id, salary);

        }

    }
}