
package items;

import display.ImageRetriever;
import javax.swing.ImageIcon;


public class Armor extends Item{
    int defence;
    public Type type;
    int durability;
    
    public Armor(Armr a){
        itemtype = Item.Type.ARMOR;
        name = a.name().replaceAll("_", " ").toLowerCase();
        type = a.type;
        defence = a.defence;
        durability = a.durability;
        img = a.img;
    }
    
    @Override
    public String display() {
        return super.display() + "\n  Block: " + defence + "\n\n  Durability: " + durability;
             
    }
    
    @Override
    public void equip(Buff b) {
        super.equip(b); 
        defence+=b.defence;
        
    }
    
    
    public enum Armr{
        
        IRON_BOOTS(3, Type.BOOTS, 100, new ImageIcon(new ImageRetriever().getImage("/res/Items/Armor/Warrior/Iron/Iron Boot.jpg"))),
        IRON_LEGGINGS(5, Type.LEGS, 100, new ImageIcon(new ImageRetriever().getImage("/res/Items/Armor/Warrior/Iron/Iron Leggings.jpg"))),
        IRON_HELMET(5, Type.HEAD, 100, new ImageIcon(new ImageRetriever().getImage("/res/Items/Armor/Warrior/Iron/Iron Helmet.jpg"))),
        IRON_PLATE_BODY(10, Type.TORSO, 100, new ImageIcon(new ImageRetriever().getImage("/res/Items/Armor/Warrior/Iron/Iron Armor.jpg"))),
        
        
        //Basic mage armor tier 1
        RED_MAGE_BOOTS(1, Type.TORSO, 100,new ImageIcon(new ImageRetriever().getImage("/res/Items/Armor/Warrior/Iron/Iron Boot.jpg"))),
        RED_MAGE_COWL(3, Type.HEAD, 100,new ImageIcon(new ImageRetriever().getImage("/res/Items/Armor/Mage/Red/Mage Cowl.jpg"))),
        RED_MAGE_BRACERS(3, Type.LEGS, 100,new ImageIcon(new ImageRetriever().getImage("/res/Items/Armor/Warrior/Iron/Iron Leggings.jpg"))),
        RED_MAGE_ROBES(5, Type.TORSO, 100,new ImageIcon(new ImageRetriever().getImage("/res/Items/Armor/Mage/Red/Mage Robes.jpg"))),
        
        LIGHT_MAGE_COWL(5, Type.HEAD, 100, new ImageIcon(new ImageRetriever().getImage("/res/Items/Armor/Mage/Light//Light Cowl.jpg"))),
        LIGHT_MAGE_ROBES(10, Type.TORSO, 100, new ImageIcon(new ImageRetriever().getImage("/res/Items/Armor/Mage/Light/Light Mage Robes.jpg")));
        
        int defence;
        Type type;
        int durability;
        ImageIcon img;
                
        Armr( int def, Type t, int dur, ImageIcon i){
            defence = def;
            type = t;
            durability = dur;
            img = i;
        }
    }
    
    public enum Type{
        BOOTS,TORSO,LEGS,HEAD
    }
}
