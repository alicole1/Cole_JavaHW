package PartB.animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {
    private final int B_WIDTH = 720;
    private final int B_HEIGHT = 720;
    private BufferedImage img;

    private int x = 0;
    private int y = 0;
    double degrees;
    double theta;
    double anchorx;
    double anchory;

    private Timer timer;
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;
    private int xSpeed = 1;
    private int ySpeed = 1;
    private int spinSpeed = 5;

    /*
     * Constructor
     */
    public Board() {
        // set background color of the board and default size.
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        // attempt to load the image
        try {
            File imageFile = new File("PartB/Andy.png");
            img = ImageIO.read(imageFile);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        x = -1 * img.getWidth() / 2;
        y = -1 * img.getHeight() / 2;
        theta = Math.toRadians(0);
        anchorx = img.getWidth() / 2;
        anchory = img.getHeight() / 2;

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

        if (img != null) {
            af.rotate(theta, anchorx, anchory);
            af.translate(x, y);
            g2d.drawImage(img, af, null);
        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
        }

    }

    private class ScheduledUpdate extends TimerTask {
        /*
         * Override the run() method.
         * Update the position of our ball here.
         */
        @Override
        public void run() {
            x += xSpeed;
            y += ySpeed;
            if (x > B_WIDTH || y > B_HEIGHT) {
                x = 0;
                y = 0;
            }

            anchorx = x + img.getWidth() / 2;
            anchory = y + img.getHeight() / 2;
            degrees += spinSpeed;
            if (degrees > 360) {
                degrees = 0;
            }
            theta = Math.toRadians(degrees);

            repaint();
        }
    }

}
