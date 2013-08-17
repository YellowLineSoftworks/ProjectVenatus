/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package display.displayslaves;

import display.gui.CraftingGUI;
import display.gui.CraftingListGUI;
import homestead.CraftingBench;
import homestead.CraftingBench.Recipe;
import items.Item;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import main.Player;


public class CraftingDisplaySlave {
    
    public static CraftingGUI gui;
    public static CraftingListGUI listgui;
    public static List<Item> currentItemListDisplay = new ArrayList();
    public static Item[] currentCraftingItems = new Item[3];
    public static Item currentCraftableItem = null;
    public static int currentCraftingSpace;
    public static boolean firstTime = true;
    
    public static void createGUI(){
        gui = new CraftingGUI();
        gui.setVisible(true);
        if(firstTime){
            JOptionPane.showMessageDialog(gui, "Select a crafting box");
            firstTime = false;
        }
    }
    public static void displayList(int craftingSpace){
        listgui = new CraftingListGUI();
        listgui.setVisible(true);
        listgui.listModel.clear();
        currentCraftingSpace =craftingSpace;
        for(int i =0; i<Player.mainchar.items.size();i++){
            if(Player.mainchar.items.get(i).itemtype == Item.Type.RESOURCE){
                listgui.listModel.addElement(Player.mainchar.items.get(i).name);
                currentItemListDisplay.add(Player.mainchar.items.get(i));
            }
        }
    }
    
    
    public static void displayCraftingItem(int index){
        switch(currentCraftingSpace){
            case 1:
                gui.craftOne.setIcon(currentItemListDisplay.get(index).img);
                currentCraftingItems[0] = currentItemListDisplay.get(index);
                break;
            case 2:
                gui.craftTwo.setIcon(currentItemListDisplay.get(index).img);
                currentCraftingItems[1] = currentItemListDisplay.get(index);
                break;
            case 3:
                gui.craftThree.setIcon(currentItemListDisplay.get(index).img);
                currentCraftingItems[2] = currentItemListDisplay.get(index);
                break;
         }
         Recipe[]  recipes = CraftingBench.Recipe.class.getEnumConstants();
         boolean matches = true;
         for(Recipe r:recipes){
             for(int i = 0; i<3; i++){
                 if(r.reqItems[i]!=null && currentCraftingItems[i]!=null){
                     if(!r.reqItems[i].name.equals(currentCraftingItems[i].name)){
                        matches = false;  
                     }
                 }
             }
             if(matches){
                gui.fCraftingSpace.setIcon(r.returnItem.img);
                currentCraftableItem = r.returnItem;
             }
         }
         
    }
    
    public static void craftItem(){
        if(currentCraftableItem!=null){
            Player.mainchar.addItem(currentCraftableItem);
            for(Item i: currentCraftingItems){
                Player.mainchar.removeItem(i);
            }
        }
    }
}
