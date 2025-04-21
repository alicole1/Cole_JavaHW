package animate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import sound.SoundClip;

class Cannon {
    SoundClip fireSound;
    SoundClip wheelSound;
    private BufferedImage img;
    private double x_position;
    private double y_position;
    double angle;
    private double muzzleVelocity = 30;
    private int rotationFactor = 1; // changes how easy it is (how fast it is) to rotate cannon.
    private final double HYPOT = 100;

    enum State {
        POSITIONING,
        FIRING,
        FIRED
    }

    public Cannon() {
        fireSound = new SoundClip("media/cannon.wav");
        fireSound.open();
        wheelSound = new SoundClip("media/wheel.wav");
        wheelSound.open();

        // attempt to load the image
        try {
            File imageFile = new File("media/sm_cannon.png");
            img = ImageIO.read(imageFile);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        angle = -45;
    }

    public void setMuzzleVelocity(double muzzleVelocity) {
        this.muzzleVelocity = muzzleVelocity;
    }

    public double getMuzzleVelocity() {
        return muzzleVelocity;
    }

    public double getAngle() {
        return angle;
    }

    public void rotateCounterClockwise() {
        wheelSound.play();
        angle = angle - rotationFactor;
        if (angle < -90) {
            angle = -90;
        }
    }

    public void rotateClockWise() {
        wheelSound.play();
        angle = angle + rotationFactor;
        if (angle > 0) {
            angle = 0;
        }
    }

    public void fire(Cannonball cannonball) {
        fireSound.play();
        double offsetX = Math.cos(Math.toRadians(angle)) * HYPOT;
        double offsetY = Math.sin(Math.toRadians(angle)) * HYPOT;
        double velocityX = Math.cos(Math.toRadians(angle)) * muzzleVelocity;
        double velocityY = Math.sin(Math.toRadians(angle)) * muzzleVelocity;
        cannonball.launch(x_position + offsetX, y_position + offsetY, velocityX, velocityY);
    }

    // sets x position of the ANCHOR.
    public void setXPos(int x_position) {
        this.x_position = x_position;
    }

    // sets y position of the ANCHOR.
    public void setYPos(int y_position) {
        this.y_position = y_position;
    }

    public void draw(Graphics g) {
        int anchorx = 15;
        int anchory = img.getHeight() / 2;

        // cast to Graphics2D and then create affine transform
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform af = new AffineTransform();

        if (img != null) {
            af.translate((x_position - anchorx), (y_position - anchory));
            af.rotate(Math.toRadians(angle), anchorx, anchory);
            g2d.drawImage(img, af, null);
        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
        }

        // use integer values for this part.
        int x_pos = (int) x_position;
        int y_pos = (int) y_position;

        g2d.setColor(Color.PINK);
        g2d.fillPolygon(new int[] { x_pos, x_pos - 45 / 2, x_pos + 45 / 2 },
                new int[] { y_pos, y_pos + 65 / 2, y_pos + 65 / 2 }, 3);
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(new int[] { x_pos, x_pos - 45 / 2, x_pos + 45 / 2 },
                new int[] { y_pos, y_pos + 65 / 2, y_pos + 65 / 2 }, 3);

        int radius = 10;
        g2d.setColor(Color.BLUE);
        g2d.fillOval(x_pos - (radius / 2), y_pos - (radius / 2), radius, radius);

    }

}