/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main.Objects;

import display.DisplayHandler;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import main.Tile;


public abstract class AttackableObject extends GameObject {
    
    public static List<AttackableObject> attackableObjects = new ArrayList();
    public int health;
    public int armor;
    
    public AttackableObject() {
        attackableObjects.add(this);
    }
    
    public AttackableObject(Image image, int x, int y, boolean display) {
        super(image, x, y, display);
        attackableObjects.add(this);
    }
    
    public int calculateDamageTaken(int armor) {
        
        //To Do: Implement a function here to calculate damage dealt based on the player's wielded items and their strength, etc.
        //Right now, it just returns 10 as a flat damage rate.
        return 10;
        
    }
    
    //Gets rid of a attackable object
    @Override
    public void destroy(){
        attackableObjects.remove(this);
        Tile.currentTile.objects.remove(this);
        DisplayHandler.disp.removeImage(image.id);
    }
    
    //method is called when the player presses A in front of this object
    public void attacked(){
        health -= calculateDamageTaken(armor);
        if (health <= 0) {
            destroy();
        }
    }

}
