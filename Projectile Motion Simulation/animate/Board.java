package animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener {
    private final int B_WIDTH = 1280;
    private final int B_HEIGHT = 720;

    private final int FLOOR = B_HEIGHT - 25;

    /*
     * Constructor
     */
    public Board() {
        // set background color of the board and default size.
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        this.setFocusable(true);
        this.addKeyListener(this);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // cast to Graphics2D and then create affine transform
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, FLOOR, B_WIDTH, FLOOR);

        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, FLOOR + 1, B_WIDTH, FLOOR);
        // AffineTransform af = new AffineTransform();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // was the space key pressed?
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("Spacebar was pressed.");
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left arrow was pressed.");
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right arrow was pressed.");
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Up arrow was pressed.");
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Down arrow was pressed.");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    private class ScheduledUpdate extends TimerTask {
        /*
         * Override the run() method.
         * Update the position of our ball here.
         */
        @Override
        public void run() {
            repaint();
        }
    }

}
