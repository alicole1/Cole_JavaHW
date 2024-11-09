// Ali Cole AT Java
// AT HW 07: Writing a Class
// Part B

import java.util.Scanner;

class Point {
    Scanner scan = new Scanner(System.in);
    double x;
    double y;
    double r;
    double a;

    public Point() {
        x = 0;
        y = 0;
        toPolar(x, y);
    }

    void toPolar(double currX, double currY) {
        r = Math.sqrt(x*x + y*y);
        a = Math.atan2(y,x) * (180 / Math.PI);
    }

    public void setCartPoints() {
        System.out.print("Set x value: ");
        x = scan.nextDouble();
        System.out.print("Set y value: ");
        y = scan.nextDouble();
        toPolar(x,y);
    }

    public void translate(double distX, double distY) {
        x = x + distX;
        y = y + distY;
        toPolar(x, y);
    }

    public double distanceTo(double newX, double newY) {
        double distance = Math.sqrt((newX-x)*(newX-x) + (newY-y)*(newY-y));
        return distance;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public double getA() {
        return a;
    }
}

public class PartB {
    public static void main(String[] args) {
        Point point = new Point();
        Scanner scan = new Scanner(System.in);
        Scanner doublescanner = new Scanner(System.in);
        double x = point.getX();
        double y = point.getY();
        double r = point.getR();
        double a = point.getA();
        String input = "";
        do {
            System.out.print("Input 'v' to view current coordinates, 's' to set values for your point, 't' to translate, 'd' to find distance between your point and another, and 'q' to quit: ");
            input = scan.nextLine().toLowerCase();

            if (input.equals("v")) {
                System.out.printf("Your cartesian coordinates are: ( %.2f , %.2f )%n",x,y);
                System.out.printf("Your polar coordinates are:     ( %.2f , %.2f )%n",r,a);  
            } else if (input.equals("s")) {
                point.setCartPoints();
                x = point.getX();
                y = point.getY();
                r = point.getR();
                a = point.getA();
                System.out.printf("Your cartesian coordinates are: ( %.2f , %.2f )%n",x,y);
                System.out.printf("Your polar coordinates are:     ( %.2f , %.2f )%n",r,a);
            } else if (input.equals("t")) {
                System.out.print("Translation in x direction: ");
                double distX = doublescanner.nextDouble();
                System.out.print("Translation in y direction: ");
                double distY = doublescanner.nextDouble();
                point.translate(distX, distY);
                x = point.getX();
                y = point.getY();
                r = point.getR();
                a = point.getA();
                System.out.printf("Your new cartesian coordinates are: ( %.2f , %.2f )%n", x, y);
                System.out.printf("Your new polar coordinates are:     ( %.2f , %.2f )%n", r, a);
            } else if (input.equals("d")) {
                System.out.print("New point x val: ");
                double newX = doublescanner.nextDouble();
                System.out.print("New point y val: ");
                double newY = doublescanner.nextDouble();
                double dist = point.distanceTo(newX,newY);
                System.out.printf("The distance from point ( %.2f , %.2f ) to ( %.2f , %.2f ) is %.2f%n", x, y, newX, newY, dist);
            }
        } while (! input.equals("q"));   
    scan.close();
    doublescanner.close(); 
    }
}