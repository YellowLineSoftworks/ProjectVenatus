/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package display;

import display.gui.AddWorldObjectGUI;
import display.gui.LevelMaker;
import main.Objects.GameObject;


public class LevelMakerDisplaySlave {

    
    public static LevelMaker cgui;
    public static AddWorldObjectGUI worldObjectGUI;
    
    public static void main(String[] args){
        initLevelMaker();
    }
    
    public static void initLevelMaker(){
        cgui = new LevelMaker();
        cgui.setVisible(true);
    }
    
    public static void addWorldObject() {
        worldObjectGUI = new AddWorldObjectGUI();
        worldObjectGUI.setVisible(true);
        displayList();
    }
    
    public static void displayList(){
        worldObjectGUI.fListModel.clear();
        for(int i = 0; i<GameObject.objects.size();i ++){
            worldObjectGUI.fListModel.addElement(GameObject.objects.get(i).getClass().getName());        
        }
    }
    
}
