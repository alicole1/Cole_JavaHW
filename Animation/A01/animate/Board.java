package animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;

public class Board extends JPanel {
    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int SIDELENGTH = 150;

    /*
     * Constructor
     */
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int x_t = getWidth() / 2;
        int y_t = getHeight() / 2;
        x_t = x_t - SIDELENGTH / 2;
        y_t = y_t - SIDELENGTH / 2;

        Rectangle r = new Rectangle(0, 0, SIDELENGTH, SIDELENGTH);

        // shift or translate the magenta square from (0,0) to center.
        AffineTransform af = new AffineTransform();
        af.translate(x_t, y_t);

        double theta = Math.toRadians(22.5);
        double anchorx = SIDELENGTH / 2;
        double anchory = SIDELENGTH / 2;

        af.rotate(theta, anchorx, anchory);

        Shape shape = af.createTransformedShape(r);
        g2d.setColor(Color.MAGENTA);
        g2d.fill(shape);

        // send a little message.
        g2d.setColor(Color.BLUE);
        g2d.drawString("Hello World!", 50, 50);
    }

}
