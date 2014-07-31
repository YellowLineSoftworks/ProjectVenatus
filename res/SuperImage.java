package res;

/**
 * @version 1.8 Alpha
 * @author YellowLineSoftworks
 */

import java.awt.Image;
import display.ImageRetriever;

public class SuperImage {
    
    public Image image;
    public int dispx;
    public int dispy;
    public int endx;
    public int endy;
    public int startx;
    public int starty;
    public int originalX;
    public int originalY;
    public int number;
    private static int curId;
    public int id;
    
    public SuperImage(Image i2, int x2, int y2) {
        
        id = curId;
        curId++;
        image = i2;
        startx = 0;
        starty = 0;
        endx = image.getWidth(null);
        endy = image.getHeight(null);
        dispx = x2;
        dispy = y2;
        originalX = dispx;
        originalY = dispy;
        
    }
    
    public SuperImage(Image i2, int startx1, int starty1, int endx1, int endy1, int dispx, int dispy) {
        
        image = i2;
        this.dispx = dispx;
        this.dispy = dispy;
        startx = startx1;
        starty = starty1;
        endx = endx1;
        endy = endy1;
        
    }
    
}
