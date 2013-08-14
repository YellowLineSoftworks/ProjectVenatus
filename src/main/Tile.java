
package main;

import display.DisplayHandler;
import display.Display;
import homestead.MainBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import main.Objects.GameObject;
import display.Display;
import main.Objects.ActivatableObject;
import main.Objects.AttackableObject;


public class Tile {
    
    public List<GameObject> objects = new ArrayList();
    public HashMap location = new HashMap();
    public boolean isMain = false;
    public static Tile currentTile;
    public static List<Tile> allTiles = new ArrayList();
    
    public List<AttackableObject> attackableObjects = new ArrayList();
    public List<ActivatableObject> activatableObjects = new ArrayList();
    
    public Tile(int xl, int yl){
        location.put("xCord", xl);
        location.put("yCord", yl);
        allTiles.add(this);
    }
    public Tile(int xl, int yl, boolean isMain){
        location.put("xCord", xl);
        location.put("yCord", yl);
        allTiles.add(this);
        this.isMain = isMain;
        objects.add(MainBase.mainbase);
    }
    
    public Tile(int xl, int yl, List<GameObject> objects){
        location.put("xCord", xl);
        location.put("yCord", yl);
        allTiles.add(this);
        this.objects = objects;
    }
    
    public Tile(int xl, int yl, boolean isMain, List<GameObject> objects){
        location.put("xCord", xl);
        location.put("yCord", yl);
        allTiles.add(this);
        this.isMain = isMain;
        this.objects = objects;
        objects.add(MainBase.mainbase);
    }
    
    public void addObject(GameObject o){
        objects.add(o);
        if(o instanceof AttackableObject){
            attackableObjects.add((AttackableObject) o);
        } else if(o instanceof ActivatableObject){
            activatableObjects.add((ActivatableObject) o);
        }
        this.displayAllObjects();
        
        
    }
    
    public void removeObject(GameObject o){
        objects.remove(o);
    }
    
    public void displayAllObjects(){
        for(int i = 0; i<objects.size(); i++){
            objects.get(i).redisplayObject();
        }
        if(isMain){
            MainBase.mainbase.redisplayObject();
        }
    }
    
    public void setCurrentTile(){
        DisplayHandler.disp.resetBufferedImage();
        currentTile = this;
        this.displayAllObjects();
    }
    
    public static boolean setCurrentTile(String direction){
        HashMap loc;
        switch(direction){
            case "up":
                loc = currentTile.location;
                loc.put("yCord", (int)loc.get("yCord")+1);
                break;
            case "down":
                loc = currentTile.location;
                loc.put("yCord", (int)loc.get("yCord")-1);
                break;
            case "right":
                loc = currentTile.location;
                loc.put("xCord", (int)loc.get("xCord")+1);
                break;
            case "left":
                loc = currentTile.location;
                loc.put("xCord", (int)loc.get("xCord")-1);
                break;
            default:
                return false;
        }
        for(int i=0;i<allTiles.size();i++){
            if(allTiles.get(i).location.equals(loc)){
                allTiles.get(i).setCurrentTile();
                return true;
            }
        }
        return false;
    }
    
    
}
