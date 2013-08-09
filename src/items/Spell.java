/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import display.ImageRetriever;
import javax.swing.ImageIcon;

/**
 *
 * @author Austin
 */
public class Spell extends Item{
    
    int tier;
    Type type;
    
    
    
    
    
    //enumerated spell types
    public enum Type{
        FIRE,WATER,LIGHTNING,LIGHT,DARK
    }
    
    public enum Spll{
        FIRE_BALL(Type.FIRE, new ImageIcon(new ImageRetriever().getImage("/res.spells/Fire Ball.jpg")), 1, 10, 0);
        
        int tier;
        Type type;
        ImageIcon img;
        int attack;
        int defence;
        
        Spll(Type t, ImageIcon im, int mt, int at,int def){
            attack =at;
            defence = def;
            img =im;
            tier= mt;
            type = t;
        }
    }
}
