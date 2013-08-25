package worldobjects;

import main.Tile;
import display.DisplayHandler;
import items.Item;
import main.Objects.ActivatableObject;

//Objects that are dropped by world objects that represent an Item in game;
public class FloatingItem extends ActivatableObject {
    
    public Item i;
    
    public FloatingItem(int x, int y, Item i){
        this.x = x;
        this.y = y;
        this.i = i;
        image = i.img.getImage();
        init();
        Tile.currentTile.addObject(this);
    }
    
    //adds item to inventory
    @Override
    public void activate() {
        main.Player.mainchar.addItem(i);
        super.destroy();
    }
    
}
