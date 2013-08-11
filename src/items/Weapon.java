/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import display.ImageRetriever;
import javax.swing.ImageIcon;


public class Weapon extends Item{
    //Basic Weapon Variables
    public Type type;
    public int attack;
    public int durability;
    public Weap weapon;
    public int tier;
    
    //Magic Weapon Variables
    public Spell.Type magic_type;
    public int magic_tier;
    
    
    public Weapon(Weap w){ 
        itemtype = Item.Type.WEAPON;
        type = w.type;
        img = w.img;
        attack = w.attack;
        durability = w.durability;
        name = w.name().replaceAll("_", " ").toLowerCase();
        weapon = w;
        tier = w.tier;
    }
    
    public Weapon(MagicWeap mw){
        itemtype = Item.Type.WEAPON;
        attack  = mw.base_attack;
        durability = mw.durability;
        magic_type = mw.spell_type;
        img = mw.img;
        name = mw.name().replaceAll("_", " ").toLowerCase();
        magic_tier = mw.magic_tier;
    }
    
    //returns a display string for the gui
    @Override
    public String display() {
        String finals = super.display() + "  Attack: " + attack + "\n\n  Durability: " + durability;
        String types = "";
        if(type != null){
            types+= "\n\n Type: " + type;
        }
        if(magic_type != null){
            types+= "\n\n Magic Type: " + magic_type;
        }
        
        return finals + types;
             
    }
    
    //equips a buff to the weapon
    @Override
    public void equip(Buff b){
        super.equip(b);
        attack += b.damage;
    }
    
    //enumerated weapon types
    public enum Type{
        BROADAXE,SWORD,DAGGER,BOW,SPEAR,HANDAXE,CLUB,
    }
    
    

    //enumerated weapons
    public enum Weap{
        GREAT_SWORD(7, 250, new ImageIcon(new ImageRetriever().getImage("/res/Items/Weapons/Iron Sword.jpg")), Type.SWORD,1),
        LONG_SWORD(7, 250, new ImageIcon(new ImageRetriever().getImage("/res/Items/Weapons/Iron Sword.jpg")), Type.SWORD,1),
        SHORT_BOW(5, 300, new ImageIcon(new ImageRetriever().getImage("/res/Items/Weapons/Wooden Bow.png")), Type.BOW, 1);
        
        Type type;
        ImageIcon img;
        int attack;
        int durability;
        int tier;
        Weap(int at, int dur, ImageIcon im,Type t, int tr){
            type = t;
            img = im;
            attack = at;
            durability = dur;
            tier = tr;
        }
    }
    
    public enum MagicWeap{
        FIRE_ROD(5, 100,new ImageIcon(new ImageRetriever().getImage("/res/Items/Weapons/Fire Rod.jpg")), Spell.Type.FIRE, 1);
        
        
        
        
        int base_attack;
        ImageIcon img;
        Spell.Type spell_type;
        int durability;
        Type type;
        int magic_tier;
        MagicWeap(int b_at, int dur, ImageIcon im, Spell.Type st, int mt){
            img = im;
            base_attack=b_at;
            spell_type = st;
            durability = dur;
            magic_tier = mt;
        }
        
        MagicWeap(int b_at, int dur, ImageIcon im, Spell.Type st, Type t, int mt){
            img = im;
            base_attack=b_at;
            spell_type = st;
            durability = dur;
            magic_tier = mt;
        }
        
    }
    
}




