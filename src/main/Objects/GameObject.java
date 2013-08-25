
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
    
    //draws object image on the frame
    public void displayObject() {
        imageID = DisplayHandler.disp.drawImage(image, x, y);
    }
    
    //draws object image on the frame and removes the last image of that object
    public void redisplayObject() {
        DisplayHandler.disp.removeImage(imageID);
        imageID = DisplayHandler.disp.drawImage(image, x, y);
    }
    
    //abstract destoy method
    public abstract void destroy();
    
    //initializes the display variables for the objetc
    public void init(){
        miX = x;
        miY = y;
        maX = x + image.getWidth(null);
        maY = y + image.getHeight(null);
    }
    
}
