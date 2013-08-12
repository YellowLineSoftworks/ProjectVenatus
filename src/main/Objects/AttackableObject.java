/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main.Objects;

import display.DisplayHandler;
import java.util.ArrayList;
import java.util.List;
import worldobjects.Tile;

/**
 * @author Xenith
 */
public abstract class AttackableObject extends GameObject {
    
    public static List<AttackableObject> attackableObjects = new ArrayList();
    public int health;
    public int armor;
    
    public int calculateDamageTaken(int armor) {
        
        //To Do: Implement a function here to calculate damage dealt based on the player's wielded items and their strength, etc.
        //Right now, it just returns 10 as a flat damage rate.
        return 10;
        
    }
    
    public AttackableObject() {
        attackableObjects.add(this);
    }
    
    @Override
    public void destroy(){
        attackableObjects.remove(this);
        Tile.currentTile.objects.remove(this);
        Tile.currentTile.displayAllObjects();
    }
    
    public void attacked(){
        health -= calculateDamageTaken(armor);
        if (health <= 0) {
            destroy();
        }
    }

}
