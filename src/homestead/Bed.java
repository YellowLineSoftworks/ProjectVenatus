/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homestead;

import display.DisplayHandler;
import display.ImageRetriever;
import main.Player;
import javax.swing.JOptionPane;
import main.ClientEventHandler;
public class Bed extends AddOn{
    public Upgrade current_upgrade;
    
    public Bed(){
        super();
        name = "Bed";
        x = 100;
        y = 200;
        image = new ImageRetriever().getImage("/res/Home Stead/Add Ons/Bed.png");
        init();
    }
    
    
    public void rest(){
        Player.mainchar.currenthealth = Player.mainchar.maxhealth;
        DisplayHandler.moveCharacter("right");
        JOptionPane.showMessageDialog(ClientEventHandler.mgui,  "You have rested");
    }
    
    @Override
    public boolean upgrade(){
        switch(upgradelvl){
            case 1:
                if(MainBase.mainbase.currentsilk > 10 && MainBase.mainbase.currentwood>10){
                    Player.mainchar.maxhealth+=10;
                    MainBase.mainbase.currentsilk-=10;
                    MainBase.mainbase.currentwood-=10;
                    upgradelvl++;
                    super.upgrade();
                    return true;
                }else{
                    return false;
                }
            case 2:
                if(MainBase.mainbase.currentsilk > 25 && MainBase.mainbase.currentwood>25){
                    Player.mainchar.maxhealth+=10;
                    MainBase.mainbase.currentsilk-=25;
                    MainBase.mainbase.currentwood-=25;
                    upgradelvl++;
                    super.upgrade();
                    return true;
                }else{
                    return false;
                }
            case 3:
                if(MainBase.mainbase.currentsilk > 50 && MainBase.mainbase.currentwood>50){
                    Player.mainchar.maxhealth+=10;
                    MainBase.mainbase.currentsilk-=50;
                    MainBase.mainbase.currentwood-=50;
                    upgradelvl++;
                    super.upgrade();
                    return true;
                }else{
                    return false;
                }
            default:
                return true;
        }
    }
    
    @Override
    public String display(){
        String finals = "";
        int healthboost = 0;
        switch(upgradelvl){
            case 1:
                healthboost = 10;
                break;
            case 2:
                healthboost = 20;
                break;
            case 3:
                healthboost = 30;
                break;
            case 4:
                healthboost = 40;
                break;
            
                
        }
        
        finals += "\tBed Add On\n\nUpgrade level: " + upgradelvl + "\nHealth boost: "+upgradelvl;
        
        return finals;
    }

    @Override
    public void activate() {
        rest();
    }
    
    public enum Upgrade{
        
    }
    
}