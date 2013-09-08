/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import java.lang.reflect.Method;
import javax.swing.ImageIcon;
import display.ImageRetriever;


public class Consumeable extends Item{
    public Cnsm thisitem;
    
    public Consumeable(Cnsm ti){
        itemtype = Type.CONSUMEABLE;
        thisitem = ti;
        img = ti.img;
        name = ti.name().replaceAll("_", " ").toLowerCase();
    }
    
    public void useItem(){
        if(thisitem.params == null){
            try {
                thisitem.method.invoke(this);
            } catch (Exception ex) {System.out.println(ex.getMessage());}
        }else{
            try {
                thisitem.method.invoke(this, (Object)thisitem.params);
            } catch (Exception ex) {System.out.println(ex.getMessage());}
            
        }
    }
    
    
    public enum Cnsm{
        POTION("drinkPotion", new ImageIcon(new ImageRetriever().getImage("/res/Items/Consumeables/Health Potion.png")), new String[] {"10"});
        
        ImageIcon img;
        
        Method method;
        String[] params;
        Cnsm(String mname, ImageIcon i){
            img = i;
            try {
                method = Consumeable.Cnsm.class.getMethod(mname);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            } 
        }
        Cnsm(String mname, ImageIcon i, String[] para){
            params = para;
            img = i;
            try {
                method = Consumeable.Cnsm.class.getMethod(mname);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            } 
        }
        
        
        public void drinkPotion(String amount){
            int am = Integer.getInteger(amount);
            main.Player.mainchar.currenthealth+=am;
            if(main.Player.mainchar.currenthealth>main.Player.mainchar.maxhealth){
                main.Player.mainchar.currenthealth = main.Player.mainchar.maxhealth;
            }
        }
    }
}
