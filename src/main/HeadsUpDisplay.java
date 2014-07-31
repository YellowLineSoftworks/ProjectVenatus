package main;

import display.DisplayHandler;
import display.ImageRetriever;
import java.util.Arrays;
import javax.swing.JLabel;
import resources.Sprite;


public class HeadsUpDisplay {

    private static Sprite healthImage = null;
    private static Sprite healthFrameImage = null;
    private static Sprite manaFrameImage = null;
    private static Sprite manaImage = null;
    private static Sprite expFrameImage = null;
    private static Sprite expImage = null;
    
    public static void initializeHUD() {
        //Initialize the mana bar
        
        //Initialize the health bar
        if (Player.mainchar.maxhealth != 0) {
            float a = (float) Player.mainchar.currenthealth / (float) Player.mainchar.maxhealth;
            int b = (int) (22 * a);
            b++;
            healthFrameImage = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Health Bar Frame.png"), 10, 478);
            healthImage = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Health Bars/" + b + ".png"), 18, 486);
        }
        if (Player.mainchar.maxmana != 0) { 
            float a = (float) Player.mainchar.currentmana / (float) Player.mainchar.maxmana;
            int b = (int) (22 * a);
            b++;
            manaFrameImage = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Health Bar Frame.png"), 300, 478);
            manaImage = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Mana Bars/" + b + ".png"), 308, 486);
        }
        if (Player.mainchar.reqXP != 0) { 
            float a = (float) Player.mainchar.experience / (float) Player.mainchar.reqXP;
            int b = (int) (22 * a);
            b++;
            expFrameImage = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Health Bar Frame.png"), 612, 478);
            expImage = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Exp Bars/" + b + ".png"), 620, 486);
        }
    }
    
    public static void update() {
        updateHealth();
        updateMana();
        //Experience is already updated every time Player.addXP is called
    }

    public static void updateHealth() {
        DisplayHandler.disp.removeImage(healthImage.id);
        if (Player.mainchar.maxhealth != 0) {
            float a = (float) Player.mainchar.currenthealth / (float) Player.mainchar.maxhealth;
            int b = (int) (22 * a);
            b++;
            healthImage = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Health Bars/" + b + ".png"), 18, 486);
        }
    }
    
    public static void updateMana() {
        DisplayHandler.disp.removeImage(manaImage.id);
        if (Player.mainchar.maxmana != 0) { 
            float a = (float) Player.mainchar.currentmana / (float) Player.mainchar.maxmana;
            int b = (int) (22 * a);
            b++;
            manaImage = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Mana Bars/" + b + ".png"), 308, 486);
        }
    }
    
    public static void updateExperience() {
        DisplayHandler.disp.removeImage(expImage.id);
        if (Player.mainchar.reqXP != 0) { 
            float a = (float) Player.mainchar.experience / (float) Player.mainchar.reqXP;
            int b = (int) (22 * a);
            b++;
            expImage = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Exp Bars/" + b + ".png"), 620, 486);
        }
    }
    
}