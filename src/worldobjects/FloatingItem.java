package worldobjects;

import display.DisplayHandler;
import items.Item;
import main.Objects.ActivatableObject;

/**
 * @author Xenith
 */
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
    
    @Override
    public void activate() {
        main.Player.mainchar.addItem(i);
        DisplayHandler.disp.removeImage(imageID);
        super.destroy();
    }
    
}
