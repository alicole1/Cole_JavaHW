// Ali Cole
// Lesson 25 - Creating and Using Classes
// Part B

import java.util.ArrayList;
import java.util.Scanner;

class CashRegister {
    private double totalSales;
    private int itemCount;
    private ArrayList<Double> sales = new ArrayList<Double>();

    public CashRegister() {
        totalSales = 0;
        itemCount = 0;
    }

    public void addItem(double price) {
        sales.add(price);
    }

    public double getTotal() {
        totalSales = 0.0;
        for (int i = 0; i < sales.size(); i++) {
            totalSales = totalSales + sales.get(i);
        }
        return totalSales;
    }

    public int getCount() {
        itemCount = 0;
        itemCount = sales.size();
        return itemCount;
    }

    public void clearRecent() {
        sales.remove(sales.size() - 1);
    }

    public void clear() {
        sales.clear();
    }
}

public class PartB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CashRegister cashRegister = new CashRegister();
        String sInput = "";
        double addedSale = 0.0;
        double sales = 0.0;
        int itemCount = 0;
        while (!sInput.toLowerCase().equals("q")) {
            System.out.print("Input sale or command! Press h for help. ");
            if (in.hasNextDouble()) {
                addedSale = in.nextDouble();
                cashRegister.addItem(addedSale);
            } else if (in.hasNext()) {
                sInput = in.next();
                if (sInput.toLowerCase().equals("t")) {
                    sales = cashRegister.getTotal();
                    itemCount = cashRegister.getCount();
                    System.out.printf("Sales total: $%.2f %nItem count: %d%n", sales, itemCount);
                } else if (sInput.toLowerCase().equals("d")) {
                    cashRegister.clearRecent();
                    System.out.println("Most recent entry deleted.");
                } else if (sInput.toLowerCase().equals("c")) {
                    cashRegister.clear();
                    System.out.println("Cash register cleared.");
                } else if (sInput.toLowerCase().equals("h")) {
                    System.out.println("Press t to display sales total and item count.");
                    System.out.println("Press d to delete most recent sales entry.");
                    System.out.println("Press c to clear the current sales total and item count");
                    System.out.println("Press q to quit the program");
                }
            }
        }
        System.out.println("Thanks for using the cash register!");
    }
}