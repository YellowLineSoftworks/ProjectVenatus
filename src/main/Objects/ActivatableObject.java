
package main.Objects;

import display.DisplayHandler;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import main.Objects.GameObject;
import main.Tile;


public abstract class ActivatableObject extends GameObject{
    
    
    public ActivatableObject(){
        //activatableObjects.add(this);
    }
    
    public ActivatableObject(Image i, int x, int y, boolean display) {
        super(i, x, y, display);
    }
    
    //abstract activate method thats called when the object is activated
    public abstract void activate();
    
    
    @Override
    public void destroy(){
        Tile.currentTile.removeObject(this);
        DisplayHandler.disp.removeImage(image.id);
    }
    
}
