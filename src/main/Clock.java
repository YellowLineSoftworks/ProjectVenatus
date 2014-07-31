package main;

import display.DisplayHandler;
import display.KeyListen;

/**
 * @author Jack
 */
public class Clock extends game.Clock{
    
    public void init() {
        
    }
    
    public void tick() {
        if (KeyListen.isMoving) {
            DisplayHandler.moveCharacter(main.Player.mainchar.currentDirection);
        }
    }
    
}