/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homestead;

import main.Objects.ActivatableObject;
import display.Display;
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
     
     public boolean upgrade(){
        display.DisplayHandler.addonInfoPrinter();
        display.DisplayHandler.resourceInfoDisplayer();
        return true;
     }
     
     public String display(){return "";}
     
     public void printImg(){
         Display fb=display.DisplayHandler.disp;
         fb.drawImage(image, x, y);
     }
     
    @Override
     public void destroy(){
         
     }

    @Override
    public abstract void activate();

    
     
     
}
