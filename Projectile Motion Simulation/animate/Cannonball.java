package animate;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Cannonball {
    public enum STATE {
        IDLE,
        FLYING,
        EXPLODING
    }

    BufferedImage img;

    STATE currState = STATE.IDLE;
    double x;
    double y;
    double ground;
    double vx;
    double vy;
    double ax;
    double ay;
    double timeScale;

    final int BOARD_SCALE = 256; // pixels per meter
    final int TIMER_INTERVAL = 20; // milliseconds per timer interval
    final int G_BOARD = 1; // acceleration due to gravity in pixels per timer interval ^ 2
    final int MUZZLE_VELOCITY = 37; // pixels per timer interval

    public Cannonball(double ax, double ay, double ground) {
        // public constructor for CannonBall class.
        // takes the acceleration rates (x and y) and the location of the ground (as a
        // double)
        // as arguments
        this.ax = ax;
        this.ay = ay;
        this.ground = ground;
    }

    private BufferedImage loadImage(String path) {
        // loads a buffered image (for the flame animation).
        try {
            File imageFile = new File("path");
            img = ImageIO.read(imageFile);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return img;
    }

    /*
     * The draw method is called by the Board object
     * and is used to paint the current location and state of the ball.
     * If the ball is flying through the air, the ball is drawn as a red
     * filled in circle. If the ball is in the exploded state, a flame image is
     * drawn. If the ball is idle, then the ball is not drawn at all
     * (since we assume the ball is hidden inside the cannon).
     */
    public void draw(Graphics2D g2d) {
        if (currState == STATE.FLYING) {
            g2d.fillOval((int) x - 3, (int) y - 3, 6, 6);
        } else if (currState == STATE.EXPLODING) {
            g2d.translate(x, ground);
            g2d.drawImage(img, null, null);
        }
    }

    /*
     * The updateBall() method uses the constant acceleration equations
     * to update the velocity and position of the ball each timer interval.
     * note that when calculating the new velocity, the acceleration term is divided
     * by the
     * time scale in case the user wants to slow down the animation.
     * Similarly, when calculating the new position, the velocity term is divided by
     * the time scale
     * in case the user wants to slow down the animation.
     */
    public void updateBall() {
        if (currState == STATE.FLYING) {
            x = x + (vx / timeScale);
            vy = vy + (ay / timeScale);
            y = y + (vy / timeScale);
        }

        if (y > ground) {
            currState = STATE.EXPLODING;
        }
    }

    /*
     * If the ball is not flying through the air, the launch() method
     * will change the state to FLYING and start the ball moving from position (x,y)
     * with the inital velocity of (vx, vy).
     */
    public void launch(double x, double y, double vx, double vy) {
    }

    /*
     * Get/set methods for the private member variables.
     */
    public STATE getState() {
        return currState;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getVX() {
        return vx;
    }

    public double getVY() {
        return vy;
    }

    public double getAX() {
        return ax;
    }

    public double getAY() {
        return ay;
    }

    public double getTimeScale() {
        return timeScale;
    }

    public double getGround() {
        return ground;
    }

    public void setState(STATE newState) {
        currState = newState;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setVX(double vx) {
        this.vx = vx;
    }

    public void setVY(double vy) {
        this.vy = vy;
    }

    public void setAX(double ax) {
        this.ax = ax;
    }

    public void setAY(double ay) {
        this.ay = ay;
    }

    public void setTimeScale(double timeScale) {
        this.timeScale = timeScale;
    }

    public void changeTimeScale(double delta) {

    }

    public void setGround(double ground) {
        this.ground = ground;
    }

}