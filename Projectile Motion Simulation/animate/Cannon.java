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
    private double muzzleVelocity;
    private int rotationFactor = 1; // changes how easy it is (how fast it is) to rotate cannon.
    private final double HYPOT = 100;

    Cannonball cannonball = new Cannonball(1, -1, 0);

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

    public void fire() {
        fireSound.play();
    }

    // sets x position of the ANCHOR.
    public void setXPos(int x_position) {
        this.x_position = x_position;
    }

    // sets y position of the ANCHOR.
    public void setYPos(int y_position) {
        this.y_position = y_position;
    }

    public double startCannonBallXPos() {
        double offset = Math.cos(Math.toRadians(angle)) * HYPOT;
        return x_position + offset;
    }

    public double startCannonBallYPos() {
        double offset = Math.sin(Math.toRadians(angle)) * HYPOT;
        return y_position - offset;
    }

    public void draw(Graphics g) {
        int anchorx = 15;
        int anchory = img.getHeight() / 2;

        // cast to Graphics2D and then create affine transform
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform af = new AffineTransform();

        if (img != null) {
            af.rotate(Math.toRadians(angle), anchorx, anchory);
            g2d.translate((x_position - anchorx), (y_position - anchory));
            g2d.drawImage(img, af, null);
        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
        }

        g2d.setColor(Color.PINK);
        g2d.fillPolygon(new int[] { -15, 15, 45 }, new int[] { 65, anchory, 65 }, 3);
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(new int[] { -15, 15, 45 }, new int[] { 65, anchory, 65 }, 3);

        int radius = 10;
        g2d.setColor(Color.BLUE);
        g2d.fillOval(anchorx - (radius / 2), anchory - (radius / 2), radius, radius);
    }

}