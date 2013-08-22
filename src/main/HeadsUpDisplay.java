package main;

import display.DisplayHandler;
import display.ImageRetriever;
import java.util.Arrays;
import javax.swing.JLabel;


public class HeadsUpDisplay {

    private static int healthID = -1;
    private static int healthFrameID = -1;
    private static int manaFrameID = -1;
    private static int manaID = -1;
    private static int expFrameID = -1;
    private static int expID = -1;
    
    public static void initializeHUD() {
        //Initialize the mana bar
        
        //Initialize the health bar
        if (Player.mainchar.maxhealth != 0) {
            float a = (float) Player.mainchar.currenthealth / (float) Player.mainchar.maxhealth;
            int b = (int) (22 * a);
            b++;
            healthFrameID = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Health Bar Frame.png"), 10, 478);
            healthID = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Health Bars/" + b + ".png"), 18, 486);
        }
        if (Player.mainchar.maxmana != 0) { 
            float a = (float) Player.mainchar.currentmana / (float) Player.mainchar.maxmana;
            int b = (int) (22 * a);
            b++;
            manaFrameID = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Health Bar Frame.png"), 300, 478);
            manaID = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Mana Bars/" + b + ".png"), 308, 486);
        }
        if (Player.mainchar.reqXP != 0) { 
            float a = (float) Player.mainchar.experience / (float) Player.mainchar.reqXP;
            int b = (int) (22 * a);
            b++;
            expFrameID = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Health Bar Frame.png"), 612, 478);
            expID = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Exp Bars/" + b + ".png"), 620, 486);
        }
    }
    
    public static void update() {
        updateHealth();
        updateMana();
        //Experience is already updated every time Player.addXP is called
    }

    public static void updateHealth() {
        DisplayHandler.disp.removeImage(healthID);
        if (Player.mainchar.maxhealth != 0) {
            float a = (float) Player.mainchar.currenthealth / (float) Player.mainchar.maxhealth;
            int b = (int) (22 * a);
            b++;
            healthID = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Health Bars/" + b + ".png"), 18, 486);
        }
    }
    
    public static void updateMana() {
        DisplayHandler.disp.removeImage(manaID);
        if (Player.mainchar.maxmana != 0) { 
            float a = (float) Player.mainchar.currentmana / (float) Player.mainchar.maxmana;
            int b = (int) (22 * a);
            b++;
            manaID = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Mana Bars/" + b + ".png"), 308, 486);
        }
    }
    
    public static void updateExperience() {
        DisplayHandler.disp.removeImage(expID);
        if (Player.mainchar.reqXP != 0) { 
            float a = (float) Player.mainchar.experience / (float) Player.mainchar.reqXP;
            int b = (int) (22 * a);
            b++;
            expID = DisplayHandler.disp.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Exp Bars/" + b + ".png"), 620, 486);
        }
    }
    
}