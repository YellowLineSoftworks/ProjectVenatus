    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import display.gui.MainGUI;
import homestead.MainBase;
import items.Item;
import java.util.ArrayList;
import java.util.List;
import items.Armor;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import main.Player;
import homestead.AddOn;
import java.awt.Image;
import javax.swing.ImageIcon;
import worldobjects.Tile;





public class DisplayHandler {
    
    public static List<Item> currentItemListDisplay = new ArrayList();
    public static List<AddOn> currentAddonListDisplay = new ArrayList();
    MainGUI gui = new MainGUI();
    public static Display fb = new Display();
    public static int charx = 200;
    public static int chary = 200;
    
    public static int imgupID = 0;
    public static int imgdownID = 0;
    public static int imgrightID = 0;
    public static int imgleftID = 0;
    
    public static int selectedConsumeableSlot = 1;
    
    public static Image weapUp = new ImageRetriever().getImage("/res/Character Sprites/Weapon Sprites/Iron Sword Up.png");
    public static Image weapDown= new ImageRetriever().getImage("/res/Character Sprites/Weapon Sprites/Iron Sword Down.png");
    public static Image weapRight= new ImageRetriever().getImage("/res/Character Sprites/Weapon Sprites/Iron Sword Right.png");
    public static Image weapLeft= new ImageRetriever().getImage("/res/Character Sprites/Weapon Sprites/Iron Sword Left.png");
    
    
    public static Image weaponSprite;
    
    public static void initDisplay(){
        fb.drawImage(Player.mainchar.imgup, charx, chary);
        
        MainGUI.MainTabbedPane.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("LEFT"), "none");
        MainGUI.MainTabbedPane.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("RIGHT"), "none");
        KeyListen keylistener = new KeyListen();
        MainGUI.MainTabbedPane.addKeyListener(keylistener);
        resourceInfoDisplayer();
        DisplayHandler.displayAllInvinImages();
        int delay = 1000;  //milliseconds
    }
    
    public static void moveCharacter(String direction){
        if(KeyListen.isAttacking){
            //displayWeapon(true);
        }
        if (!direction.equals(Player.mainchar.currentDirectionDupe)) {
        switch(Player.mainchar.currentDirectionDupe){
            case "up":
                fb.removeImage(imgupID);
                break;
            case "down":
                fb.removeImage(imgdownID);
                break;
            case "right":
                fb.removeImage(imgrightID);
                break;
           case "left":
                fb.removeImage(imgleftID);
                break;
        }
        switch(direction){
            case "up":
                Player.mainchar.currentDirectionDupe = "up";
                chary -=1;
                imgupID = fb.drawImage(Player.mainchar.imgup, charx, chary);
                break;
            case "down":
                Player.mainchar.currentDirectionDupe = "down";
                chary +=1;
                imgdownID = fb.drawImage(Player.mainchar.imgdown, charx, chary);
                break;
            case "right":
                Player.mainchar.currentDirectionDupe = "right";
                charx+=1;
                imgrightID = fb.drawImage(Player.mainchar.imgright, charx, chary);
                break;
           case "left":
                Player.mainchar.currentDirectionDupe = "left";
                charx-=1;
                imgleftID = fb.drawImage(Player.mainchar.imgleft, charx, chary);
                break;
        }
        } else {
            switch(direction){
                case "up":
                    chary -=1;
                    fb.moveImage(imgupID, charx, chary);
                    break;
                case "down":
                    chary +=1;
                    fb.moveImage(imgdownID, charx, chary);
                    break;
                case "right":
                    charx+=1;
                    fb.moveImage(imgrightID, charx, chary);
                    break;
               case "left":
                    charx-=1;
                    fb.moveImage(imgleftID, charx, chary);
                    break;
            }
        }
    }
    
    public static void itemListPrinter(Item.Type t){
        
        currentItemListDisplay.clear();
        MainGUI.itemListModel.removeAllElements();
        for(int i = 0; i<Player.mainchar.items.size(); i++){
            if(Player.mainchar.items.get(i).itemtype == t){
                
            MainGUI.itemListModel.addElement(Player.mainchar.items.get(i).name);
            currentItemListDisplay.add(Player.mainchar.items.get(i));
                
            }
        }     
    }
    
    public static void itemListPrinter(Armor.Type at){
        currentItemListDisplay.clear();
        MainGUI.itemListModel.removeAllElements();
        for(int i = 0; i<Player.mainchar.items.size(); i++){
            if(Player.mainchar.items.get(i).itemtype == Item.Type.ARMOR){
                Armor armor = (Armor)Player.mainchar.items.get(i);
                if(armor.type == at){
                    MainGUI.itemListModel.addElement(Player.mainchar.items.get(i).name);
                    currentItemListDisplay.add(Player.mainchar.items.get(i));
                }
            
                
            }
        } 
    }
    
    public static void itemListPrinter(int consumeableslot){
        currentItemListDisplay.clear();
        MainGUI.itemListModel.removeAllElements();
        selectedConsumeableSlot = consumeableslot;
        
        for(int i = 0; i<Player.mainchar.items.size(); i++){
            if(Player.mainchar.items.get(i).itemtype == Item.Type.CONSUMEABLE){
                
            MainGUI.itemListModel.addElement(Player.mainchar.items.get(i).name);
            currentItemListDisplay.add(Player.mainchar.items.get(i));
                
            }
        }
    }
    
    public static void addonListPrinter(){
        currentAddonListDisplay.clear();
        MainGUI.addonListModel.removeAllElements();
        MainGUI.addonListModel.addElement("Main Base");
        for(int i =0;i<MainBase.mainbase.addons.size();i++){
            MainGUI.addonListModel.addElement(MainBase.mainbase.addons.get(i).name);
            currentAddonListDisplay.add(MainBase.mainbase.addons.get(i));
        }
    }
    
    public static void displayAllInvinImages() {
        MainGUI.lHandPic.setText("");
        MainGUI.rHandPic.setText("");
        MainGUI.lBootPic.setText("");
        MainGUI.rBootPic.setText("");
        MainGUI.leggingsPic.setText("");
        MainGUI.headPic.setText("");
        MainGUI.torsoPic.setText("");
        MainGUI.Con1Pic.setText("");
        MainGUI.Con3Pic.setText("");
        MainGUI.Con2Pic.setText("");
        MainGUI.Con4Pic.setText("");
        
        
        MainGUI.lHandPic.setIcon(Player.mainchar.left_hand_item.img);
        MainGUI.rHandPic.setIcon(Player.mainchar.right_hand_item.img);
        MainGUI.lBootPic.setIcon(Player.mainchar.boots.img);
        MainGUI.rBootPic.setIcon(Player.mainchar.boots.img);
        MainGUI.leggingsPic.setIcon(Player.mainchar.pants.img);
        MainGUI.torsoPic.setIcon(Player.mainchar.chest_piece.img);
        MainGUI.headPic.setIcon(Player.mainchar.head_piece.img);
        if(Player.mainchar.con1!=null){
            MainGUI.Con1Pic.setIcon(Player.mainchar.con1.img);
        }
        if(Player.mainchar.con2!=null){
            MainGUI.Con3Pic.setIcon(Player.mainchar.con2.img);
        }
        if(Player.mainchar.con2!=null){
            MainGUI.Con2Pic.setIcon(Player.mainchar.con3.img);
        }
        if(Player.mainchar.con4!=null){
            MainGUI.Con4Pic.setIcon(Player.mainchar.con4.img);
        }
        
    }
    
    public static void itemInfoPrinter(){
        int index = MainGUI.itemList.getSelectedIndex();
        if(index!= -1){
             MainGUI.itemDisplay.setText(currentItemListDisplay.get(index).display());
             Player.mainchar.equip(currentItemListDisplay.get(index));
             Item.Type t = currentItemListDisplay.get(index).itemtype;
             switch(t){
                case WEAPON:
                    MainGUI.lHandPic.setText("");
                    MainGUI.lHandPic.setIcon(currentItemListDisplay.get(index).img);
                    break;
                case SHIELD:
                    MainGUI.rHandPic.setText("");
                    MainGUI.rHandPic.setIcon(currentItemListDisplay.get(index).img);
                    break;
                case ARMOR:
                    Armor a = (Armor)currentItemListDisplay.get(index);
                    switch(a.type){
                        case BOOTS:
                            MainGUI.lBootPic.setText("");
                            MainGUI.lBootPic.setIcon(currentItemListDisplay.get(index).img);
                            MainGUI.rBootPic.setText("");
                            MainGUI.rBootPic.setIcon(currentItemListDisplay.get(index).img);
                            break;
                        case LEGS:
                            MainGUI.leggingsPic.setText("");
                            MainGUI.leggingsPic.setIcon(currentItemListDisplay.get(index).img);
                            break;
                        case HEAD:
                            MainGUI.headPic.setText("");
                            MainGUI.headPic.setIcon(currentItemListDisplay.get(index).img);
                            break;
                        case TORSO:
                            MainGUI.torsoPic.setText("");
                            MainGUI.torsoPic.setIcon(currentItemListDisplay.get(index).img);
                            break;

                    }
                    break;
                case CONSUMEABLE:
                    switch(selectedConsumeableSlot){
                        case 1:
                            MainGUI.Con1Pic.setIcon(currentItemListDisplay.get(index).img);
                            break;
                        case 2:
                            MainGUI.Con2Pic.setIcon(currentItemListDisplay.get(index).img);
                            break;
                        case 3:
                            MainGUI.Con3Pic.setIcon(currentItemListDisplay.get(index).img);
                            break;
                        case 4:
                            MainGUI.Con4Pic.setIcon(currentItemListDisplay.get(index).img);
                            break;
                    }
                    break;
            }
             
        }  
    }
    
    public static void addonInfoPrinter(){
        int index = MainGUI.AddOnList.getSelectedIndex();
        if(index ==0){
             MainGUI.addonDisplay.setText(MainBase.mainbase.display());
             MainGUI.UpgradeDisplayImage.setIcon(null);
        }else if(index!=-1){
             MainGUI.addonDisplay.setText(currentAddonListDisplay.get(index-1).display());
             MainGUI.UpgradeDisplayImage.setIcon(new ImageIcon(currentAddonListDisplay.get(index-1).image));
        }
    }
    
    public static void resourceInfoDisplayer(){
        MainGUI.WoodAmount.setText(Integer.toString(MainBase.mainbase.currentwood));
        MainGUI.IronAmount.setText(Integer.toString(MainBase.mainbase.currentiron));
        MainGUI.LeatherAmount.setText(Integer.toString(MainBase.mainbase.currentleather));
        MainGUI.StoneAmount.setText(Integer.toString(MainBase.mainbase.currentstone));
        MainGUI.IronAmount.setText(Integer.toString(MainBase.mainbase.currentiron));
        MainGUI.SilkAmount.setText(Integer.toString(MainBase.mainbase.currentsilk));
        
    }
    /*public static void displayWeapon(boolean dis){
        if(dis){
            if(fb.imageExists(weapUp)){
                fb.removeImage(weapUp);
            }else if(fb.imageExists(weapDown)){
                fb.removeImage(weapDown);
            }else if(fb.imageExists(weapLeft)){
                fb.removeImage(weapLeft);
            }else if(fb.imageExists(weapRight)){
                fb.removeImage(weapRight);
            }
            switch(Player.mainchar.currentDirection){
                case "up":
                    fb.drawImage(weaponSprite, charx , chary- main.Player.mainchar.imgup.getHeight(null));
                    break;
                case "down":
                    fb.drawImage(weaponSprite, charx , chary+ main.Player.mainchar.imgup.getHeight(null));
                    break;
                case "right":
                    fb.drawImage(weaponSprite, charx+ main.Player.mainchar.imgup.getWidth(null) , chary);
                    break;
               case "left":
                    fb.drawImage(weaponSprite, charx- main.Player.mainchar.imgup.getWidth(null) , chary);
                    break;
            }
        }else{
            if(fb.imageExists(weaponSprite)){
                fb.removeImage(weaponSprite);
            }
        }
    }*/
    
    
    
    
    
    
    
    
}
