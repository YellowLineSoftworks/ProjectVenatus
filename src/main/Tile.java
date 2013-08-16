
package main;

import display.DisplayHandler;
import display.Display;
import homestead.MainBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import main.Objects.GameObject;
import display.Display;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Objects.ActivatableObject;
import main.Objects.AttackableObject;


public class Tile implements Serializable{
    
    public List<GameObject> objects = new ArrayList();
    public HashMap location = new HashMap();
    public boolean isMain = false;
    public static Tile currentTile;
    public static List<Tile> allTiles = new ArrayList();
    
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
    
    public Tile(){
        
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
    
    public static boolean setCurrentTile(int x, int y){
        HashMap hm = new HashMap();
        hm.put("xCord", x);
        hm.put("yCord", y);
        for(int i=0;i<allTiles.size();i++){
            if(allTiles.get(i).location.equals(hm)){
                allTiles.get(i).setCurrentTile();
                return true;
            }
        }
        return false;
    }
    public boolean serialize(){
        try {
            FileOutputStream fileout = new FileOutputStream("C:\\Users\\Austin\\Documents\\GitHub\\ProjectVenatus\\src\\main\\Tiles\\tile"+location.get("xCord")+location.get("yCord")+".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(this);
            out.close();
            fileout.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public static Tile deSerialize(int x, int y){
        
        try {
            FileInputStream fileIn = new FileInputStream("C:\\Users\\Austin\\Documents\\GitHub\\ProjectVenatus\\src\\main\\Tiles\\tile"+x+y+".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Tile t = (Tile) in.readObject();
            in.close();
            fileIn.close();
            return t;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
}
