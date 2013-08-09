package main;

import display.DisplayHandler;
import display.ImageRetriever;
import java.util.Arrays;
import javax.swing.JLabel;

/**
 *
 * @author Xenith
 */
public class HeadsUpDisplay {

    private static int[] values = new int[]{0, 4, 7, 11, 15, 19, 22, 26, 30, 33, 37, 41, 44, 48, 52, 54, 59, 63, 67, 70, 74, 78, 81, 85, 89, 92, 96, 100};

    public static void initializeHUD() {
        //Initialize the mana bar
        
        //Initialize the health bar
        if (Player.mainchar.maxhealth != 0) {
            float a = (float) Player.mainchar.currenthealth / (float) Player.mainchar.maxhealth;
            int b = (int) (100 * a);
            boolean isInArray = false;
            for (int c = 0; c == values.length; c++) {
                if (b == values[c]) {
                    isInArray = true;
                }
            }
            while (!isInArray) {
                for (int c = 0; c < values.length; c++) {
                    if (b == values[c]) {
                        isInArray = true;
                        break;
                    }
                }
                if (isInArray) {
                    break;
                }
                b++;
            }
            DisplayHandler.fb.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Health/" + b + ".png"), 0, 431);
        }
        
        if (Player.mainchar.maxmana != 0) { 
            float a = (float) Player.mainchar.currentmana / (float) Player.mainchar.maxmana;
            int b = (int) (100 * a);
            
        }
    }

    public static void updateHealth() {
        if (Player.mainchar.maxhealth != 0) {
            float a = (float) Player.mainchar.currenthealth / (float) Player.mainchar.maxhealth;
            int b = (int) (100 * a);
            boolean isInArray = false;
            for (int c = 0; c == values.length; c++) {
                if (b == values[c]) {
                    isInArray = true;
                }
            }
            while (!isInArray) {
                for (int c = 0; c < values.length; c++) {
                    if (b == values[c]) {
                        isInArray = true;
                        break;
                    }
                }
                if (isInArray) {
                    break;
                }
                b++;
            }
            DisplayHandler.fb.drawImage(new ImageRetriever().getImage("/res/Heads Up Display/Health/" + b + ".png"), 0, 431);
        }

    }
    
}