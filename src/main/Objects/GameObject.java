
package main.Objects;

import display.DisplayHandler;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import main.ClientEventHandler;


public abstract class GameObject {
    
    public int x;
    public int y;
    public Image image;
    public int imageID = -1;
    
    public int miX;
    public int miY;
    public int maX;
    public int maY;
    
    public static List<GameObject> objects = getObjects();
    
    static List<GameObject> getObjects(){
        List<GameObject> finall = new ArrayList();
        return finall;
    }
    
    public void displayObject() {
        imageID = DisplayHandler.disp.drawImage(image, x, y);
    }
    
    public void redisplayObject() {
        DisplayHandler.disp.removeImage(imageID);
        imageID = DisplayHandler.disp.drawImage(image, x, y);
    }
    
    public abstract void destroy();
    
    public void init(){
        miX = x;
        miY = y;
        maX = x + image.getWidth(null);
        maY = y + image.getHeight(null);
    }
    
}
