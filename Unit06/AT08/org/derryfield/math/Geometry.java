package org.derryfield.math;

public class Geometry {
    /** METHOD: Finds volume of a sphere. Give the radius. */
    public static double calcVolSphere(double r) {
        double vol = Math.pow(r,3) * 1.333 * Math.PI;
        return vol;
    }

    /** METHOD: Finds surface area of a sphere. Give the radius. */
    public static double calcSurfSphere(double r) {
        double surf = 4 * Math.PI * Math.pow(r, 2);
        return surf;
    }
}
