
package worldobjects;

import display.DisplayHandler;
import display.Display;
import homestead.MainBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import main.Objects.GameObject;
import display.Display;


public class Tile {
    
    public List<GameObject> objects = new ArrayList();
    public HashMap location = new HashMap();
    public boolean isMain = false;
    public static Tile currentTile;
    
    public Tile(int xl, int yl){
        location.put("xCord", xl);
        location.put("yCord", yl);
    }
    public Tile(int xl, int yl, boolean isMain){
        location.put("xCord", xl);
        location.put("yCord", yl);
        this.isMain = isMain;
    }
    
    public Tile(int xl, int yl, List<GameObject> objects){
        location.put("xCord", xl);
        location.put("yCord", yl);
        this.objects = objects;
    }
    
    public Tile(int xl, int yl, boolean isMain, List<GameObject> objects){
        location.put("xCord", xl);
        location.put("yCord", yl);
        this.isMain = isMain;
        this.objects = objects;
    }
    
    public void addObject(GameObject o){
        objects.add(o);
        this.displayAllObjects();
    }
    
    public void removeObject(GameObject o){
        objects.remove(o);
    }
    
    public void displayAllObjects(){
        
        for(int i = 0; i<objects.size(); i++){
            objects.get(i).displayObject();
        }
        if(isMain){
            MainBase.mainbase.displayObject();
        }
    }
    
    public void setCurrentTile(){
        currentTile = this;
        this.displayAllObjects();
    }
}
