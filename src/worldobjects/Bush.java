/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package worldobjects;

import display.DisplayHandler;
import display.ImageRetriever;
import items.Item;
import java.util.ArrayList;
import java.util.List;
import main.Objects.AttackableObject;
import main.Player;

/**
 *
 * @author Austin
 */
public class Bush extends AttackableObject{
    
    public List<Item> items = new ArrayList();
    
    //Constructor takes x and y cords for location on tile
    public Bush(int x, int y) {
        health = 1;
        armor = 0;
        image = new ImageRetriever().getImage("/res/World Objects/Bush.png");
        this.x = x;
        this.y = y;
        init();
    }
    
    //Constructor takes a item list to drop when the bush is destroyed
    public Bush(int x, int y, List<Item> items) {
        health = 1;
        armor = 0;
        image = new ImageRetriever().getImage("/res/World Objects/Bush.png");
        this.x = x;
        this.y = y;
        this.items = items;
        init();
    }

    

    @Override
    public void destroy() {
        //Replace the bush with a reward to the player, but only sometimes.
        for(int c = 0; c < items.size(); c++) {
            FloatingItem tempItem = new FloatingItem(x, y, items.get(c));
            Player.mainchar.addXP(5);
        }
        super.destroy();
    }
    
    
}