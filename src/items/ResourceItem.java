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
public class ResourceItem extends Item{
    
    public ResourceItem(ResItem ci){
         img =ci.img;
         name = ci.name().toLowerCase().replace("_", " ");
         itemtype = Item.Type.RESOURCE;
    }
    public enum ResItem{
        WOOD(new ImageIcon(new ImageRetriever().getImage("/res/Character Sprites/Weapon Sprites/Wooden Shield Sprite.png")));
        ImageIcon img;
        ResItem(ImageIcon i){
            img = i;
        }
    }
}
