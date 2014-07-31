/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import display.gui.MainGUI;
import display.DisplayHandler;
import display.ImageRetriever;
import display.gui.LevelMaker;
import display.gui.NewGame;
import graphics.BufferedDevice;
import homestead.MainBase;
import items.Consumeable;
import items.Item;
import items.Shield;
import items.Weapon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
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
        
    }
    
    public static void secondaryMain() {
        mgui = new MainGUI();
        mgui.setVisible(true);
        Clock clock = new Clock();
        clock.start(48, new BufferedDevice[] {mgui.display});
        Player.mainchar = new Player(NewGame.playerName, NewGame.playerClass);
        MainBase.mainbase = new MainBase(false);
        DisplayHandler.initDisplay();
        MainBase.mainbase.display();
        List<Item> items = new ArrayList();
        items.add(new Shield(Shield.Shld.WOOD_SHIELD));
        pot = new Pot(100, 100, items, true);
        bush = new Bush(200, 100, items, true);
        Chest c = new Chest(400, 100,new ArrayList(Arrays.asList(new Consumeable(Consumeable.Cnsm.POTION), new Weapon(Weapon.MagicWeap.FIRE_ROD))), true);
        Chest c2 = new Chest(300, 400,new ArrayList(Arrays.asList(new Consumeable(Consumeable.Cnsm.POTION), new Weapon(Weapon.Weap.LONG_SWORD))), false);
        List<GameObject> objects = new ArrayList();
        List<GameObject> objects2 = new ArrayList();
        objects2.add(new Bush(300, 100, false));
        objects2.add(c2);
        Tile sTile = new Tile(0, 1, objects2, new ImageRetriever().getImage("/res/Grass Background.png"));
        objects.add(pot);
        objects.add(c);
        objects.add(bush);
        Tile mainTile = new Tile(0, 0, true, objects, new ImageRetriever().getImage("/res/Grass Background.png"));
        mainTile.setCurrentTile();
        JOptionPane.showMessageDialog(mgui, "Use Arrow Keys to move,\n A to attack, and E to activate.\n\n"
                + "There are only two tiles, this one and the one above it.\n\n "
                + "Somtimes you need to reselect the game menu\nin order to activate the controls.");
        //This line always needs to be at the bottom of this function
    }
    
}