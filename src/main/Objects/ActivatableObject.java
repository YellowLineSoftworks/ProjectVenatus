
package main.Objects;

import display.DisplayHandler;
import java.util.ArrayList;
import java.util.List;
import main.Objects.GameObject;
import main.Tile;


public abstract class ActivatableObject extends GameObject{
    
    
    public ActivatableObject(){
        //activatableObjects.add(this);
    }
    
    
    
    //abstract activate method thats called when the object is activated
    public abstract void activate();
    
    
    @Override
    public void destroy(){
        Tile.currentTile.removeObject(this);
        DisplayHandler.disp.removeImage(imageID);
    }
    
}
