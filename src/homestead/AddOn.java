/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homestead;

import graphics.swing.BufferedJPanel;
import main.Objects.ActivatableObject;
import java.awt.Image;

/**
 *
 * @author Austin
 */
public abstract class AddOn extends ActivatableObject{
     public String name;
     
     int upgradelvl = 1;
     
     public AddOn(){
         super();
     }
     
     public AddOn(Image i, int x, int y, boolean display) {
         super(i, x, y, display);
     }
     
     public boolean upgrade(){
        display.DisplayHandler.addonInfoPrinter();
        display.DisplayHandler.resourceInfoDisplayer();
        return true;
     }
     
    @Override
     public void destroy(){
         
     }

    @Override
    public abstract void activate();

    
     
     
}
