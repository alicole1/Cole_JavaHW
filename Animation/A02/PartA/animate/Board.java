package PartA.animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {
    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private BufferedImage img;

    /*
     * Constructor
     */
    public Board() {
        // set background color of the board and default size.
        setBackground(Color.CYAN);
        // setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        // attempt to load the image
        try {
            File imageFile = new File("PartA/Cotton_Candy_Ice_Cream.png");
            img = ImageIO.read(imageFile);
            setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform affineTransform = new AffineTransform();
        int x_t = 0, y_t = 0;
        double scale = .5;
        if (img != null) {
            x_t = this.getWidth() / 2;
            y_t = this.getHeight() / 2;
            affineTransform.translate(x_t, y_t);
            affineTransform.scale(scale, scale);
            g2d.drawImage(img, affineTransform, null);
        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
        }
    }

}