/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package display.displayslaves;

import display.gui.AddWorldObjectGUI;
import display.gui.LevelMaker;
import java.util.ArrayList;
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
    public static List<Class> worldObjects = new ArrayList();
    public static List<Class> attackableObjects = new ArrayList();
    public static List<Class> activatableObjects = new ArrayList();
    
    public static Tile tile;
    
    
    public static void main(String[] args){
        makeLists();
        addWorldObject();
        tile = new Tile(1, 0);
    }
    
    public static void initLevelMaker(){
        cgui = new LevelMaker();
        cgui.setVisible(true);
        makeLists();
        tile = new Tile(1, 0);
    }
    
    public static void makeLists(){
        worldObjects.add(AttackableObject.class);
        worldObjects.add(ActivatableObject.class);
        
        attackableObjects.add(Enemy.class);
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
                //Create Enemy
                break;
            case 1:
                tile.addObject(new Bush(Integer.parseInt(worldObjectGUI.xTextField.getText()), 
                        Integer.parseInt(worldObjectGUI.yTextField.getText())));
                System.out.println(1);
                break;
            case 2:
                tile.addObject(new Pot(Integer.parseInt(worldObjectGUI.xTextField.getText()), 
                        Integer.parseInt(worldObjectGUI.yTextField.getText())));
                break;
                
        }
    }
    
}
