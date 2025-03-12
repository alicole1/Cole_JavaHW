package PartA;

import PartA.animate.Application;
import java.awt.EventQueue;

public class Demo {
    public static void main(String[] args) {
        /*
         * In Java, GUI related actions should be
         * performed in the AWT event thread
         * or it could cause severe problems with the GUI.
         * EventQueue.invokeLater() posts your GUI-related
         * actions in the AWT event queue to avoid causing
         * any problems with other GUI-related actions.
         */
        EventQueue.invokeLater(() -> {
            Application myApp = new Application("You did it!");
            myApp.setVisible(true);
        });
    }
}
