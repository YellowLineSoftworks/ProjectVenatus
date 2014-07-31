package worldobjects;

import display.DisplayHandler;
import display.ImageRetriever;
import items.Item;
import java.util.ArrayList;
import java.util.List;
import main.Objects.AttackableObject;
import main.Player;
import main.Tile;

/**
 * @author Xenith
 */
public class Pot extends main.Objects.AttackableObject {
    
    public List<Item> items = new ArrayList();
    
    //Constructor takes x and y cords
    public Pot(int x, int y, boolean display) {
        super(new ImageRetriever().getImage("/res/World Objects/Pot.png"), x, y, display);
        health = 1;
        armor = 0;
        init();
    }
    
    //Constructor takes a list of items for the pot to drop
    public Pot(int x, int y, List<Item> items, boolean display) {
        super(new ImageRetriever().getImage("/res/World Objects/Pot.png"), x, y, display);
        health = 1;
        armor = 0;
        this.items = items;
        init();
    }
    
    //drops items and gets rid of pot
    @Override
    public void destroy() {
        //Replace the pot with a reward to the player, but only sometimes.
        for(int c = 0; c < items.size(); c++) {
            FloatingItem tempItem = new FloatingItem(x, y, items.get(c));
            Player.mainchar.addXP(5);
        }
        super.destroy();
    }
    
    

}
