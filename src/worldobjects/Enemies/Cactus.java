
package worldobjects.Enemies;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Cactus extends Enemy{
    public Cactus(int x, int y){
        super();
        name = "cactus";
        this.x = x;
        this.y = y;
        
    }

    //AI thread
    @Override
    public void run() {
        while(alive){
            //shoot projecttile
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }
    }
    
    
    
}
