/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package display;

import display.gui.AddWorldObjectGUI;
import display.gui.LevelMaker;
import java.util.ArrayList;
import java.util.List;
import main.Objects.ActivatableObject;
import main.Objects.AttackableObject;
import main.Objects.GameObject;
import worldobjects.Bush;
import worldobjects.Enemies.Enemy;
import worldobjects.Pot;


public class LevelMakerDisplaySlave {
    
    public static LevelMaker cgui;
    public static AddWorldObjectGUI worldObjectGUI;
    public static List<Class> worldObjects = new ArrayList();
    public static List<Class> attackableObjects = new ArrayList();
    public static List<Class> activatableObjects = new ArrayList();
    
    
    public static void main(String[] args){
        initLevelMaker();
    }
    
    public static void initLevelMaker(){
        cgui = new LevelMaker();
        cgui.setVisible(true);
        makeLists();
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
        displayFList();
    }
    
    public static void displayFList(){
        worldObjectGUI.fListModel.clear();
        for(int i = 0; i<worldObjects.size();i++){
            worldObjectGUI.fListModel.addElement(worldObjects.get(i).getSimpleName());        
        }
    }
    
    public static void displaySList(){
        if(worldObjectGUI.sList.getSelectedIndex()==0){
            
        }else if(worldObjectGUI.sList.getSelectedIndex()==1){
            
        }
    }    
    
    
}
