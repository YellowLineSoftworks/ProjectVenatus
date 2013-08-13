/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package display.displayslaves;

import display.gui.CraftingGUI;
import items.Item;
import java.util.ArrayList;
import java.util.List;
import main.Player;


public class CraftingDisplaySlave {
    
    public static CraftingGUI gui;
    public static List<Item> currentItemListDisplay = new ArrayList();
    public static int currentCraftingSpace;
    
    public static void createGUI(){
        gui = new CraftingGUI();
        gui.setVisible(true);
        displayList(0);
    }
    public static void displayList(int craftingSpace){
        gui.listModel.clear();
        craftingSpace = currentCraftingSpace;
        for(int i =0; i<Player.mainchar.items.size();i++){
            if(Player.mainchar.items.get(i).itemtype == Item.Type.CRAFT){
                gui.listModel.addElement(Player.mainchar.items.get(i).name);
                currentItemListDisplay.add(Player.mainchar.items.get(i));
            }
        }
    }
    
    
    public static void displayCraftingItem(){
        switch(currentCraftingSpace){
            case 1:
                gui.craftOne.setIcon(currentItemListDisplay.get(gui.itemList.getSelectedIndex()).img);
                break;
        }
    }
}
