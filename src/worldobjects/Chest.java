

package worldobjects;
import display.ImageRetriever;
import items.Item;
import java.util.ArrayList;
import java.util.List;
import main.Objects.ActivatableObject;

public class Chest extends ActivatableObject{
    
    public List<Item> items = new ArrayList();
    public boolean tiered = true;
    public Chest(int x, int y){
        this.x = x;
        this.y = y;
        image = new ImageRetriever().getImage("/res/World Objects/Chest Closed");
        items = generateItemList();
        init();
        
    }
    
    public Chest(int x, int y,List<Item> is){
        this.x = x;
        this.y = y;
        items = is;
        image = new ImageRetriever().getImage("/res/World Objects/Chest Closed.png");
        tiered=false;
        init();
    }
    
    public List<Item> generateItemList(){
        return new ArrayList();
    }
    
    @Override
    public void activate() {
        display.displayslaves.ChestDisplaySlave.displayChestGUI(this);
    }
    
        
    
}
