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
        WOODEN_SHEILD(Arrays.asList((Item)new CraftingItem(CraftingItem.CraftItem.WOOD)), new Shield(Shield.Shld.WOOD_SHIELD));
        
        List<Item> reqItems;
        Item returnItem;
        Recipe(List<Item> l, Item ri){
            reqItems = l;
        }
    }
    
}
