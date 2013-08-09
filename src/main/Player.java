
package main;

import items.Weapon;
import items.Shield;
import items.Item;
import java.util.List;
import java.util.ArrayList;
import items.Armor;
import java.awt.Image;
import display.ImageRetriever;
import items.Consumeable;
import display.DisplayHandler;

public class Player {
    public int maxhealth;
    public int currenthealth;
    public int maxmana;
    public int currentmana;
    
    public Image imgup;
    public Image imgdown;
    public Image imgright;
    public Image imgleft;
    public String currentDirection = "up";
    public String currentDirectionDupe = "up";
    public String playerName;
    
    public int strength;
    public int intellegence;
    public int vitality;
    public int dexterity;
    
    public Classes cclass;
    
    public String name;
    
    public List<Item> items = new ArrayList();
    
   
    public Shield right_hand_item;
    public Weapon left_hand_item;
    public Armor head_piece;
    public Armor pants;
    public Armor boots;
    public Armor chest_piece;
    public Item ring1;
    public Item ring2;
    
    public Consumeable con1;
    public Consumeable con2;
    public Consumeable con3;
    public Consumeable con4;
    
    public static Player mainchar;
    
    public Player(String na, Classes cla){
        name = na;
        cclass = cla;
        imgup = new ImageRetriever().getImage("/res/Character Sprites/Tier3 Warrior Back.png");
        imgdown = new ImageRetriever().getImage("/res/Character Sprites/Tier3 Warrior Front.png");
        imgright = new ImageRetriever().getImage("/res/Character Sprites/Tier3 Warrior Right.png");
        imgleft = new ImageRetriever().getImage("/res/Character Sprites/Tier3 Warrior Left.png");
        test();
        
        strength = cla.strength;
        intellegence = cla.intelegence;
        vitality = cla.vitality;
        dexterity = cla.dexterity;
        
        maxhealth = 100;
        currenthealth = maxhealth;
        
        maxmana = 100;
        currentmana = maxmana;
        
    }
    
    public void test(){
        addItem(new Weapon(Weapon.Weap.GREAT_SWORD));
        addItem(new Shield(Shield.Shld.WOOD_SHIELD));
        addItem(new Armor(Armor.Armr.IRON_BOOTS));
        addItem(new Armor(Armor.Armr.IRON_LEGGINGS));
        addItem(new Armor(Armor.Armr.IRON_HELMET));
        addItem(new Armor(Armor.Armr.IRON_PLATE_BODY));
        addItem(new Weapon(Weapon.Weap.SHORT_BOW));
        addItem(new Armor(Armor.Armr.RED_MAGE_ROBES));
        addItem(new Armor(Armor.Armr.RED_MAGE_COWL));
        addItem(new Armor(Armor.Armr.LIGHT_MAGE_ROBES));
        addItem(new Armor(Armor.Armr.LIGHT_MAGE_COWL));
        addItem(new Consumeable(Consumeable.Cnsm.POTION));
        addItem(new Shield(Shield.MagicShld.SHIELD_OF_LIGHT));
        addItem(new Weapon(Weapon.MagicWeap.FIRE_ROD));
        for(int i = 0; i< items.size(); i++){
            equip(items.get(i));
        }
        for(int i = 0; i< items.size(); i++){
            if(items.get(i).itemtype == Item.Type.WEAPON){
                items.get(i).equip(Item.Buff.FIRE_DAMAGE);
            }
        }
        
    }
    
    public void equip(Item i){
        switch(i.itemtype){
            case WEAPON:
                left_hand_item = (Weapon) i;
                break;
            case SHIELD:
                right_hand_item = (Shield) i;
                
                break;
            case ARMOR:
                Armor a = (Armor)i;
                switch(a.type){
                    case BOOTS:
                        boots = a;
                        break;
                    case LEGS:
                        pants = a;
                        break;
                    case HEAD:
                        head_piece = a;
                        break;
                    case TORSO:
                        chest_piece = a;
                        break;
                
                }
                break;
            case CONSUMEABLE:
                switch(DisplayHandler.selectedConsumeableSlot){
                    case 1:
                        con1 = (Consumeable) i;
                        break;
                    case 2:
                        con2 = (Consumeable) i;
                        break;
                    case 3:
                        con3 = (Consumeable) i;
                        break;
                    case 4:
                        con4 = (Consumeable) i;
                        break;
                }
                System.out.println();
                break;
                
        }
    }
    
    public void addItem(Item i){
        items.add(i);
    }
    
    public enum Classes{
        MAGE(5,13,7,7),
        WARRIOR(13,5,7,7),
        ROGUE(7,7,5,13);
        
        int strength;
        int intelegence;
        int vitality;
        int dexterity;
        
        Classes(int s, int i, int v, int d){
            strength =s;
            intelegence = i;
            vitality = v;
            dexterity = d;
        }
    }
}