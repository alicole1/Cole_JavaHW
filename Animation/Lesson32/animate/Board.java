package animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import sound.SoundClip;

public class Board extends JPanel implements KeyListener, MouseListener {

    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private int diameter = 25;
    private SoundClip blop = new SoundClip("media/blop.wav");
    private SoundClip blip = new SoundClip("media/blip.wav");

    private int circleXPos = B_WIDTH / 2 - diameter / 2;
    private int circleYPos = B_HEIGHT / 2 - diameter / 2;

    /*
     * Constructor
     */
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        this.setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);

        blip.open();
        blop.open();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // draw a magenta square.
        g2d.setColor(Color.MAGENTA);
        g2d.fillOval(circleXPos, circleYPos, diameter, diameter);
    }

    // getX() and getY() functions return the
    // x and y coordinates of the current
    // mouse position
    // getClickCount() returns the number of
    // quick consecutive clicks made by the user

    // this function is invoked when the mouse is pressed
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("( " + e.getX() + " , " + e.getY() + " )");

        circleXPos = e.getX() - diameter / 2;
        circleYPos = e.getY() - diameter / 2;

        blip.play();

        repaint();

    }

    // this function is invoked when the mouse is released
    @Override
    public void mouseReleased(MouseEvent e) {
        // put implementation here

    }

    // this function is invoked when the mouse exits the component
    @Override
    public void mouseExited(MouseEvent e) {
        // put implementation here

    }

    // this function is invoked when the mouse enters the component
    @Override
    public void mouseEntered(MouseEvent e) {
        // put implementation here
    }

    // this function is invoked when the mouse is pressed or released
    @Override
    public void mouseClicked(MouseEvent e) {
        // put implementation here

    }

    @Override
    public void keyTyped(KeyEvent e) {
        char charPressed = e.getKeyChar();

        if (charPressed == ' ') {
            circleXPos = B_WIDTH / 2 - diameter / 2;
            circleYPos = B_HEIGHT / 2 - diameter / 2;
            blop.play();

            repaint();
        }

        // put implementation here
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // put implementation here
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // put implementation here
    }
}
