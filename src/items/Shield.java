/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import display.ImageRetriever;
import javax.swing.ImageIcon;


public class Shield extends Item{
    public int durability;
    public int base_defence;
    public Spell.Type magicType = null;
    
    public Shield(Shld s){
        itemtype = Item.Type.SHIELD;
        base_defence = s.base_defence;
        name = s.name().replaceAll("_", " ").toLowerCase();
        durability = s.durability;
        img = s.img;
        System.out.println();
    }
    
    public Shield(MagicShld s){
        itemtype = Item.Type.SHIELD;
        base_defence = s.base_defence;
        name = s.name().replaceAll("_", " ").toLowerCase();
        durability = s.durability;
        img = s.img;
        magicType = s.spell_type;
        System.out.println();
    }
    
    @Override
    public String display() {
        return super.display() + "\n  Block: " + base_defence + "\n\n  Durability: " + durability;
             
    }

    @Override
    public void equip(Buff b) {
        super.equip(b); 
        base_defence+=b.defence;
        
    }
    
    
    
    public enum Shld{
        WOOD_SHIELD(15,100, new ImageIcon(new ImageRetriever().getImage("/res/Items/Shields/Wood Shield.jpg")));
        
        int durability;
        ImageIcon img;
        int base_defence;
        Shld(int b_def, int dur, ImageIcon i){
            durability = dur;
            base_defence =b_def;
            img = i;
        }
    }
     public enum MagicShld{
        SHIELD_OF_LIGHT(25, 100, new ImageIcon(new ImageRetriever().getImage("/res/Items/Shields/Light Shield.jpg")), Spell.Type.LIGHT, 3);
        
        
        
        
        int base_defence;
        ImageIcon img;
        Spell.Type spell_type;
        int durability;
        Type type;
        int magic_tier;
        MagicShld(int b_def, int dur, ImageIcon im, Spell.Type st, int mt){
            img = im;
            base_defence=b_def;
            spell_type = st;
            durability = dur;
            magic_tier = mt;
        }
        
        MagicShld(int b_def, int dur, ImageIcon im, Spell.Type st, Type t, int mt){
            img = im;
            base_defence=b_def;
            spell_type = st;
            durability = dur;
            magic_tier = mt;
        }
     }  
}
