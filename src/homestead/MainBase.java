 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homestead;

import display.ImageRetriever;
import java.awt.Image;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import main.Objects.ActivatableObject;
import main.Player;
import main.Tile;



public class MainBase extends ActivatableObject{
    
    public int currentsilk = 0;
    public int currentiron=0;
    public int currentleather = 0;
    public int currentstone = 0;
    public int currentwood = 0;
    
    public int baseLevel = 1;
    
    public static Image baseImage1 = new ImageRetriever().getImage("/res/Home Stead/Level1 Hut.png");
    public static Image baseImage2 = new ImageRetriever().getImage("/res/Home Stead/level2 hut.jpg");
    public static Image baseImage3 = new ImageRetriever().getImage("/res/Home Stead/level3 hut.jpg");
    public static Image baseImage4 = new ImageRetriever().getImage("/res/Home Stead/level4 hut.png");
    
    public static MainBase mainbase;
    
    public List<AddOn> addons = new ArrayList();
    public Tile baseTile = new Tile(new ImageRetriever().getImage("/res/Wood Background.png"));
    int defence;
    
    public boolean inBase = false;
    
    public MainBase(boolean display){
        super(baseImage1, 300, 300, display);
        currentsilk+=300;
        currentwood+=2000;
        currentstone+=2000;
        init();
    }
    
    public boolean upgrade(){
        switch(baseLevel){
            case 1:
                if(currentwood >= 50&&currentstone>=50){
                    baseLevel++;
                    changeImage(baseImage2);
                    currentwood-=50;
                    currentstone-=50;
                    display.DisplayHandler.addonInfoPrinter();
                    display.DisplayHandler.resourceInfoDisplayer();
                    return true;
                }else{
                    return false;
                }
            case 2:
                if(currentwood >= 100&&currentstone>=100){
                    baseLevel++;
                    changeImage(baseImage3);
                    currentwood-=100;
                    currentstone-=100;
                    display.DisplayHandler.addonInfoPrinter();
                    display.DisplayHandler.resourceInfoDisplayer();
                    return true;
                }else{
                    return false;
                }
            case 3:
                if(currentwood >= 250&&currentstone>=250){
                    baseLevel++;
                    changeImage(baseImage4);
                    currentwood-=250;
                    currentstone-=250;
                    display.DisplayHandler.addonInfoPrinter();
                    display.DisplayHandler.resourceInfoDisplayer();
                    return true;
                }else{
                    return false;
                }
            default:
                return false;
        }
    }
    
    //Returns info for display on GUI
    public String getUpgradeInfo(){
        String resCount;
        switch(baseLevel){
            case 1:
                resCount = "50 wood and 50 stone";
                break;
            case 2:
                resCount = "100 wood and 100 stone";
                break;
            case 3:
                resCount = "250 wood and 250 stone";
                break;
            default:
                return "\tHome Base\n\nLevel 4\n\nNo further upgrades are\n"
                        + "available";
        }
                
        return "\tHome Base\n\nLevel "+baseLevel+"\n\nYou need: \n" + resCount;
    }
    
    void addAddon(AddOn a){
        addons.add(a);
        baseTile.addObject(a);
    }
    
    public void drawElements(){
        for(int i = 0; i<addons.size();i++){
            addons.get(i).display();
        }
    }
    
    public void enterBase(){
        inBase = true;
        addAddon(new Bed(true));
        addAddon(new Altar());
        addAddon(new CraftingBench(true));
        baseTile.setCurrentTile();
    }
    
    public void exitBase(){
        inBase = false;
        Tile.setCurrentTile(0,0);
    }

    @Override
    public void activate() {
        enterBase();
    }
    
    @Override
    public void destroy(){
        
    }
    
    
        
    
}
