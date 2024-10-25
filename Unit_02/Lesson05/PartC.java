// Ali Cole
// Lesson 05 Part C
// Dialog box

import javax.swing.JOptionPane;

public class PartC {
    public static void main(String[] args) {
        // Collect user information
        String name = JOptionPane.showInputDialog("Enter your name:");
        String reply = JOptionPane.showInputDialog("Enter your first number:");
        double x = Double.parseDouble(reply);
        reply = JOptionPane.showInputDialog("Enter your second number:");
        double y = Double.parseDouble(reply);

        JOptionPane.showMessageDialog(null, name + ", " + x + " + " + y + " = " + (x+y));
    }
}