/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package display.displayslaves;

import display.ImageRetriever;
import display.gui.AddWorldObjectGUI;
import display.gui.LevelMaker;
import display.gui.SaveGUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import main.Objects.ActivatableObject;
import main.Objects.AttackableObject;
import main.Objects.GameObject;
import main.Tile;
import worldobjects.Bush;
import worldobjects.Enemies.Enemy;
import worldobjects.Pot;


public class LevelMakerDisplaySlave {
    
    public static LevelMaker cgui;
    public static AddWorldObjectGUI worldObjectGUI;
    public static SaveGUI saveGUI;
    
    public static List<Class> worldObjects = new ArrayList();
    public static List<Class> attackableObjects = new ArrayList();
    public static List<Class> activatableObjects = new ArrayList();
    
    public static Tile tile;
    
    public static boolean saved = false;
    
    public static void main(String[] args){
        /*makeLists();
        addWorldObject();
        tile = new Tile(1, 0);
        display.DisplayHandler.disp.isDev = true;*/
        initLevelMaker();
    }
    
    public static void initLevelMaker(){
        display.DisplayHandler.disp.isDev = true;
        cgui = new LevelMaker();
        cgui.setVisible(true);
        makeLists();
        tile = new Tile(new ImageRetriever().getImage("/res/Grass Background.png"));
        tile.isDev = true;
    }
    
    public static void makeLists(){
        worldObjects.add(AttackableObject.class);
        worldObjects.add(ActivatableObject.class);
        
        attackableObjects.add(Bush.class);
        attackableObjects.add(Pot.class);
    }
    
    public static void addWorldObject() {
        worldObjectGUI = new AddWorldObjectGUI();
        worldObjectGUI.setVisible(true);
        displayFList();
    }
    
    public static void displayFList(){
        worldObjectGUI.fListModel.clear();
        for(int i = 0; i<worldObjects.size();i++){
            worldObjectGUI.fListModel.addElement(worldObjects.get(i).getSimpleName());        
        }
    }
    
    public static void displaySList(){
        worldObjectGUI.sListModel.clear();
        if(worldObjectGUI.fList.getSelectedIndex()==0){
            for(int i= 0; i<attackableObjects.size(); i++){
                worldObjectGUI.sListModel.addElement(attackableObjects.get(i).getSimpleName());
            }
        }else if(worldObjectGUI.fList.getSelectedIndex()==1){
            
        }
    }
    
    public static void addObject(){
        switch(worldObjectGUI.sList.getSelectedIndex()){
            case 0:
                tile.addObject(new Bush(Integer.parseInt(worldObjectGUI.xTextField.getText()), 
                        Integer.parseInt(worldObjectGUI.yTextField.getText())));
                break;
            case 1:
                tile.addObject(new Pot(Integer.parseInt(worldObjectGUI.xTextField.getText()), 
                        Integer.parseInt(worldObjectGUI.yTextField.getText())));
                break;
                
        }
    }
    
    public static void save(){
        HashMap hm = new HashMap();
        hm.put("xCord", Integer.parseInt(saveGUI.xField.getText()));
        hm.put("yCord", Integer.parseInt(saveGUI.yField.getText()));
        tile.location = hm;
        tile.serialize();
        saveGUI.dispose();
    }
}