/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import display.ImageRetriever;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Austin
 */
public class CraftingItem extends Item{
    
    public CraftingItem(CraftItem ci){
         img =ci.img;
         name = ci.name().toLowerCase().replace("_", " ");
    }
    public enum CraftItem{
        WOOD(new ImageIcon(new ImageRetriever().getImage("/res/Items/Character Sprites/Weapon Sprites/Wooden Shield Sprite.png")));
        ImageIcon img;
        CraftItem(ImageIcon i){
            img = i;
        }
    }
}
