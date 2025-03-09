package PartA.animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class Board extends JPanel {
    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private int x = 0;
    private int y = 0;
    private final int DIAMETER = 20;
    private Timer timer;
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;
    private int xSpeed = 2;

    /*
     * Constructor
     */
    public Board() {
        // set background color of the board and default size.
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        // set the initial position of the ball
        // to be on the left side of the content area
        // and in the middle of the content area.
        x = 0;
        y = B_HEIGHT / 2;

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduledUpdate(),
                INITIAL_DELAY, PERIOD_INTERVAL);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // cast to Graphics2D and then create affine transform
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform af = new AffineTransform();
        af.translate(x - DIAMETER / 2, y - DIAMETER / 2);

        // draw a filled ellipse using transformed location.
        Ellipse2D ellipse = new Ellipse2D.Double(0, 0, DIAMETER, DIAMETER);
        Shape transformedShape = af.createTransformedShape(ellipse);
        g2d.setColor(Color.MAGENTA);
        g2d.fill(transformedShape);

    }

    private class ScheduledUpdate extends TimerTask {
        /*
         * Override the run() method.
         * Update the position of our ball here.
         */
        @Override
        public void run() {
            x += xSpeed;
            if (x > B_WIDTH) {
                x = 0;
            }
            repaint();
        }
    }

}
