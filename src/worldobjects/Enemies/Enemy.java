

package worldobjects.Enemies;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public class Enemy {
    public int health;
    public Image img;
    public String name;
    public Type type;
    
    public static List<Enemy> enemies = new ArrayList();
    
    public void attacked(){
        health -= main.Player.mainchar.strength+main.Player.mainchar.left_hand_item.attack;
    }
    
    public enum Type{
        STAGNANT,RANGED,MELEE
    }
    
}
