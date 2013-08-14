
package main.Objects;

import display.DisplayHandler;
import java.util.ArrayList;
import java.util.List;
import main.Objects.GameObject;
import main.Tile;


public abstract class ActivatableObject extends GameObject{
    public static List<ActivatableObject> activatableObjects = new ArrayList();
    
    
    public ActivatableObject(){
        activatableObjects.add(this);
    }
    
    
    
    
    public abstract void activate();
    @Override
    public void destroy(){
        activatableObjects.remove(this);
        Tile.currentTile.removeObject(this);
        DisplayHandler.disp.removeImage(imageID);
    }
    
}
