package animate;

import animate.Cannonball.STATE;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener {
    private final int B_WIDTH = 1280;
    private final int B_HEIGHT = 720;

    private final int FLOOR = B_HEIGHT - 25;

    private Timer timer;
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;

    private Cannon cannon;
    Cannonball ball;

    /*
     * Constructor
     */
    public Board() {
        balls = new ArrayList<>();
        // set background color of the board and default size.
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        this.setFocusable(true);
        this.addKeyListener(this);

        cannon = new Cannon();
        cannon.setXPos(60);
        cannon.setYPos(B_HEIGHT - 60);

        ball = new Cannonball(0, 1, FLOOR);

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduledUpdate(),
                INITIAL_DELAY, PERIOD_INTERVAL);

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

        cannon.draw(g);
        for (Cannonball b : balls)
            b.draw(g2d);
    }

    ArrayList<Cannonball> balls;

    @Override
    public void keyPressed(KeyEvent e) {
        // was the space key pressed?
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("Spacebar was pressed.");
            Cannonball b = new Cannonball(0, 1, FLOOR);
            balls.add(b);
            cannon.fire(b);
            this.repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            cannon.rotateCounterClockwise();
            System.out.println("Left arrow was pressed.");
            this.repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            cannon.rotateClockWise();
            System.out.println("Right arrow was pressed.");
            this.repaint();
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
            for (int i = 0; i < balls.size(); i++) {
                balls.get(i).updateBall();
                if (balls.get(i).getState() == STATE.TOCLEANUP) {
                    balls.remove(i);
                    i--;
                }
            }
            repaint();
        }
    }

}
