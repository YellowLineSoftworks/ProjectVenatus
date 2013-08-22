package main;

import java.awt.Point;

/**
 * @author Xenith
 */
public class Macro {

    
    
    //Test if a given number is within two other numbers
    public static boolean within(int test, int n1, int n2) {
        if (test >= n1 && test <= n2) {
            return true;
        } else if (test >= n2 && test <= n1) {
            return true;
        }
        return false;
    }
    
    //Find the center of a square
    public static Point center (int maX, int miX, int maY, int miY) {
        int x = (maX + miX)/2;
        int y = (maY + miY)/2;
        return new Point(x, y);
    }

}
