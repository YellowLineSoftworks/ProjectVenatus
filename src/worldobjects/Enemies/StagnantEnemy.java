

package worldobjects.Enemies;

import display.ImageRetriever;
import java.awt.Image;
import javax.swing.ImageIcon;


public class StagnantEnemy extends Enemy{
    
    
    public StagnantEnemy(){
        
    }
    
    public enum Stagen{
        BUSH(new ImageIcon(new ImageRetriever().getImage("")), 10);
        
        ImageIcon img;
        int defence;
        Stagen(ImageIcon i, int d){
            img = i;
            defence = d;
        }
    }
}
