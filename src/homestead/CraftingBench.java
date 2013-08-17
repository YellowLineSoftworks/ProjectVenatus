/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homestead;

import display.ImageRetriever;
import display.displayslaves.CraftingDisplaySlave;
import items.ResourceItem;
import items.Item;
import items.ResourceItem.ResItem;
import items.Shield;
import items.Weapon;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CraftingBench extends AddOn{
    
    public static Image tier1Img = new ImageRetriever().getImage("/res/Home Stead/Add Ons/Alchemy Station.png");
    
    public CraftingBench(){
        name = "Crafting Bench";
        x = 500;
        y = 200;
        image = tier1Img;
        init();
    }
    
    @Override
    public boolean upgrade(){
        return false;
    }

    @Override
    public void activate() {
        CraftingDisplaySlave.createGUI();
    }
    
    
    
    
    
    public enum Recipe{
        WOODEN_SHEILD(new Item[] {(Item)new ResourceItem(ResourceItem.ResItem.WOOD),null,null}, new Shield(Shield.Shld.WOOD_SHIELD));
        
        public Item[] reqItems;
        public Item returnItem;
        Recipe(Item[] l, Item ri){
            reqItems = l;
            returnItem = ri;
        }
    }
    
}
