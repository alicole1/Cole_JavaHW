// Ali Cole AT Java
// Lesson 13: Creating Graphics
// Part C

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class PartC {
    /*
     * Change the following method to customize
     * what is drawn in the JFrame.
     */

    // Helper method to plot a point at a given x, y coordinate.
    public static void plotPoint(int x, int y, Graphics g) {
        int plotX = x + 200;
        int plotY = y + 200;
        g.fillOval(plotX, plotY, 1, 1);
    }

    // Main drawing method.
    public static void draw(Graphics g) {
        
        // Draws background.
        g.setColor(Color.pink);
        g.fillRect(0, 0, 400, 400);

        // Draws shape.
        g.setColor(Color.blue);
        int steps = 10000; // Higher this var, higher the resolution.
        for (double i = 0.0; i<steps; i++) {
            double theta = i*(2*(Math.PI)/steps);
            double r = Math.cos(2*theta);
            int x = (int) (150 * r * Math.cos(theta));
            int y = (int) (150 * r * Math.sin(theta));
            plotPoint(x,y,g);
        }
    }

    public static enum OS {
        WIN, MAC, LINUX, OTHER
    }

    public static OS checkOS() {
        OS val;
        String name = System.getProperty("os.name").toLowerCase();
        if (name.indexOf("win") >= 0) {
            val = OS.WIN;
        } else if (name.indexOf("mac") >= 0) {
            val = OS.MAC;
        } else if (name.indexOf("nux") >= 0) {
            val = OS.LINUX;
        } else {
            val = OS.OTHER;
        }

        return val;
    }

    // Do not modify the code in the main method.
    // Your code will go into the draw method above.
    public static void main(String[] args) {
        // this is the desired dimensions of the content area
        // of our JFrame window.
        final int CONTENT_WIDTH = 400;
        final int CONTENT_HEIGHT = 400;

        // the values for border width and title bar height
        // depend on the operating system.
        int border_width = 0;
        int bar_height = 0;
        OS os = checkOS();
        switch (os) {
            case WIN:
                border_width = 7;
                bar_height = 30;
                break;
            case MAC:
                border_width = 0;
                bar_height = 28;
                break;
            case LINUX:
                // I don't know what the values are for Linux.
                break;
            case OTHER:
                break;
        }

        int frame_width = CONTENT_WIDTH + 2 * border_width;
        int frame_height = CONTENT_HEIGHT + bar_height + border_width;
        JFrame frame = new JFrame();
        frame.setSize(frame_width, frame_height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent component = new JComponent() {
            public void paintComponent(Graphics graph) {
                draw(graph);
            }
        };

        frame.add(component);
        frame.setVisible(true);

        System.out.println("Frame Size   : " + frame.getSize());
        System.out.println("Frame Insets : " + frame.getInsets());
        System.out.println("Content Size : " + frame.getContentPane().getSize());
    }

}