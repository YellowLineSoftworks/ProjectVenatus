

package display;


import display.gui.MainGUI;
import display.gui.ChestGUI;
import items.Item;
import java.util.ArrayList;
import java.util.List;
import worldobjects.Chest;


public class ChestDisplaySlave {
    
    
    public static List<Item> currentItemListDisplay = new ArrayList();
    static ChestGUI cgui;
    public static worldobjects.Chest currentChest;
    
    public static void displayChestGUI(Chest chest){
            MainGUI.MainTabbedPane.setSelectedComponent(MainGUI.ItemsPanel);
            currentChest = chest;
            cgui = new ChestGUI();
            cgui.setVisible(true);
            displayList();
        }
    
    public static void displayList(){
        
        currentItemListDisplay = currentChest.items;
        cgui.listModel.clear();
        for(int i = 0; i<currentChest.items.size();i ++){
            cgui.listModel.addElement(currentChest.items.get(i).name);        
        }
    }
    
    public static void itemInfoPrinter(){
        int index = cgui.List.getSelectedIndex();
        if(index!= -1){
             cgui.ListDisplay.setText(currentItemListDisplay.get(index).display());
        }
    }
    
    public static void grab(){
        main.Player.mainchar.addItem(currentItemListDisplay.get(cgui.List.getSelectedIndex()));
        
        if(currentItemListDisplay.get(cgui.List.getSelectedIndex()).itemtype != Item.Type.ARMOR){
            DisplayHandler.itemListPrinter(currentItemListDisplay.get(cgui.List.getSelectedIndex()).itemtype);
        }else{
            items.Armor arms = (items.Armor) currentItemListDisplay.get(cgui.List.getSelectedIndex());
            DisplayHandler.itemListPrinter(arms.type);
        }
        currentChest.items.remove(cgui.List.getSelectedIndex());
        displayList();
    }
    
    public static void grabAll(){
        for(int i = 0; i<ChestDisplaySlave.currentItemListDisplay.size(); i++){
            main.Player.mainchar.addItem(ChestDisplaySlave.currentItemListDisplay.get(i));
            if(currentItemListDisplay.get(i).itemtype != Item.Type.ARMOR){
                DisplayHandler.itemListPrinter(currentItemListDisplay.get(i).itemtype);
            }else{
                items.Armor arms = (items.Armor) currentItemListDisplay.get(i);
                DisplayHandler.itemListPrinter(arms.type);
            }
        }
        currentChest.items.clear();
        displayList();
        cgui.dispose();
    }
    
    
}
