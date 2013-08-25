

package worldobjects.Enemies;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import main.Objects.AttackableObject;


public class Enemy extends AttackableObject{
    public int health;
    public Image img;
    public String name;
    public Type type;
    
    public static List<Enemy> enemies = new ArrayList();
    
    
    public enum Type{
        STAGNANT
    }
    
}
