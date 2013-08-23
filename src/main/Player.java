
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
import items.ResourceItem;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public int intelligence;
    public int vitality;
    public int dexterity;
    public int level;
    public int experience;
    public int reqXP;
    public int perkPoints;
    public int skillPoints;
    
    public Perk[] classSkills;
    
    public final int reqXP_Level2 = 20;
    public final int reqXP_Level3 = 30;
    public final int reqXP_Level4 = 50;
    public final int reqXP_Level5 = 100;
    
    public Classes cclass;
    public String name;
    
    public List<Perk> skills = new ArrayList();
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
        classSkills = cla.skills;
        switch(cclass){
            case WARRIOR:
                imgup = new ImageRetriever().getImage("/res/Character Sprites/Warrior/Tier3 Warrior Back.png");
                imgdown = new ImageRetriever().getImage("/res/Character Sprites/Warrior/Tier3 Warrior Front.png");
                imgright = new ImageRetriever().getImage("/res/Character Sprites/Warrior/Tier3 Warrior Right.png");
                imgleft = new ImageRetriever().getImage("/res/Character Sprites/Warrior/Tier3 Warrior Left.png");
                break;
            case MAGE:
                imgup = new ImageRetriever().getImage("/res/Character Sprites/Mage/Tier1 Mage Back.png");
                imgdown = new ImageRetriever().getImage("/res/Character Sprites/Mage/Tier1 Mage Front.png");
                imgright = new ImageRetriever().getImage("/res/Character Sprites/Mage/Tier1 Mage Right.png");
                imgleft = new ImageRetriever().getImage("/res/Character Sprites/Mage/Tier1 Mage Left.png");
                break;
            case ROGUE:
                imgup = new ImageRetriever().getImage("/res/Character Sprites/Rouge/Tier1 Rouge Back.png");
                imgdown = new ImageRetriever().getImage("/res/Character Sprites/Rouge/Tier1 Rouge Front.png");
                imgright = new ImageRetriever().getImage("/res/Character Sprites/Rouge/Tier1 Rouge Right.png");
                imgleft = new ImageRetriever().getImage("/res/Character Sprites/Rouge/Tier1 Rouge Left.png");
                break;
                
        }

        
        strength = cla.strength;
        intelligence = cla.intelligence;
        vitality = cla.vitality;
        dexterity = cla.dexterity;
        level = 1;
        experience = 1;
        reqXP = reqXP_Level2;
        
        maxhealth = 100;
        currenthealth = maxhealth;
        
        maxmana = 100;
        currentmana = maxmana;
        test();
        
    }
    
    //Adds a certain amount of xp the total xp and checks to see if the char should level up
    public void addXP(int amountOfXP){
        experience += amountOfXP;
        while(experience > reqXP){
            experience = experience - reqXP;
            switch(level){
                case 1:
                    reqXP = reqXP_Level3;
                    levelUp();
                    break;
                case 2:
                    reqXP = reqXP_Level4;
                    levelUp();
                    break;
                case 3:
                    reqXP = reqXP_Level5;
                    levelUp();
                    break;
                default:
                    levelUp();
                    break;
                    
            }
        }
        HeadsUpDisplay.updateExperience();
    }
    
    private void levelUp(){
        level++;
        skillPoints+=3;
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
        addItem(new ResourceItem(ResourceItem.ResItem.WOOD));
        for(int i = 0; i< items.size(); i++){
            equip(items.get(i));
        }
        for(int i = 0; i< items.size(); i++){
            if(items.get(i).itemtype == Item.Type.WEAPON){
                items.get(i).equip(Item.Buff.FIRE_DAMAGE);
            }
        }
        skillPoints+=10;
        perkPoints+=10;
        
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
    
    public void removeItem(Item i){
        items.remove(i);
    }
    
    //adds a skill to the skill list and invokes the method for said skill
    public void addPerk(Perk s){
        skills.add(s);
        if(s.method!=null){
            try {
                s.method.invoke(this);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    //adds a point to one of the atributes
    public void addAttributePoint(String attribute){
        if(skillPoints > 0){
            skillPoints-=1;
            switch(attribute){
                case "s":
                    strength++;
                    break;
                case "i":
                    intelligence++;
                    break;
                case "v":
                    vitality++;
                    break;
                case "d":
                    dexterity++;
                    break;  
            }
        }
        DisplayHandler.displayStats();
        
    }
    
    //subtract a point to one of the atributes
    public void subtractAttributePoint(String attribute){
        
        switch(attribute){
            case "s":
                if(strength>cclass.strength){
                    strength--;
                    skillPoints++;
                 }
                 break;
            case "i":
                 if(intelligence>cclass.intelligence){
                    intelligence--;
                    skillPoints++;
                 }
                 break;
             case "v":
                 if(vitality>cclass.vitality){
                    vitality--;
                    skillPoints++;
                 }
                 break;
             case "d":
                 if(dexterity>cclass.dexterity){
                    dexterity--;
                    skillPoints++;
                 }
                 break;  
        }
        DisplayHandler.displayStats();
        
    }
    
    public enum Classes{
        MAGE(5,13,7,7, new Perk[]{Perk.HEALTH_BOOST, Perk.HEALTH_REGENERATION}),
        WARRIOR(13,5,7,7, new Perk[]{Perk.HEALTH_BOOST, Perk.HEALTH_REGENERATION}),
        ROGUE(7,7,5,13, new Perk[]{Perk.HEALTH_BOOST, Perk.HEALTH_REGENERATION});
        
        int strength;
        int intelligence;
        int vitality;
        int dexterity;
        Perk[] skills;
        
        Classes(int s, int i, int v, int d, Perk[] sa){
            strength =s;
            intelligence = i;
            vitality = v;
            dexterity = d;
            skills = sa;
        }
    }
    
    public enum Perk{
        HEALTH_REGENERATION("healthRegen", "Slowly regenerates health constantly"), HEALTH_BOOST("healthBoost", "Boost your maximum health statistic");
        
        
        public Method method;
        public Method sMethod;
        public String name;
        public String description;
        Perk(String methodName, String des){
            name = this.name().replace("_", " ").toLowerCase();
            description = des;
            try {
                method = Player.Perk.class.getMethod(methodName);
                sMethod = Player.Perk.class.getMethod("s"+methodName);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        
        void healthRegen(){
            
        }
        void shealthRegen(){
            
        }
        
        void healthBoost(){
            mainchar.maxhealth+=10;
        }
        
        void shealthBoost(){
            mainchar.maxhealth-=10;
        }
        
        
    }
    
}