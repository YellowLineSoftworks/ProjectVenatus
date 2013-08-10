/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homestead;

import display.Display;
import display.ImageRetriever;
import java.awt.Image;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import main.Objects.ActivatableObject;



public class MainBase extends ActivatableObject{
    
    public int currentsilk = 0;
    public int currentiron=0;
    public int currentleather = 0;
    public int currentstone = 0;
    public int currentwood = 0;
    
    public int baseLevel = 1;
    
    public Image baseImage1;
    public Image baseImage2;
    public Image baseImage3;
    
    public static MainBase mainbase;
    
    public List<AddOn> addons = new ArrayList();
    int defence;
    
    public MainBase(){
        this.x = 300;
        this.y = 300;
        currentsilk+=300;
        currentwood+=200;
        currentstone+=200;
        test();
        baseImage1 = new ImageRetriever().getImage("/res/Home Stead/level1 hut.png");
        baseImage2 = new ImageRetriever().getImage("/res/Home Stead/level2 hut.jpg");
        baseImage3 = new ImageRetriever().getImage("/res/Home Stead/level3 hut.jpg");
        image = baseImage1;
        init();
        
    }
    
    void test(){
        addAddon(new Bed());
        addAddon(new Altar());
        int a = 1;
    }
    
    public boolean upgrade(){
        switch(baseLevel){
            case 1:
                if(currentwood >= 50&&currentstone>=50){
                    baseLevel++;
                    image = baseImage2;
                    return true;
                }else{
                    return false;
                }
            case 2:
                if(currentwood >= 100&&currentstone>=100){
                    baseLevel++;
                    image = baseImage3;
                    return true;
                }else{
                    return false;
                }
            default:
                return false;
        }
    }
    //Returns info for display on GUI
    public String display(){
        String resCount;
        switch(baseLevel){
            case 1:
                resCount = "50 wood and 50 stone";
                break;
            case 2:
                resCount = "100 wood and 100 stone";
                break;
            default:
                return "\tHome Base\n\nLevel 3\n\nNo further upgrades are\n"
                        + "available";
        }
                
        return "\tHome Base\n\nLevel "+baseLevel+"\n\nYou need: \n" + resCount;
    }
    void addAddon(AddOn a){
        addons.add(a);
    }
    
    public void drawElements(){
        display.DisplayHandler.disp.resetBufferedImage();
        for(int i = 0; i<addons.size();i++){
            addons.get(i).printImg();
        }
    }

    @Override
    public void activate() {
        drawElements();
    }
    
    @Override
    public void destroy(){
        
    }
    
    
        
    
}
