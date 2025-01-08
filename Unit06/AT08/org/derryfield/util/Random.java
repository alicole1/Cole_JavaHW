package org.derryfield.util;

public class Random {
    public static int getRandomInteger(int upper) {
        // generates a random int from 1 to upper.
        double r = Math.random() * upper;
        int val = (int) r + 1;
        return val;
    }
}
