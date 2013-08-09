package worldobjects;

import display.ImageRetriever;
import items.Item;
import java.util.ArrayList;
import java.util.List;
import main.Objects.AttackableObject;
import worldobjects.Tile;

/**
 * @author Xenith
 */
public class Pot extends main.Objects.AttackableObject {
    
    public List<Item> items = new ArrayList();
    
    public Pot(int x, int y) {
        health = 1;
        armor = 0;
        image = new ImageRetriever().getImage("/res/World Objects/Pot.png");
        this.x = x;
        this.y = y;
        init();
    }
    
    public Pot(int x, int y, List<Item> items) {
        health = 1;
        armor = 0;
        image = new ImageRetriever().getImage("/res/World Objects/Pot.png");
        this.x = x;
        this.y = y;
        this.items = items;
        init();
    }
    
    @Override
    public void attacked() {
        health -= calculateDamageTaken(armor);
        if (health <= 0) {
            destroy();
        }
    }
    
    @Override
    public void destroy() {
        //Replace the pot with a reward to the player, but only sometimes.
        for(int c = 0; c < items.size(); c++) {
            FloatingItem tempItem = new FloatingItem(x, y, items.get(c));
        }
        System.out.println("Pot destroyed.");
        super.destroy();
    }
    
    

}
