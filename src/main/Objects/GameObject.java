
package main.Objects;

import display.DisplayHandler;
import display.gui.MainGUI;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import main.ClientEventHandler;
import resources.Sprite;


public abstract class GameObject {
    
    public int x;
    public int y;
    public Sprite image;
    private boolean displayed = false;
    private Image undisplayedImage = null;
    
    public int miX;
    public int miY;
    public int maX;
    public int maY;
    
    public static List<GameObject> objects = getObjects();
    
    public GameObject() {}
    
    public GameObject(Image image, int x, int y, boolean display) {
        if (display) {
            this.x = x;
            this.y = y;
            this.image = DisplayHandler.disp.drawImage(image, x, y);
            displayed = true;
        } else {
            this.x = x;
            this.y = y;
            undisplayedImage = image;
        }
    }
    
    static List<GameObject> getObjects(){
        List<GameObject> finall = new ArrayList();
        return finall;
    }
    
    public void changeImage(Image input) {
        if (image != null) {
            DisplayHandler.disp.removeImage(image.id);
            image = DisplayHandler.disp.drawImage(input, x, y);
        }
    }
    
    public String display() {
        if (displayed) {
            DisplayHandler.disp.removeImage(image.id);
            image = DisplayHandler.disp.drawImage(image.image, x, y);
        } else {
            image = DisplayHandler.disp.drawImage(undisplayedImage, x, y);
            displayed = true;
        }
        return "";
    }
    
    //abstract destroy method
    public abstract void destroy();
    
    //initializes the display variables for the objetc
    public void init(){
        if (image != null) {
            miX = x;
            miY = y;
            maX = x + image.image.getWidth(null);
            maY = y + image.image.getHeight(null);
        } else if (undisplayedImage != null) {
            miX = x;
            miY = y;
            maX = x + undisplayedImage.getWidth(null);
            maY = y + undisplayedImage.getHeight(null);
        } else {
            System.err.println("Error in GameObject.init(): image is null");
            miX = x;
            miY = y;
            maX = x;
            maY = y;
        }
    }
    
}
