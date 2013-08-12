/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homestead;

import display.ImageRetriever;
import display.displayslaves.CraftingDisplaySlave;
import items.CraftingItem;
import items.Item;
import items.Shield;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CraftingBench extends AddOn{
    
    public static Image tier1Img = new ImageRetriever().getImage("/res/Home Stead/Add Ons/Alchemy Station");
    
    public CraftingBench(int x, int y){
        this.x = x;
        this.y = y;
        image = tier1Img;
    }
    
    //@Override
    /*public boolean upgrade(){
        switch(upgradelvl){
            case 1:
                
                break;
        }
    }*/

    @Override
    public void activate() {
        CraftingDisplaySlave.createGUI();
    }
    
    
    
    
    
    public enum Recipe{
        WOODEN_SHEILD(Arrays.asList(CraftingItem.CraftItem.WOOD), new Shield(Shield.Shld.WOOD_SHIELD));
        
        List<CraftingItem.CraftItem> reqItems;
        Item returnItem;
        Recipe(List<CraftingItem.CraftItem> l, Item ri){
            reqItems = l;
        }
    }
    
}
