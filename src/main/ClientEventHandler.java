/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import display.gui.MainGUI;
import display.DisplayHandler;
import display.ImageRetriever;
import display.gui.NewGame;
import homestead.MainBase;
import items.Consumeable;
import items.Item;
import items.Shield;
import items.Weapon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Objects.GameObject;
import worldobjects.Bush;
import worldobjects.Chest;
import worldobjects.Pot;


public class ClientEventHandler {
    
    public static MainGUI mgui;
    public static String[] arguments;
    public static Pot pot;
    public static Bush bush;
    
    //Main Game Event Methods:
    public static void main(String[] args) {
        
        arguments = args;
        NewGame ngui = new NewGame();
        //secondaryMain();
    }
    
    public static void secondaryMain() {
        
        mgui = new MainGUI();
        mgui.setVisible(true);
        Player.mainchar = new Player(NewGame.playerName, NewGame.playerClass);
        MainBase.mainbase = new MainBase();
        DisplayHandler.initDisplay();
        HeadsUpDisplay.initializeHUD();
        DisplayHandler.displayStats();
        List<Item> items = new ArrayList();
        items.add(new Shield(Shield.Shld.WOOD_SHIELD));
        pot = new Pot(100, 100, items);
        bush = new Bush(200, 100, items);
        Chest c = new Chest(400, 100,new ArrayList(Arrays.asList(new Consumeable(Consumeable.Cnsm.POTION), new Weapon(Weapon.MagicWeap.FIRE_ROD))));
        
        List<GameObject> objects = new ArrayList();
        List<GameObject> objects2 = new ArrayList();
        objects2.add(new Bush(300, 100));
        
        Tile sTile = new Tile(0, 1, objects2);
        
        objects.add(pot);
        objects.add(c);
        objects.add(bush);
        Tile mainTile = new Tile(0, 0, true, objects);
        mainTile.setCurrentTile();
        //Tile.setCurrentTile("up");
        
        //Test the HUD. Replace those values to satisfaction.
        Player.mainchar.currentmana-=40;
        Player.mainchar.currenthealth-=75;
        HeadsUpDisplay.update();
        
    }
    
}